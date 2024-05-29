package countdown;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MiniServer {
    private final int portnumber;
    private final ExecutorService executorService = Executors.newCachedThreadPool();

    public MiniServer (int portnumber) {
        this.portnumber = portnumber;
    }

    public void execute() throws IOException {
        ServerSocket serverSocket = new ServerSocket(portnumber);
        System.out.println("Listening on " + portnumber);
        try {
            while (true) {
                System.out.println("Accepting... ");
                Socket clientSocket = serverSocket.accept();
                executorService.execute(() -> {
                    try {
                        System.out.println("connected to " + clientSocket);
                        Service.service(clientSocket);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                });
            }
        } finally {
            serverSocket.close();
        }
    }
}
