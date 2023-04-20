package com.example.payhive;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;


public class WalletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        ImageButton ibStats = findViewById(R.id.ibStats);
        ibStats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalletActivity.this, StatsActivity.class);
                startActivity(intent);
            }
        });

        ImageButton ibSettings = findViewById(R.id.ibSettings);
        ibSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(WalletActivity.this, SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
}
