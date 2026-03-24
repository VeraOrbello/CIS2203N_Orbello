package com.example.echoapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.example.echoapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(TAG, "onCreate: MainActivity created successfully");

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        Log.d(TAG, "onCreate: Layout inflated and views initialized");

        // Send Message button
        binding.btnSendMessage.setOnClickListener(v -> {
            Log.i(TAG, "btnSendMessage: User clicked Send Message button");
            sendMessage();
        });

        // Share button (Bonus)
        binding.btnShare.setOnClickListener(v -> {
            Log.i(TAG, "btnShare: User clicked Share button");
            shareMessage();
        });

        Log.d(TAG, "onCreate: Button listeners attached");
    }

    private void sendMessage() {
        String message = binding.etMessage.getText().toString().trim();
        Log.d(TAG, "sendMessage: Message = '" + message + "'");

        if (TextUtils.isEmpty(message)) {
            Log.w(TAG, "sendMessage: Empty message");
            Toast.makeText(this, "Please enter a message", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent intent = new Intent(MainActivity.this, EchoActivity.class);
        intent.putExtra("USER_MESSAGE", message);
        Log.d(TAG, "sendMessage: Starting EchoActivity with message");
        startActivity(intent);
    }

    private void shareMessage() {
        String message = binding.etMessage.getText().toString().trim();
        Log.d(TAG, "shareMessage: Message = '" + message + "'");

        if (TextUtils.isEmpty(message)) {
            Log.w(TAG, "shareMessage: Empty message");
            Toast.makeText(this, "Type a message first to share", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, message);

        if (shareIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(Intent.createChooser(shareIntent, "Share via"));
            Log.i(TAG, "shareMessage: Share chooser displayed");
        } else {
            Log.e(TAG, "shareMessage: No app to handle share");
            Toast.makeText(this, "No app available", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}