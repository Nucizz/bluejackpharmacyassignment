package com.example.bluejackpharmacy;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.bluejackpharmacy.activity.LoginActivity;
import com.example.bluejackpharmacy.object.User;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        load();
        Data.quickInit();
        startActivity(new Intent(this, LoginActivity.class));
    }

    @Override
    protected void onDestroy() {
        save();
        super.onDestroy();
    }

    public void save() {
        try {
            FileOutputStream user_data = openFileOutput(Data.USER_FILE, MODE_PRIVATE);
            String saveText = new String();

            for (User user : Data.userList) {
                saveText += user.getId() + ";" + user.getName() + ";" + user.getEmail() + ";" + user.getHashed() + ";" + user.getPhone() + "\n";
            }

            user_data.write(saveText.getBytes());
            Toast.makeText(getApplicationContext(), "Save success!", Toast.LENGTH_SHORT).show();
            user_data.close();
        }
        catch (Exception e1) {
            Toast.makeText(getApplicationContext(), "Save failed!", Toast.LENGTH_SHORT).show();
        }
    }

    public void load() {
        try {
            FileInputStream user_data = openFileInput(Data.USER_FILE);
            BufferedReader reader = new BufferedReader(new InputStreamReader(user_data));
            String currentLine;

            while((currentLine = reader.readLine()) != null) {
                String []data = currentLine.split(";");
                Data.userList.add(new User(Integer.parseInt(data[0]), data[1], data[2], data[3], data[4]));
            }

            user_data.close();
        }
        catch (FileNotFoundException e1) {
            try {
                FileOutputStream newFile = openFileOutput(Data.USER_FILE, MODE_PRIVATE);
                newFile.write("".getBytes());
                newFile.close();
            } catch (IOException e3) {
                Toast.makeText(getApplicationContext(), "File generated!", Toast.LENGTH_SHORT).show();
            }
        }
        catch (Exception e2) {
            Toast.makeText(getApplicationContext(), "Load failed!", Toast.LENGTH_SHORT).show();
        }
    }
}