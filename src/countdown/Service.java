package countdown;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Service {
    private Service() {}

    public static void service(Socket clientSocket) throws IOException {
        System.out.println(Thread.currentThread().getName() + " begin " + clientSocket);
        try {
            DataOutputStream outputStream = new DataOutputStream(clientSocket.getOutputStream());
            outputStream.writeBytes("HTTP/1.0 200 OK\r\n");
            outputStream.writeBytes("Content-type: text/html\r\n");
            outputStream.writeBytes("\r\n");
            outputStream.writeBytes("<html><head>count down</head><body>");
            for (int i = 10; i >= 0; i--) {
                System.out.println(Thread.currentThread().getName() + " count down to " + i);
                outputStream.writeBytes("<h1>" + i + "</h1>");
                outputStream.flush();
                Thread.sleep(1000);
            }
            outputStream.writeBytes("</body></html>");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            clientSocket.close();
        }
        System.out.println(Thread.currentThread().getName() + " end ");
    }

}
