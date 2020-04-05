package com.team20.versusvirus;

import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;

public class ChangePwdPage extends AppCompatActivity {

    DatabaseManager dbmanager = new DatabaseManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // ============= RETRIEVE USER
        Gson gson = new Gson();
        final User user = gson.fromJson(getIntent().getStringExtra("user"), User.class);
        if(user == null) {
            Toast.makeText(this, "An error occured", Toast.LENGTH_SHORT).show();
            return;
        }

        EditText editTextCurrentPwd = findViewById(R.id.editTextCurrentPwd);
        EditText editTextNewPwd = findViewById(R.id.editTextNewPwd);
        EditText editTextConfirmPwd = findViewById(R.id.editTextConfirmPwd);

        String currentPwd = editTextCurrentPwd.getText().toString();
        String newPwd = editTextNewPwd.getText().toString();
        String confirmPwd = editTextConfirmPwd.getText().toString();

        Button confirm = findViewById(R.id.buttonConfirmChangePwd);
        confirm.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //dbmanager.
                }
            }
        );

    }
}
