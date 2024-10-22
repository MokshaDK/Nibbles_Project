package com.example.nibbles_project;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class profile extends AppCompatActivity {

    private EditText inputWeight, inputHeight, inputAge;
    private Spinner inputGender;
    private Switch inputNicotine;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        inputWeight = findViewById(R.id.inputWeight);
        inputHeight = findViewById(R.id.inputHeight);
        inputAge = findViewById(R.id.inputAge);
        inputGender = findViewById(R.id.inputGender);
        inputNicotine = findViewById(R.id.inputNicotine);
        saveButton = findViewById(R.id.saveButton);

        saveButton.setOnClickListener(v -> saveProfileData());
    }

    private void saveProfileData() {
        String weight = inputWeight.getText().toString();
        String height = inputHeight.getText().toString();
        String age = inputAge.getText().toString();
        String gender = inputGender.getSelectedItem().toString();
        boolean nicotineExposure = inputNicotine.isChecked();

        // You can now save this data or process it as needed.
        // For example, display a confirmation:
        Toast.makeText(this, "Profile Saved", Toast.LENGTH_SHORT).show();

        // You can also store this data in SharedPreferences or a local database.
    }
}

