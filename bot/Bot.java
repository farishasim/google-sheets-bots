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
                newMessage();
            } catch (InterruptedException e) {
                this.transmitter.transmit(this);
            }
        }
    }

    private void newMessage() {
        int lowerBound = 97; // 'a'
        int upperBound = 122; //'z'
        int strLength = 8;
        StringBuilder buffer = new StringBuilder(strLength);
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < strLength; i++) {
            char randChar = (char) (lowerBound + (random.nextInt() * (upperBound - lowerBound + 1)));
            buffer.append(randChar);
        }
        message = buffer.toString();
    }
}