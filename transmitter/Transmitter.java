package transmitter;

import bot.Bot;
import writer.Writer;

public class Transmitter {

    private Writer writer;

    public Transmitter(Writer writer) {
        this.writer = writer;
    }
    
    public synchronized void transmit(Bot bot) {
        writer.write(bot.getID(), bot.getMessage());
    }
}
