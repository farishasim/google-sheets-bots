package transmitter;

import bot.Bot;
import writer.Writer;

public class Transmitter {

    private boolean pass1;
    private boolean pass3;
    private Writer writer;

    public Transmitter(Writer writer) {
        this.writer = writer;
        pass1 = false;
        pass3 = false;
    }
    
    public synchronized boolean transmit(Bot bot) {
        int ID = bot.getID();
        String message = bot.getMessage();

        if (ID == 0) {
            if (pass1 && pass3) {
                writer.write(ID, message);
                return true;
            } 
            return false;
        } else {
            if (ID == 1) {
                pass1 = true;
            } else if (ID == 3) {
                pass3 = true;
            } else if (ID == 2) {
                pass1 = false;
                pass3 = false;
            }
            writer.write(ID, message);
            return true;
        }
    }
}
