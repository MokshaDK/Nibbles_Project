package com.example.nibbles_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {

    EditText profileName, profileEmail, profileAge;
    Button saveProfileButton;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        profileName = findViewById(R.id.profile_name);
        profileEmail = findViewById(R.id.profile_email);
        profileAge = findViewById(R.id.profile_age);
        saveProfileButton = findViewById(R.id.profile_save_button);

        sharedPreferences = getSharedPreferences("UserProfile", MODE_PRIVATE);

        // Load existing user profile data
        loadProfileData();

        // On save button click, save profile data
        saveProfileButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = profileName.getText().toString();
                String email = profileEmail.getText().toString();
                String age = profileAge.getText().toString();

                if (name.isEmpty() || email.isEmpty() || age.isEmpty()) {
                    Toast.makeText(profile.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                } else {
                    // Save the user profile data using SharedPreferences
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("name", name);
                    editor.putString("email", email);
                    editor.putString("age", age);
                    editor.apply();

                    Toast.makeText(profile.this, "Profile Updated Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(profile.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });
    }

    private void loadProfileData() {
        // Load the saved profile data from SharedPreferences
        String name = sharedPreferences.getString("name", "");
        String email = sharedPreferences.getString("email", "");
        String age = sharedPreferences.getString("age", "");

        profileName.setText(name);
        profileEmail.setText(email);
        profileAge.setText(age);
    }
}
