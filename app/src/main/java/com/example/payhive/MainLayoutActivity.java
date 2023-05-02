package com.example.payhive;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class MainLayoutActivity extends AppCompatActivity {

    private boolean isButtonTapped = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mainlayout);

        TextView fragmentTitle = findViewById(R.id.fragment_title);

        ImageButton ibWallet = findViewById(R.id.ibWallet);
        ImageButton ibStats = findViewById(R.id.ibStats);
        ImageButton ibTransaction = findViewById(R.id.ibTransaction);
        ImageButton ibSettings = findViewById(R.id.ibSettings);
        ImageButton[] buttons = new ImageButton[]{ibWallet, ibStats, ibTransaction, ibSettings};

        Animation scaleAnimation = AnimationUtils.loadAnimation(this, R.anim.scale_animation);

        scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                isButtonTapped = true;
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isButtonTapped = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });

        View.OnClickListener onClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isButtonTapped) {
                    v.startAnimation(scaleAnimation);
                    for (ImageButton button : buttons) {
                        button.setSelected(button.getId() == v.getId());
                    }
                    // Handle tap event here
                    int viewId = v.getId();
                    if (viewId == R.id.ibWallet) {
                        fragmentTitle.setText("Wallet");
                        loadFragment(new WalletFragment());
                    } else if (viewId == R.id.ibStats) {
                        fragmentTitle.setText("Statistics");
                        loadFragment(new StatsFragment());
                    } else if (viewId == R.id.ibTransaction) {
                        fragmentTitle.setText("Exchange");
                        // Load TransactionFragment
                    } else if (viewId == R.id.ibSettings) {
                        fragmentTitle.setText("Settings");
                        loadFragment(new SettingsFragment());
                    }
                }
            }
        };
        for (ImageButton button : buttons) {
            button.setOnClickListener(onClickListener);
        }

        // Load the WalletFragment by default
        loadFragment(new WalletFragment());
    }

    private void loadFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameLayout, fragment)
                .commit();
    }
}
