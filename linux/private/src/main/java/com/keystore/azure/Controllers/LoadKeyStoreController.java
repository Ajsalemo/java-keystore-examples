package com.keystore.azure.Controllers;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadKeyStoreController {
    String message = "loading Key Store..";

    @GetMapping("/api/keystore")
    public String keystore() throws KeyStoreException {
        KeyStore keyStore = KeyStore.getInstance("pkcs12");
        try {
            char[] password = "changeit".toCharArray();
            KeyStore.ProtectionParameter entryPassword
                = new KeyStore.PasswordProtection(password);

            keyStore.load(
                    new FileInputStream(System.getenv("JRE_HOME") + "/lib/security/client.jks"),
                    password);

            System.out.println("Listing the KeyStore alias name..");
            System.out.println(keyStore.aliases().nextElement() + "\n");
            // The Alias required for the getEntry argument is the Certificate thumbprint
            // CERTIFICATE_THUMBPRINT is an arbitrary App Setting to be manually set to the thumbprint
            System.out.println(keyStore.getEntry(System.getenv("CERTIFICATE_THUMBPRINT"), entryPassword));
            System.out.println(keyStore.containsAlias(System.getenv("CERTIFICATE_THUMBPRINT")));
        } catch (NoSuchAlgorithmException | CertificateException | IOException | UnrecoverableEntryException e) {
            e.printStackTrace();
        }

        return message;
    }
}
