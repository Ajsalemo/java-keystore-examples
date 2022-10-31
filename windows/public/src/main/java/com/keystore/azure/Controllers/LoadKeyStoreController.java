package com.keystore.azure.Controllers;

import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadKeyStoreController {
    String message = "loading Key Store..";

    @GetMapping("/api/keystore")
    public String keystore() throws KeyStoreException {
        KeyStore keyStore = KeyStore.getInstance("Windows-MY");
        try {
            keyStore.load(null, null);
            // Public and private certs can be access from the Windows-MY store
            System.out.println("Listing the aliases in the Key Store..");
            System.out.println(keyStore.aliases().nextElement() + "\n");
        } catch (NoSuchAlgorithmException | CertificateException | IOException e) {
            e.printStackTrace();
        }

        return message;
    }
}
