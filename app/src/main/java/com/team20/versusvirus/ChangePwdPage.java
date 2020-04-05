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
        setContentView(R.layout.activity_change_pwd);

        // ============= RETRIEVE USER
        Gson gson = new Gson();
        final User user = gson.fromJson(getIntent().getStringExtra("user"), User.class);
        if(user == null) {
            Toast.makeText(this, "An error occured", Toast.LENGTH_SHORT).show();
            return;
        }

        final EditText editTextCurrentPwd = findViewById(R.id.editTextCurrentPwd);
        final EditText editTextNewPwd = findViewById(R.id.editTextNewPwd);
        final EditText editTextConfirmPwd = findViewById(R.id.editTextConfirmPwd);

        Button confirm = findViewById(R.id.buttonConfirmChangePwd);
        confirm.setOnClickListener(
            new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final String currentPwd = editTextCurrentPwd.getText().toString();
                    final String newPwd = editTextNewPwd.getText().toString();
                    final String confirmPwd = editTextConfirmPwd.getText().toString();
                    System.out.println("<MSG> " + currentPwd + "*" + user.password);
                    if(newPwd.equals(confirmPwd)) {
                        if(currentPwd.equals(user.password))
                            dbmanager.changePwd(ChangePwdPage.this, user, newPwd);
                        else
                            Toast.makeText(ChangePwdPage.this, "The current password is wrong", Toast.LENGTH_SHORT).show();
                    } else
                        Toast.makeText(ChangePwdPage.this, "The passwords do not match !", Toast.LENGTH_SHORT).show();
                }
            }
        );

    }
}
