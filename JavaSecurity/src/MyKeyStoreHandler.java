import java.io.*;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * Created by srikanthmannepalle on 9/25/16.
 */
public class MyKeyStoreHandler {
    KeyStore ks;
    private char[] pw;
    private String fname = System.getProperty("user.home") + File.separator + ".keystore";

    // We'll use this to look up the keystore in the default location.
    // You can specify a password if you like, but this will also
    // work if you pass null (in which case the keystore isn't
    // verified).
    public MyKeyStoreHandler(char[] pw) {
        if (pw != null) {
            this.pw = new char[pw.length];
            System.arraycopy(pw, 0, this.pw, 0, pw.length);
        } else {
            this.pw = null;
        }

        // Load from the default location
        try {
            ks = KeyStore.getInstance(KeyStore.getDefaultType());
            FileInputStream fis = new FileInputStream(fname);
            ks.load(fis, pw);
        } catch (Exception e) {
            throw new IllegalArgumentException(e.toString());
        }
    }

    public KeyStore getKeyStore() {
        return ks;
    }

    // Store to the default location
    public void store() throws IOException, CertificateException, NoSuchAlgorithmException, KeyStoreException {
        if (pw ==null) {
            throw new IllegalArgumentException("Can't store w/o password");
        }
        FileOutputStream fos = new FileOutputStream(fname);
        ks.store(fos, pw);
        fos.close();
    }

    public static void main(String[] args) {
        try {
            KeyStore ks  = new MyKeyStoreHandler(null).getKeyStore();
            if (ks.isKeyEntry(args[0])) {
                System.out.print(args[0] + " is a key entry in the keystore");
                char[] c = new char[args[1].length()];
                args[1].getChars(0, c.length, c ,0);
                System.out.println("The private key for " + args[0] + " is " + ks.getKey(args[0], c));
                java.security.cert.Certificate certs[] = ks.getCertificateChain(args[0]);

                if (certs[0] instanceof X509Certificate) {
                    X509Certificate x509 = (X509Certificate) certs[0];
                    System.out.println(args[0] + " is really " + x509.getSubjectDN());
                }

                if (certs[certs.length - 1] instanceof X509Certificate) {
                    X509Certificate x509Certificate = (X509Certificate) certs[certs.length -1];
                    System.out.println(args[0] + " was verified by " + x509Certificate.getIssuerDN());
                }
            } else if (ks.isCertificateEntry(args[0])) {
                System.out.println(args[0] + " is a certificate entry in the keystore");
                java.security.cert.Certificate c = ks.getCertificate(args[0]);
                if (c instanceof X509Certificate) {
                    X509Certificate x509Certificate = (X509Certificate) c;
                    System.out.println(args[0] + " is really " + x509Certificate.getSubjectDN());
                    System.out.println(args[0] + "was verified by " + x509Certificate.getIssuerDN());
                }
            } else {
                System.out.println(args[0] + " is unknown to the keystore");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
