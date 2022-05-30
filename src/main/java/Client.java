import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main (String[] args) {
        int port = 8080;
        String host = "netology.homework";
        Scanner input = new Scanner(System.in);
        try (Socket socket = new Socket(host, port);
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            System.out.println(in.readLine());
            out.println(input.next());
            System.out.println(in.readLine());
            out.println(input.next());
            System.out.println(in.readLine());
            out.println(input.next());
            System.out.println(in.readLine());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
