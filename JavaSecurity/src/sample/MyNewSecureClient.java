package sample;

import sun.security.x509.X500Name;

import javax.net.SocketFactory;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.security.cert.X509Certificate;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by srikanthmannepalle on 9/26/16.
 */
public class MyNewSecureClient {
    public static void main(String[] args) throws IOException {
        SocketFactory sf = SSLSocketFactory.getDefault();
        //SSLSocket sslSocket = (SSLSocket) sf.createSocket(args[0],Integer.parseInt(args[1]));
        SSLSocket sslSocket = (SSLSocket) sf.createSocket("localhost", 8999);

        SSLSession sess = sslSocket.getSession();
        String host = sess.getPeerHost();
        System.out.println("Hostname = " + host);
        X509Certificate[] certificates = sess.getPeerCertificateChain();
        String dn = certificates[0].getSubjectDN().getName();
        System.out.println("Subject DN = " + dn);
        X500Name name = new X500Name(dn);
        if (!host.equals(name.getCommonName())) {
            System.out.println("Warning: Expected " + host + " and got " + name.getCommonName());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(sslSocket.getInputStream()));
        PrintWriter pw = new PrintWriter(sslSocket.getOutputStream());
        System.out.println("Who is John");
        pw.println("Who is John");
        pw.flush();
        System.out.println(br.readLine());
        sslSocket.close();
    }
}
