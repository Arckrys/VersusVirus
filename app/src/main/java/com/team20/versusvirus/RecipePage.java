package com.team20.versusvirus;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class RecipePage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe_page);
        Button joinButton = findViewById(R.id.joinButton);
        joinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecipePage.this, LivePage.class);
                startActivity(intent);
            }
        });


        //testStorage();
        //testDatabase();
    }

    private void testDatabase() {
        // https://firebase.google.com/docs/database/android/start

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference liveSessions = database.getReference("live_session");

    }

    /*private void testStorage() {
        // Create the storage
        FirebaseStorage storage = FirebaseStorage.getInstance();
        // https://firebase.google.com/docs/storage/android/create-reference
        // Create the reference singleton instance
        StorageReference storageRef = storage.getReference();
        // Create reference to recipe images
        // recipe images are in the folder /img/recipe/
        StorageReference recipeRef = storageRef.child("img/recipe");

        // Reference to specific image
        StorageReference chickenRef = recipeRef.child("chicken-cacciatore-one-pot.jpg");

        final long ONE_MEGABYTE = 1024 * 1024;

        chickenRef.getBytes(2 * ONE_MEGABYTE).addOnSuccessListener(
                new OnSuccessListener<byte[]>() {
                    @Override
                    public void onSuccess(byte[] bytes) {
                        // This loads the image into memory
                        // This would be better to store the images into a temporary file
                        // and load it from there
                        Bitmap img = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
                        // Display the image from memory
                        ImageView imgView = findViewById(R.id.imageView);
                        imgView.setImageBitmap(img);
                    }
                }
        ).addOnFailureListener(
                new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        System.out.println("ERROR LOADING THE IMG");
                    }
                }
        );

    }*/
}
