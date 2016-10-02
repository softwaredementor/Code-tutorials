package sample;

import javax.net.SocketFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by srikanthmannepalle on 9/26/16.
 */
public class MySecureClient {
    public static void main(String[] args) throws IOException {
        SocketFactory sf = SocketFactory.getDefault();
        Socket s = sf.createSocket(args[0], Integer.parseInt(args[1]));
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter pw = new PrintWriter(s.getOutputStream());
        System.out.println("Who is John");
        pw.println("Who is John");
        pw.flush();
        System.out.println(br.readLine());
        s.close();
    }
}
