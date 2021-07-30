
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 *
 * @author Fares Abu Ali
 */
public class ThreadedEchoServer implements Runnable {

    Socket clientSocket;

    public ThreadedEchoServer(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        System.out.println("Connected to client using [" + Thread.currentThread() + "]");

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

            String inputLine;

            // read from the client
            while ((inputLine = br.readLine()) != null) { 
                
                System.out.println("Client request [" + Thread.currentThread() + "]: " + inputLine);
                
                // Now write to the client:
                out.println(inputLine);  
                // the same line the server has read, will write it (send it) again. 
                // So the client will feel that the server is     echoing the client’s message (This is the meaning of echo)
            }
            System.out.println("Client [" + Thread.currentThread() + " connection terminated");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }// end method

}// end class
