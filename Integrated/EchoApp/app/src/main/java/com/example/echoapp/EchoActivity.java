package com.example.echoapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.example.echoapp.databinding.ActivityEchoBinding;

public class EchoActivity extends AppCompatActivity {

    private static final String TAG = "EchoActivity";
    private ActivityEchoBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: EchoActivity created successfully");

        // Inflate using ViewBinding
        binding = ActivityEchoBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d(TAG, "onCreate: Layout inflated and views initialized");

        // Get the message from the intent
        Intent receivedIntent = getIntent();
        String message = receivedIntent.getStringExtra("USER_MESSAGE");
        Log.d(TAG, "onCreate: Extracted message = '" + message + "'");

        // Display the message
        if (message != null && !message.isEmpty()) {
            binding.tvEchoMessage.setText(message);
            Log.i(TAG, "onCreate: Message displayed successfully");
        } else {
            binding.tvEchoMessage.setText("No message received");
            Log.w(TAG, "onCreate: No message found in intent extras");
        }

        // Set up back button
        binding.btnBack.setOnClickListener(v -> {
            Log.i(TAG, "btnBack: User clicked the Back button");
            finish();
        });

        Log.d(TAG, "onCreate: Back button listener attached");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}