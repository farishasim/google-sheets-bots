package bot;

import transmitter.Transmitter;

public class Bot0 extends Bot {

    public Bot0(Transmitter transmitter) {
        super(0, transmitter);
        message = "Bot 0";
    }

    @Override
    public void run() {
        while (true) {
            while (!this.transmitter.transmit(this)) ; // busy wait jika bot 0 belum bisa mengirim pesan
            int randint = random.nextInt(10);
            try {
                sleep(randint*1000);
                newMessage();
            } catch (InterruptedException e) {
                this.transmitter.transmit(this);
            }
        }
    }
}