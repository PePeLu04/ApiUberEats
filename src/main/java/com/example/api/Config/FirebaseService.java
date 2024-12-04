package com.example.api.Config;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.FileInputStream;

@Service
public class FirebaseService {

    @PostConstruct
    public void initializeFirebase() throws Exception {
        FileInputStream serviceAccount =
                new FileInputStream("src/main/resources/keysb.json");

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://quickbite-89f37-default-rtdb.firebaseio.com")
                .build();

        FirebaseApp.initializeApp(options);
    }


}
