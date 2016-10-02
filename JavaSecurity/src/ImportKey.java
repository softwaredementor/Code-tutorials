import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by srikanthmannepalle on 9/18/16.
 */
public class ImportKey {
    public static void main(String args[]) {
        try {
            FileInputStream fis = new FileInputStream("exportedKey");
            ObjectInputStream ois = new ObjectInputStream(fis);
            DSAPrivateKeySpec ks = new DSAPrivateKeySpec(
                    (BigInteger) ois.readObject(  ),
                    (BigInteger) ois.readObject(  ),
                    (BigInteger) ois.readObject(  ),
                    (BigInteger) ois.readObject(  ));
            KeyFactory kf = KeyFactory.getInstance("DSA");
            PrivateKey pk = kf.generatePrivate(ks);
            System.out.println("Got private key " + pk.toString()
            + "\nalgorithm = " + pk.getAlgorithm()
            +"\nformat = " + pk.getFormat()
            +"\nclass = " + pk.getClass());
            X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(pk.getEncoded());
            System.out.println("Got private key " + x509EncodedKeySpec.toString()
                    +"\nformat = " + x509EncodedKeySpec.getFormat()
                    +"\nclass = " + x509EncodedKeySpec.getClass());
        } catch (Exception e) {
            e.printStackTrace(  );
        }
    }
}
