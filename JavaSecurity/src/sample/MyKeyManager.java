package sample;

import javax.net.ssl.X509KeyManager;
import java.net.Socket;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.Principal;
import java.security.PrivateKey;
import java.security.cert.X509Certificate;
import java.util.Vector;

/**
 * Created by srikanthmannepalle on 10/3/16.
 */
public class MyKeyManager implements X509KeyManager {
    protected String alias;
    protected KeyStore ks;
    protected char[] pw;
    private String type;
    private String issuer;

    public MyKeyManager(String alias, KeyStore ks, char[] pw) {
        this.alias = alias;
        this.ks = ks;
        this.pw = pw;
        try {
            java.security.cert.Certificate certificate = ks.getCertificate(alias);
            this.type = certificate.getPublicKey().getAlgorithm();
            issuer = ((X509Certificate) certificate).getIssuerDN().getName();
        } catch (Exception e) {
            throw new IllegalArgumentException(alias + " has a bad key");
        }
    }

    @Override
    public String[] getClientAliases(String type, Principal[] issuers) {
        String[] aliases;
        String alias = chooseClientAlias(type, issuers);
        if (alias == null) {
            aliases = new String[0];
        } else {
            aliases = new String[1];
            aliases[0] = alias;
        }
        return aliases;
    }

    public String chooseClientAlias(String type, Principal[] issuers) {
        if (!type.equals(this.type)) {
            return null;
        }
        if (issuers == null) {
            return alias;
        }
        for (int i = 0; i < issuers.length; i++) {
            if (this.issuer.equals(issuers[i].getName())) {
                return alias;
            }
        }
        return null;
    }

    public String chooseServerAlias(String type, Principal[] issuers) {
        return chooseClientAlias(type, issuers);
    }

    @Override
    public String[] getServerAliases(String type, Principal[] issuers) {
        return getClientAliases(type, issuers);
    }

    // Get the certificates -- make sure each is an X509Certificate
    // before copying it into the array.
    @Override
    public X509Certificate[] getCertificateChain(String alias) {
    try {
        java.security.cert.Certificate[] certificates = this.ks.getCertificateChain(alias);
        Vector c2 = new Vector(certificates.length);
        for (int i = 0; i < certificates.length; i++) {
            c2.add(certificates[i]);
        }
        return (X509Certificate[]) c2.toArray(new X509Certificate[0]);
    } catch (KeyStoreException e) {
        return null;
    }
    }

    @Override
    public PrivateKey getPrivateKey(String alias) {
        try {
            return (PrivateKey) ks.getKey(alias, this.pw);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public String chooseClientAlias(String[] strings, Principal[] principals, Socket socket) {
        return null;
    }

    @Override
    public String chooseServerAlias(String s, Principal[] principals, Socket socket) {
        return null;
    }
}
