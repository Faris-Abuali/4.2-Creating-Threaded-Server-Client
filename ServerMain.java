
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Fares Abu Ali
 */
public class ServerMain {

    public static void main(String[] args) throws InterruptedException {

        try {
            ServerSocket ss = new ServerSocket(6000);
            
            while (true) {
                System.out.println("Waiting for connection on my localport: " + ss.getLocalPort() + "...");
                Socket clientSocket = ss.accept();
                //System.out.println("Accepted connection from client: " + clientSocket);

                ThreadedEchoServer tes = new ThreadedEchoServer(clientSocket);
                new Thread(tes).start(); // will invoke method 'run()' in class ThreadedEchoServer
                
                Thread.sleep(500);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }// end main
}// end class
