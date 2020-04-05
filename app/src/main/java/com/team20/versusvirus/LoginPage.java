package com.team20.versusvirus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.firebase.FirebaseError;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

import com.team20.versusvirus.DatabaseManager;

public class LoginPage extends AppCompatActivity {

    private DatabaseManager dbmanager = new DatabaseManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        Button connexionButton = findViewById(R.id.connexionButton);
        connexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText username = findViewById(R.id.emailEditText);
                EditText pwd = findViewById(R.id.passwordEditText);
                // Fetch username in database and change activity if succeded
                dbmanager.getUser(LoginPage.this,
                        username.getText().toString(), pwd.getText().toString());
            }
        });

        TextView createAccountText = findViewById(R.id.createAccountText);
        createAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, RegisterPage.class);
                startActivity(intent);

                /*
                // You should also change the targeted activity in DatabaseManager line 62
                // Note that the targeted activity will be transmitted a json-formatted string for the user !

                // Create hard-coded user, this will be replaced when we'll have registration page
                User user = new User(
                        "C'est gourmant, c'est crocant.", "",
                        "cyril", "", "Cyril Lignac", "01.01.1990",
                        "https://production-livingdocs-bluewin-ch.imgix.net/2019/11/20/d80d7f3d-d07c-467b-815e-8910a05a0ad6.jpeg?w=1024&auto=format",
                        "French"

                );

                // Check if user exists
                // If the user exists, we will restart the activity and send the current information
                // on the user (we can retrieve all information, no need to type everything again)
                dbmanager.getUser(LoginPage.this, user.username, "", true);

                dbmanager.writeUser(user);

                */
            }
        });
    }
}
