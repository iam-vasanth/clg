package EX8;
    import java.io.*;
    import java.net.*;

public class MessageClient {
    public static void main(String[] args) throws IOException {
        String serverIP = "127.0.0.1"; // Use IP of server machine if remote
        int port = 12345;

        Socket socket = new Socket(serverIP, port);
        System.out.println("Connected to server");

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Hello from the client!");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String serverReply = in.readLine();
        System.out.println("Reply from server: " + serverReply);

        in.close();
        out.close();
        socket.close();
    }
}