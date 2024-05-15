package autosave;

public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        SaverThread saverThread = new SaverThread(data);
        ChangerThread changerThread = new ChangerThread(data);

        new Thread(saverThread).start();
        new Thread(changerThread).start();
    }
}
