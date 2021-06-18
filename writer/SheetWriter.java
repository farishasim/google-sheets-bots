package writer;
public class SheetWriter implements Writer{

    private int counter;

    public SheetWriter() {
        counter = 0;
    }

    @Override
    public void write(int ID, String message) {
        // TODO Auto-generated method stub
        counter++;
        
    }
}
