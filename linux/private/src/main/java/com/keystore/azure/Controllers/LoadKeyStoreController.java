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
        KeyStore keyStore = KeyStore.getInstance("jks");
        try {
            char[] password = "changeit".toCharArray();

            keyStore.load(
                    new FileInputStream(System.getenv("JRE_HOME") + "/lib/security/cacerts"),
                    password);

            System.out.println("Listing the KeyStore alias name..");
            System.out.println(keyStore.aliases().nextElement() + "\n");
        } catch (NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }

        return message;
    }
}
