import java.util.ArrayList;
import java.util.List;

import bot.Bot;
import bot.Bot0;
import bot.Bot1;
import bot.Bot2;
import bot.Bot3;
import transmitter.Transmitter;
import writer.ConsoleWriter;
import writer.Writer;

public class Main {
    public static void main(String[] args) {
        Writer myWriter = new ConsoleWriter();
        Transmitter transmitter = new Transmitter(myWriter);

        List<Bot> bots = new ArrayList<>(4);

        bots.add(new Bot0(transmitter));
        bots.add(new Bot1(transmitter));
        bots.add(new Bot2(transmitter));
        bots.add(new Bot3(transmitter));

        for (Bot bot : bots) {
            bot.start();
        }
    }
}
