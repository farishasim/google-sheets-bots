package bot;

import transmitter.Transmitter;
import java.util.Random;

public class Bot extends Thread {
    protected int ID;
    protected Transmitter transmitter;
    protected String message;
    protected Random random;

    public Bot(int ID, Transmitter transmitter) {
        this.ID = ID;
        this.transmitter = transmitter;
        random = new Random(System.currentTimeMillis() * ID);
        newMessage();
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
            int randint = random.nextInt(10);
            try {
                sleep(randint*1000);
                newMessage();
            } catch (InterruptedException e) {
                this.transmitter.transmit(this);
            }
        }
    }

    protected void newMessage() {
        int lowerBound = 97; // 'a'
        int upperBound = 122; //'z'
        int strLength = 8;
        StringBuilder buffer = new StringBuilder(strLength);
        for (int i = 0; i < strLength; i++) {
            char randChar = (char) (lowerBound + (random.nextInt(upperBound-lowerBound)));
            buffer.append(randChar);
        }
        message = buffer.toString();
    }
}