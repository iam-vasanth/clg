package EX8;
import java.io.*;
import java.net.*;

public class MessageServer {
    public static void main(String[] args) throws IOException {
        int port = 12345;
        ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Server is waiting for client on port " + port + "...");

        Socket socket = serverSocket.accept();
        System.out.println("Connected to client: " + socket.getInetAddress());

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String clientMessage = in.readLine();
        System.out.println("Message from client: " + clientMessage);

        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        out.println("Message received successfully!");

        in.close();
        out.close();
        socket.close();
        serverSocket.close();
    }
}