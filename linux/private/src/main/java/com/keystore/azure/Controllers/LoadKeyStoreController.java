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
            String keyStoreAlias = System.getenv("KEY_STORE_ALIAS");
            String keyStorePassword = System.getenv("KEY_STORE_PASSWORD");
            String firstKeyAlias = System.getenv("FIRST_KEY_ALIAS");
            String secondKeyAlias = System.getenv("SECOND_KEY_ALIAS");
            

            char[] password = (keyStorePassword).toCharArray();
            KeyStore.ProtectionParameter entryPassword 
                = new KeyStore.PasswordProtection(password); 

            keyStore.load(
                new FileInputStream("keystore.jks"),
                keyStoreAlias.toCharArray());

            System.out.println("Listing the KeyStore alias name..");
            System.out.println(keyStore.aliases().nextElement() + "\n");
            System.out.println("Printing information about a KeyStore key..");
            System.out.println(keyStore.getKey(firstKeyAlias, password) + "\n");
            System.out.println("Printing information about a KeyStore entry..");
            System.out.println(keyStore.getEntry(secondKeyAlias, entryPassword) + "\n");

        } catch (NoSuchAlgorithmException | CertificateException | IOException | UnrecoverableEntryException e) {
            e.printStackTrace();
        }

        return message;
    }
}
