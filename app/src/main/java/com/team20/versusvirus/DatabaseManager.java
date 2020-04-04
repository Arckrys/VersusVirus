package com.team20.versusvirus;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

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

    // ====================== GET USER FROM DATABASE
    public void getUser(String username) {
        ValueEventListener listener = new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                System.out.println("<MSG> Request ok");
                User user = dataSnapshot.getValue(User.class);
                if(user == null) {
                    System.out.println("<MSG> user does not exist");
                    return;
                }
                System.out.println("<MSG> Request ok " + user.description);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("<MSG> This did not work");
            }
        };

        userDatabase.child(username).addListenerForSingleValueEvent(listener);
    }

}

