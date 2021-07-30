
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class Client {

    public static void main(String[] args) {

        try {

            Socket clientSocket = new Socket("localhost", 6000);
            System.out.println("Conneted to server on port: " + 6000);

            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            Scanner sc = new Scanner(System.in);

            while (true) {

                System.out.print("Enter text: ");
                String inputLine = sc.nextLine();

                if (inputLine.equals("quit")) {
                    clientSocket.close();
                    break;
                }

                out.println(inputLine);
                String response = br.readLine();
                System.out.println("Server response: " + response);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }// end main
}// end class
