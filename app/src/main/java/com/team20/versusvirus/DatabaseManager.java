package com.team20.versusvirus;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.Timestamp;
import java.util.List;

public class DatabaseManager {
    private DatabaseReference database = FirebaseDatabase.getInstance().getReference();
    private DatabaseReference userDatabase = database.child("users");
    private DatabaseReference recipeDatabase = database.child("recipes");


    // ====================== GET USER FROM DATABASE
    public void writeUser(User user) {
        String userId = user.username;
        userDatabase.child(userId).setValue(user);
    }

    // ===================== SAVE USER INTO DATABASE
    public User currentUser;
    public User getUser(String username) {
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                currentUser = dataSnapshot.getValue(User.class);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("<MSG> This did not work");
            }
        };
        DatabaseReference userToFind = userDatabase.child(username);
        userToFind.addListenerForSingleValueEvent(listener);

        return currentUser;
    }

}

