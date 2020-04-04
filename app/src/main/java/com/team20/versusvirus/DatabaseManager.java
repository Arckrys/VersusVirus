package com.team20.versusvirus;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.annotation.NonNull;

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
    public void writeUser(User user) {
        String userId = user.username;
        userDatabase.child(userId).setValue(user);
    }

    // ====================== GET USER FROM DATABASE & CHANGE ACTIVITY
    public void getUser(final Context context, String username, final String password) {
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                User user = dataSnapshot.getValue(User.class);
                if(user == null) {
                    Toast.makeText(context, "The user does not exist :(", Toast.LENGTH_SHORT).show();
                    return;
                }
                System.out.println("<MSG> Request ok ");
                // Check password
                if(!password.equals(user.password)) {
                    Toast.makeText(context, "Wrong password !", Toast.LENGTH_SHORT).show();
                    return;
                }

                // Change the activity => GO TO HOMEPAGE
                // We pass a user instance as a json-formatted string
                Intent intent = new Intent(context, Homepage.class);
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

