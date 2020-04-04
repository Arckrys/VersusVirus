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
                /*
                Intent intent = new Intent(LoginPage.this, Homepage.class);
                startActivity(intent);
                 */
                dbmanager.getUser("jeanmi");
            }
        });

        TextView createAccountText = findViewById(R.id.createAccountText);
        createAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User user = new User(
                        "J'aime la choucroute", "123456789",
                        "jeanmi", "jeanmi@email.com", "Jean-michel", "01.01.1990",
                        "", "francé"
                );
                dbmanager.writeUser(user);
            }
        });
    }

    private void testAccessDatabase() {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        DatabaseReference usersRef = mDatabase.child("users");

        String userId = "jeanmi";


        // WRITE IN DATABASE
        /*
        List<String> list = Arrays.asList(new String[]{"foo", "bar"});
        User user = new User("Jean-Michel", "J'aime la choucroute", list);
        usersRef.child(userId).setValue(user);
         */
        /*
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                EditText edit = findViewById(R.id.emailEditText);
                edit.setText(user.name);
                System.out.println("<MSG> Should work");
                System.out.println(user.description);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("<MSG> This did not work");
            }
        };

        DatabaseReference userRef = usersRef.child(userId);
        userRef.addListenerForSingleValueEvent(listener);
        */


    }
}
