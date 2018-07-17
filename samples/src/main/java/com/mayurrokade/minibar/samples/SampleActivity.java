package com.mayurrokade.minibar.samples;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.widget.Button;

import com.mayurrokade.minibar.MinibarView;
import com.mayurrokade.minibar.UserMessage;

public class SampleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);
        getSupportActionBar().setTitle("Minibar Demo");

        final Button button = findViewById(R.id.button);
        final MinibarView alertView = findViewById(R.id.minibarView);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (alertView.isShowing()) {
                    // then dismiss
                    button.setText("Show Message");
                    alertView.dismiss();
                } else {
                    // show the view
                    button.setText("Hide Message");

                    UserMessage userMessage = new UserMessage.Builder()
                            .setBackgroundColor(R.color.colorSuccess)
                            .setTextColor(android.R.color.white)
                            .setMessage("You have 128 unread messages.")
                            .setShowInterpolator(new BounceInterpolator())
                            .setDismissInterpolator(new AccelerateInterpolator())
                            .build();

                    alertView.show(userMessage);
                }
            }
        });
    }
}
