package com.example.test;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class checkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check);

        //Yesボタン処理
        findViewById(R.id.bt_yes).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(checkActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });

        //Noボタン処理
        findViewById(R.id.bt_no).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(checkActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });
    }
}
