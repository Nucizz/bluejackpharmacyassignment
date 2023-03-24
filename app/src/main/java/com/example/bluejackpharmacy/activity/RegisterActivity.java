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

import java.util.regex.Pattern;

public class RegisterActivity extends Activity {

    EditText nameText, emailText, passwordText, confirmPasswordText, phoneText;
    Button registerBtn, goToLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        nameText = findViewById(R.id.nameFormField);
        emailText = findViewById(R.id.emailFormField);
        passwordText = findViewById(R.id.passwordFormField);
        confirmPasswordText = findViewById(R.id.confirmPasswordFormField);
        phoneText = findViewById(R.id.phoneFormField);
        registerBtn = findViewById(R.id.loginButton);
        goToLogin = findViewById(R.id.loginPageButton);

        registerBtn.setOnClickListener(e -> {registerValidate();});
        goToLogin.setOnClickListener(e -> {toLoginActivity();});
    }

    String nameHandler(String text) {
        String[] parts = text.toLowerCase().split(" ");
        String newName = "";

        for(String word : parts) {
            newName += Character.toUpperCase(word.charAt(0)) + word.substring(1) + " ";
        }

        return newName.substring(0, newName.length()-1);
    }

    String emailHandler(String text) {
        String newEmail = text.toLowerCase();

        if(newEmail.endsWith(".com") && newEmail.contains("@")){
            return newEmail;
        }
        return null;
    }

    String passwordHandler(String text) {
        Pattern regex = Pattern.compile("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,20}$");

        if(regex.matcher(text).matches()){
            return text;
        }
        return null;
    }

    String phoneHandler(String text) {
        String newPhone = "";
        int len = text.length();

        if(text.charAt(0) == '+') {
            text = text.substring(1);
            len -= 1;
        }

        for(int i=0;i<len;i++) {
            char curr = Character.toUpperCase(text.charAt(i));
            if(Character.isDigit(curr)) {
                newPhone += String.valueOf(curr);
            } else if (curr == '-' || curr == ' ') {
                continue;
            } else {
                return null;
            }
        }

        int newLen = newPhone.length();

        if(newLen < 5 || newLen > 15) {
            return null;
        }

        return newPhone;
    }

     void registerValidate() {
        String name = nameText.getText().toString();
        String email = emailText.getText().toString();
        String password = passwordText.getText().toString();
        String confirmPassword = confirmPasswordText.getText().toString();
        String phone = phoneText.getText().toString();

         if(name.isEmpty() || email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || phone.isEmpty()) {
             Toast.makeText(getApplicationContext(), "Please fill in all the forms", Toast.LENGTH_SHORT).show();
             return;
         }

        name = nameHandler(name);
         if(name == null) {
             Toast.makeText(getApplicationContext(), "Invalid name (5 - 32 characters)", Toast.LENGTH_SHORT).show();
            return;
         }

        email = emailHandler(email);
        if(email == null) {
            Toast.makeText(getApplicationContext(), "Invalid email (Max 32 characters)", Toast.LENGTH_SHORT).show();
            return;
        }

        password = passwordHandler(password);
        if(password == null) {
            Toast.makeText(getApplicationContext(), "Invalid password (Alphanumeric, 8 - 20 characters)", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!password.equals(confirmPassword)) {
            Toast.makeText(getApplicationContext(), "Passwords don't match", Toast.LENGTH_SHORT).show();
            return;
        }

        phone = phoneHandler(phone);
         if(phone == null) {
             Toast.makeText(getApplicationContext(), "Invalid phone number", Toast.LENGTH_SHORT).show();
             return;
         }

         User newUser = new User(Data.userList.size()+1, name, email, User.hashPassword(password), phone);
         Data.userList.add(newUser);
         User.setUser(newUser);
         startActivity(new Intent(this, HomeActivity.class));
         Toast.makeText(getApplicationContext(), "Register success", Toast.LENGTH_SHORT).show();
    }

    public void toLoginActivity(){
        finish();
    }
}