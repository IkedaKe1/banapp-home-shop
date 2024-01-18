package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        //ボタンを押した時
        findViewById(R.id.bt_test_start).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //インテントの追加（これが遷移用ロジックです）
                Intent intent = new Intent(HistoryActivity.this, StartActivity.class);
                startActivity(intent);
            }
        });

        //戻るボタン処理
        findViewById(R.id.bt_Back_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HistoryActivity.this, MainActivity.class);

                startActivity(intent);
            }
        });

    }
}