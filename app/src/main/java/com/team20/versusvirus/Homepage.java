package com.team20.versusvirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);
        ImageView nextRecipeImage = findViewById(R.id.nextRecipeImage);
        nextRecipeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, RecipePage.class);
                startActivity(intent);
            }
        });
        ImageView profilePicture = findViewById(R.id.profileImage);
        profilePicture.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, ProfilPage.class);
                startActivity(intent);
            }
        });
        TextView profilelink = findViewById(R.id.myProfileTextView);
        profilelink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, ProfilPage.class);
                startActivity(intent);
            }
        });
        TextView profileName = findViewById(R.id.myNameTextView);
        profileName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Homepage.this, ProfilPage.class);
                startActivity(intent);
            }
        });
    }
}
