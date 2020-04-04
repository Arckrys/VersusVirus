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
                User user = new User(
                        "J'aime la choucroute", "",
                        "dummy", "dummy@dummy.com", "Dummy", "01.01.1990",
                        "", ""

                );
                dbmanager.writeUser(user);
            }
        });
    }
}
