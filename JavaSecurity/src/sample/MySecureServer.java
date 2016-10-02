package sample;

import javax.net.ServerSocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by srikanthmannepalle on 9/26/16.
 */
public class MySecureServer extends Thread {

    private Socket sock;

    public MySecureServer(Socket s ) {
        this.sock = s;
    }
    public static void main(String[] args) throws IOException {
        ServerSocketFactory ssf = ServerSocketFactory.getDefault();
        ServerSocket ss = ssf.createServerSocket(9096);
        while (true) {
            new MySecureServer(ss.accept()).start();
        }
    }

    public void run() {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(sock.getInputStream()));
            PrintWriter pw = new PrintWriter(sock.getOutputStream());
            String data = br.readLine();
            pw.println("what is he ?");
            sock.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
