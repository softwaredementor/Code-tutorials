package sample;

import javax.net.ServerSocketFactory;
import java.io.*;
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
        System.setProperty("javax.net.ssl.keyStore", File.separator + "Users"
                + File.separator + "srikanthmannepalle"
                + File.separator + ".keystore");
        System.setProperty("javax.net.ssl.keyStorePassword", "srikanth");
        System.out.println(System.getProperty("javax.net.ssl.keyStore"));
        ServerSocketFactory ssf = ServerSocketFactory.getDefault();
        ServerSocket ss = ssf.createServerSocket(8999);
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
            pw.close();
            sock.close();
        } catch (final Exception e) {
            e.printStackTrace();
        }
    }
}
