package com.example.payhive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText mUsernameEditText;
    private EditText mPasswordEditText;
    private CheckBox mShowPasswordCheckBox;
    private Button mLoginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize views
        mUsernameEditText = findViewById(R.id.InputUser);
        mPasswordEditText = findViewById(R.id.InputPassword);
        mShowPasswordCheckBox = findViewById(R.id.showPasswordCheckBox);
        mLoginButton = findViewById(R.id.login_button);

        // Set click listener for login button
        mLoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get input values
                String username = mUsernameEditText.getText().toString();
                String password = mPasswordEditText.getText().toString();

                // Check if username and password are valid (hardcoded for demonstration purposes)
                if (username.equals("admin") && password.equals("admin")) {
                    // Credentials are valid, open WalletActivity
                    startActivity(new Intent(MainActivity.this, WalletActivity.class));
                } else {
                    // Show error message
                    Toast.makeText(MainActivity.this, "Invalid username or password", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set click listener for show password checkbox
        mShowPasswordCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                if (isChecked) {
                    // Show password
                    mPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                } else {
                    // Hide password
                    mPasswordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
    }
}