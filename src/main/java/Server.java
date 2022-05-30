import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main (String[] args) {
        String name;
        boolean isChild;
        String fomCountry;
        int port = 8080;
        try (ServerSocket serverSocket = new ServerSocket(port);
             Socket clientSocket = serverSocket.accept();
             PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()))) {
            out.println("What's your name?");
            name = in.readLine();
            out.println("Where are you from (country)?");
            fomCountry = in.readLine();
            out.println("Are you child?");
            isChild = in.readLine().equalsIgnoreCase("yes");
            if (isChild) {
                out.println(String.format("Welcome to the kids area, %s, from %s! Let's play!", name, fomCountry));
            } else {
                out.println(String.format("Welcome to the adult zone, %s, from %s! Have a good rest, or a good working day!",
                        name, fomCountry));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
