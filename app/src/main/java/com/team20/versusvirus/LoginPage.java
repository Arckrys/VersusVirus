package com.team20.versusvirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Timestamp;
import java.util.List;

public class LoginPage extends AppCompatActivity {

    public class Ingredient{
        public Integer Id_ingredient;
        public Double Quantity;
        public String Quantifier, Type, name;

    }
    public class  Recipe{
        public Integer Id_Recipe,prepTim,cookTime,difficulty;
        public String image,title, Language,description;
        public Timestamp Date;
        public List<Ingredient> Ingredients;
        public List<String> Steps;


    }
    public class User{
        public String description, Password, username, email, name, birthday, Photo, Langue;
        public List<Recipe> UpcomingRecipe, CreatedRecipe, PastRecipe;
        public List<String> Friends_id;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);
        Button connexionButton = findViewById(R.id.connexionButton);
        connexionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginPage.this, Homepage.class);
                startActivity(intent);
            }
        });

        TextView createAccountText = findViewById(R.id.createAccountText);
        createAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
