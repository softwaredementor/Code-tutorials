import java.security.AlgorithmParameters;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/**
 * Created by srikanthmannepalle on 9/18/16.
 */
public class MyKeyPairGeneratorClass extends KeyPairGenerator {

    public MyKeyPairGeneratorClass() {
        super("DSA");
    }

    public void main(String[] args) throws NoSuchAlgorithmException {
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("RSA");
        kpg.initialize(512);
        KeyPair kp = kpg.generateKeyPair();
    }
}
