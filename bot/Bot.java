package bot;

import transmitter.Transmitter;
import java.util.Random;

public class Bot extends Thread {
    protected int ID;
    protected Transmitter transmitter;
    protected String message;

    public Bot(int ID, Transmitter transmitter) {
        this.ID = ID;
        this.transmitter = transmitter;
        message = "Default Bot";
    }

    public String getMessage() {
        return message;
    }

    public int getID() {
        return ID;
    }

    @Override
    public void run() {
        while (true) {
            this.transmitter.transmit(this);
            int randint = (new Random(System.currentTimeMillis())).nextInt(10);
            try {
                sleep(randint*1000);
            } catch (InterruptedException e) {
                this.transmitter.transmit(this);
            }
        }
    }
}