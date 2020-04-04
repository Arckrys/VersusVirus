package com.team20.versusvirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class ProfilPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil_page);

        // ========= RETRIEVE USER INSTANCE
        Gson gson = new Gson();
        final User user = gson.fromJson(getIntent().getStringExtra("user"), User.class);

        // ========= UPDATE USER INFORMATION
        TextView textViewUsername = findViewById(R.id.textView);
        textViewUsername.setText(user.name);
        EditText editTextDesc = findViewById(R.id.editText);
        editTextDesc.setText(user.description);

        ImageView imageView = findViewById(R.id.imageView);
        // THIS MAKES THE APP CRASH !!!!
        //Picasso.get().load(user.photo).into(imageView);

        // ========= CHANGE ACTIVITY
        Button backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilPage.this, Homepage.class);
                startActivity(intent);
            }
        });
        Button disconnectButton = findViewById(R.id.disconnectButton);
        disconnectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilPage.this, LoginPage.class);
                startActivity(intent);
            }
        });
        Button shoppingListButton = findViewById(R.id.ingredientListButton);
        shoppingListButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfilPage.this, ShoppingList.class);
                startActivity(intent);
            }
        });
    }
}
