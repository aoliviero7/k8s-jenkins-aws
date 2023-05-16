package com.jhooq.Jhooqk8s.ws;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.io.File;
import java.io.FileOutputStream;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazonaws.services.s3.model.S3Object;

@RestController
public class Test2DockerDemoController {

    @GetMapping("/secondo")
    public String secondo() {
        return "Hello test secondo 2 - Jhooq-k8s i Have updated the message";
    }
    
    @GetMapping("/test2")
    public String test2() {
        return "Hello test test2 2 - Jhooq-k8s i Have updated the message";
    }
    
     @GetMapping("/test2/secondo")
    public String testsecondo() {
        return "Hello test test2/secondo 2 - Jhooq-k8s i Have updated the message";
    }
    
    @GetMapping("/test2/bucket")
    public byte[] bucket() {
        String accessKey = "AKIAV6ZL64I3L4CRWPHC";
        String secretKey = "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";
        String bucketName = "test-bucket-aleoliv";
        String objectKey = "unisa.png"; // Nome del file nell'bucket
        
        // Crea le credenziali di accesso
        BasicAWSCredentials credentials = new BasicAWSCredentials(accessKey, secretKey);

        // Crea un client Amazon S3
        AmazonS3 s3Client = AmazonS3ClientBuilder.standard()
                            .withCredentials(new AWSStaticCredentialsProvider(credentials))
                            .build();

        // Esegue la richiesta per ottenere l'oggetto dall'Amazon S3
        S3Object s3Object = s3Client.getObject(new GetObjectRequest(bucketName, objectKey));

        // Specifica il percorso di destinazione per salvare l'immagine
        String destinationPath = "image/" + objectKey;

        // Scarica l'oggetto e salvalo come file locale
        try {
            File destinationFile = new File(destinationPath);
            FileOutputStream outputStream = new FileOutputStream(destinationFile);
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = s3Object.getObjectContent().read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
            outputStream.close();
            System.out.println("Immagine scaricata con successo!");
            return buffer;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    
    @GetMapping("/")
    public String rroot() {
        return "ROOT 2 - Jhooq-k8s i Have updated the message";
    }
}
