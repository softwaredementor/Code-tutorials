import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.SecureRandom;
import java.security.spec.DSAPrivateKeySpec;
import java.security.spec.RSAPrivateKeySpec;

/**
 * Created by srikanthmannepalle on 9/18/16.
 */
public class ExportKey {
    public static void main(String args[]) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
            kpg.initialize(512, new SecureRandom(  ));
            KeyPair kp = kpg.generateKeyPair(  );

            Class spec = Class.forName(
                    "java.security.spec.DSAPrivateKeySpec");
            KeyFactory kf = KeyFactory.getInstance("DSA");

            DSAPrivateKeySpec ks = (DSAPrivateKeySpec)
                    kf.getKeySpec(kp.getPrivate(  ), spec);

            FileOutputStream fos = new FileOutputStream("exportedKey");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(ks.getX(  ));
            oos.writeObject(ks.getP(  ));
            oos.writeObject(ks.getQ(  ));
            oos.writeObject(ks.getG(  ));
            System.out.println("Private key encoded value = " + kp.getPrivate().getEncoded());
            System.out.println("Public key encoded value = " + kp.getPublic().getEncoded());

        } catch (Exception e) {
            e.printStackTrace(  );

        }
    }
}
