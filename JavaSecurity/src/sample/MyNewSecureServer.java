package sample;

import javax.net.ServerSocketFactory;
import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;


public class MyNewSecureServer extends Thread {
    private Socket sock;

    public MyNewSecureServer(Socket s ) {
        this.sock = s;
    }

    public static void main(String[] args) throws Exception {
        SSLContext sslContext = SSLContext.getInstance("TLS");
        KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
        KeyStore ks = KeyStore.getInstance("jks");
        char[] password = args[1].toCharArray();
        ks.load(new FileInputStream(args[0]), null);
        kmf.init(ks, password);
        sslContext.init(kmf.getKeyManagers(), null, null);
        ServerSocketFactory ssf = sslContext.getServerSocketFactory();
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
