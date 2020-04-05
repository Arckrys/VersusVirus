package com.team20.versusvirus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class Homepage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_page);

        // ============= RETRIEVE USER
        Gson gson = new Gson();
        final User user = gson.fromJson(getIntent().getStringExtra("user"), User.class);

        // ========= UPDATE USER INFORMATION
        TextView textViewUsername = findViewById(R.id.myNameTextView);
        textViewUsername.setText(user.name);

        // ============== SET ACTIONS
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
                goToProfilePage(user);
            }
        });
        TextView profilelink = findViewById(R.id.myProfileTextView);
        profilelink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProfilePage(user);
            }
        });
        TextView profileName = findViewById(R.id.myNameTextView);
        profileName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToProfilePage(user);
            }
        });


        // ============ SET FLAGS
        ImageView flagFrance = findViewById(R.id.flagFr);
        ImageView flagGermany = findViewById(R.id.flagGe);
        final ImageView flagItaly = findViewById(R.id.flagIt);
        final ImageView flagUK = findViewById(R.id.flagEn);
    }

    private void goToProfilePage(User user) {
        Intent intent = new Intent(Homepage.this, ProfilPage.class);
        Gson gson = new Gson();
        String jsonUser = gson.toJson(user);
        intent.putExtra("user", jsonUser);
        startActivity(intent);
    }

}
