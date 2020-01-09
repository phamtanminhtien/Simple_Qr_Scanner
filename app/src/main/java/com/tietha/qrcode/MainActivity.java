package com.tietha.qrcode;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    private Button openbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        openbtn = findViewById(R.id.openQRS);
        final Intent openQRScanActivity = new Intent(MainActivity.this, QRScanActivity.class);
        openQRScanActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);

        openbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityIfNeeded(openQRScanActivity, 0);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == 0){
            if(resultCode == Activity.RESULT_OK){
                assert data != null;
                Log.d("AAA", Objects.requireNonNull(data.getStringExtra("token")));
                Toast.makeText(getApplicationContext(), data.getStringExtra("token"), Toast.LENGTH_LONG).show();
            }
        }
    }
}