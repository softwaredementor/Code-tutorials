package sample;

import javax.net.ssl.KeyManager;
import javax.net.ssl.KeyManagerFactorySpi;
import javax.net.ssl.ManagerFactoryParameters;
import javax.net.ssl.SSLSession;
import java.security.*;

/**
 * Created by srikanthmannepalle on 10/3/16.
 */
public class MyKeyManagerFactory extends KeyManagerFactorySpi {
    char[] pw;
    KeyStore ks;
    String alias;

    public MyKeyManagerFactory() {
       alias = System.getProperty("xyz.aliasname");
       if (alias == null) {
           throw new IllegalArgumentException("Must specify alias property");
       }
    }

    @Override
    protected KeyManager[] engineGetKeyManagers() {
        MyKeyManager[] km = new MyKeyManager[1];
        km[0] = new MyKeyManager(alias, ks, pw);
        return km;
    }

    @Override
    protected void engineInit(KeyStore keyStore, char[] chars) throws KeyStoreException, NoSuchAlgorithmException, UnrecoverableKeyException {
        this.ks = keyStore;
        this.pw = chars;
        System.arraycopy(pw, 0, this.pw, 0, pw.length);
    }

    @Override
    protected void engineInit(ManagerFactoryParameters managerFactoryParameters) throws InvalidAlgorithmParameterException {

    }
}
