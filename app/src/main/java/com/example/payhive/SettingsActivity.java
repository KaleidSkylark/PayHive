package com.example.payhive;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class SettingsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        ImageButton ibStats = findViewById(R.id.ibStats);
        ibStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, StatsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton ibWallet = findViewById(R.id.ibWallet);
        ibWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, WalletActivity.class);
                startActivity(intent);
            }
        });

        ImageButton imageButtonBack = findViewById(R.id.imageButtonBack);
        imageButtonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SettingsActivity.this, WalletActivity.class);
                startActivity(intent);
            }
        });
    }
}
