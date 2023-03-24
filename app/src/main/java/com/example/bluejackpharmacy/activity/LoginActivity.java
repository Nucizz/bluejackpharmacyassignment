package com.example.bluejackpharmacy.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.bluejackpharmacy.Data;
import com.example.bluejackpharmacy.R;
import com.example.bluejackpharmacy.object.User;

public class LoginActivity extends Activity{

    EditText emailText, passwordText;
    Button loginBtn, goToRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        emailText = findViewById(R.id.emailFormField);
        passwordText = findViewById(R.id.passwordFormField);
        loginBtn = findViewById(R.id.loginButton);
        goToRegister = findViewById(R.id.registerPageButton);

        loginBtn.setOnClickListener(e -> {loginValidate();});
        goToRegister.setOnClickListener(e -> {toRegisterActivity();});
    }

    void loginValidate() {
        String email = emailText.getText().toString().toLowerCase();
        String password = passwordText.getText().toString();

        if(email.isEmpty() || password.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Invalid empty forms!", Toast.LENGTH_SHORT).show();
        } else {
            for(User user : Data.userList) {
                if(user.getEmail().matches(email)) {
                    if(user.getHashed().matches(User.hashPassword(password))) {
                        User.setUser(user);
                        startActivity(new Intent(this, HomeActivity.class));
                        Toast.makeText(getApplicationContext(), "Login success", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        break;
                    }
                }
            }
            Toast.makeText(getApplicationContext(), "Wrong username/password", Toast.LENGTH_SHORT).show();
        }

    }

    public void toRegisterActivity(){
        startActivity(new Intent(this, RegisterActivity.class));
    }

}