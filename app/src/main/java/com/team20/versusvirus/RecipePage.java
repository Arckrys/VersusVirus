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


        testStorage();
    }

    private void testStorage() {
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
                        Bitmap img = BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
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

    }
}
