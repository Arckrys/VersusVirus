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

public class LoginPage extends AppCompatActivity {

    public class Ingredient{
        public Integer id_ingredient;
        public Double quantity;
        public String quantifier, type, name;
        public Ingredient() {}
    }
    public class  Recipe{
        public Integer id_Recipe,prepTim,cookTime,difficulty;
        public String image,title, language,description;
        public Timestamp date;
        public List<Ingredient> ingredients;
        public List<String> steps;
        public Recipe() {}
    }
    public class User{
        public String description, password, username, email, name, birthday, photo, language;
        public List<Recipe> upcomingRecipe, createdRecipe, pastRecipe;
        public List<String> friends_id;
        public User() {}
    }

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
                testAccessDatabase();
            }
        });

        TextView createAccountText = findViewById(R.id.createAccountText);
        createAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

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



    }
}
