# java-keystore-examples
Examples of accessing the Java Keystore on Azure App Service Linux and Windows for Java SE (Spring Boot) with Private and Public certificates

Steps to run:

1. Import a Public or Private certificate, depending on the example being ran to the App Service
2. Add the App Setting [WEBSITE_LOAD_CERTIFICATE](https://learn.microsoft.com/en-us/azure/app-service/configure-ssl-certificate-in-code#load-certificate-in-windows-apps)  with the thumbprint of the certificate that is being loaded
