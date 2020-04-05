package com.team20.versusvirus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.gson.Gson;

import java.security.Timestamp;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DatabaseManager {
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference userDatabase = database.child("users");
    private DatabaseReference recipeDatabase = database.child("recipes");


    // ===================== SAVE USER INTO DATABASE
    public void writeUser(final Context context, final User user) {
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User fetchedUser = dataSnapshot.getValue(User.class);

                if(fetchedUser == null) {
                    System.out.println("You should be registered");
                    String userId = user.username;
                    userDatabase.child(userId).setValue(user);
                    Toast.makeText(context, "You are now registered ! You can log in.", Toast.LENGTH_SHORT).show();
                    context.startActivity(new Intent(context, LoginPage.class));
                } else {
                    // The user exists and we start the register page again
                    Toast.makeText(context, "The user already exists !", Toast.LENGTH_SHORT).show();
                    // We pass a user instance as a json-formatted string
                    Gson gson = new Gson();
                    String jsonUser = gson.toJson(fetchedUser);
                    Intent intent = new Intent(context, RegisterPage.class);
                    intent.putExtra("user", jsonUser);
                    context.startActivity(intent);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, "The registration request was cancelled", Toast.LENGTH_SHORT).show();
            }
        };

        userDatabase.child(user.username).addListenerForSingleValueEvent(listener);
    }

    // ====================== GET USER FROM DATABASE & CHANGE ACTIVITY
    public void getUser(final Context context, String username, final String password) {
        getUser(context, username, password, false);
    }

    public void getUser(final Context context, String username, final String password, final Boolean checkExists) {
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if(user == null) {
                    Toast.makeText(context, "The user does not exist :(", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Check password
                if(!password.equals(user.password)) {
                    Toast.makeText(context, "Wrong password !", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Change the activity: go to homepage, except if we just wanted to check if user existed
                Intent intent;
                intent = new Intent(context, Homepage.class);
                // We pass a user instance as a json-formatted string
                Gson gson = new Gson();
                String jsonUser = gson.toJson(user);
                intent.putExtra("user", jsonUser);
                context.startActivity(intent);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                Toast.makeText(context, "The login request was cancelled", Toast.LENGTH_SHORT).show();
            }
        };

        userDatabase.child(username).addListenerForSingleValueEvent(listener);
    }

}

