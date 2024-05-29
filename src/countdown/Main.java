package countdown;

import java.io.IOException;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException {
        new MiniServer(8888).execute();
    }
}
