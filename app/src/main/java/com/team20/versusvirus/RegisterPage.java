package com.team20.versusvirus;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.gson.Gson;

import org.w3c.dom.Text;

public class RegisterPage extends AppCompatActivity {

    private DatabaseManager dbmanager = new DatabaseManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_page);

        final CheckBox enBox = (CheckBox) findViewById(R.id.enBox);
        final CheckBox frBox = (CheckBox) findViewById(R.id.frBox);
        final CheckBox itBox = (CheckBox) findViewById(R.id.itBox);

        Button registerButton = findViewById(R.id.registerButton);

        TextInputEditText textInputEditTextName = findViewById(R.id.name);
        TextInputEditText textInputEditTextEmail = findViewById(R.id.email);
        TextInputEditText textInputEditTextBirthday = findViewById(R.id.birthday);
        TextInputEditText textInputEditTextDesc = findViewById(R.id.personalDescription);
        TextInputEditText textInputEditTextUrl = findViewById(R.id.url);

        // ============= RETRIEVE USER
        Gson gson = new Gson();
        final User user = gson.fromJson(getIntent().getStringExtra("user"), User.class);
        if(!(user == null)) {
            // Is we are provided a User here, that means it already exists in the database
            textInputEditTextEmail.setText(user.email);
            textInputEditTextDesc.setText(user.description);
            textInputEditTextUrl.setText(user.photo);
            textInputEditTextBirthday.setText(user.birthday);
            textInputEditTextName.setText(user.name);
        }
        else
            System.out.println("<MSG> the user is null");

        // =============== MANAGE REGISTRATION

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String langauge = "English";

                if (enBox.isChecked()) {
                    langauge = "English";

                }else if(frBox.isChecked()){
                    langauge = "French";

                }else if (itBox.isChecked()){
                    langauge = "Italian";

                };

                TextView userName = findViewById(R.id.username);
                String userNamestr =  userName.getText().toString();

                TextView name = findViewById(R.id.name);
                String namestr =  name.getText().toString();

                TextView email = findViewById(R.id.email);
                String emailstr =  email.getText().toString();

                TextView password = findViewById(R.id.password);
                String passwordstr=  password.getText().toString();

                TextView birthday = findViewById(R.id.birthday);
                String birthdaystr =  birthday.getText().toString();

                TextView personalDescription = findViewById(R.id.personalDescription);
                String personalDescriptionstr =  personalDescription.getText().toString();

                TextView url = findViewById(R.id.url);
                String urlstr =  url.getText().toString();

                User user = new User(
                        personalDescriptionstr, passwordstr,
                        userNamestr, emailstr, namestr, birthdaystr,
                        urlstr,langauge

                );
                dbmanager.writeUser(RegisterPage.this, user);

            }

        });


        enBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frBox.setChecked(false);
                itBox.setChecked(false);
            }
        });

        frBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enBox.setChecked(false);
                itBox.setChecked(false);
            }
        });

        itBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frBox.setChecked(false);
                enBox.setChecked(false);
            }
        });


    }
}

