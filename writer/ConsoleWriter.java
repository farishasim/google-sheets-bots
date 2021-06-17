package writer;
public class ConsoleWriter implements Writer{
    @Override
    public void write(int ID, String message) {
        System.out.print(ID);
        System.out.println(" " + message);
    }
}
