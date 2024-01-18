package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView catImageView;
    private boolean isCat1Visible = true;
    private Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        catImageView = findViewById(R.id.catImageView);

        // 初期画像を表示
        catImageView.setImageResource(R.drawable.cat1);

        // 画像切り替え用のアニメーションを読み込み
        final Animation fadeInOut = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move_cat_repeat);

        handler = new Handler(Looper.getMainLooper());

        // 定期的に画像を切り替える
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                switchCatImage();
                handler.postDelayed(this, 1000); // 1秒ごとに切り替える（必要に応じて調整）
            }
        }, 1000); // 初回は1秒後に実行

        //ショップ画面遷移
        findViewById(R.id.bt_shop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ShopActivity.class);

                startActivity(intent);
            }
        });

        //アチーブメント画面遷移
        findViewById(R.id.bt_achievement).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, AchievementActivity.class);

                startActivity(intent);
            }
        });

        //ヒストリー画面遷移
        findViewById(R.id.bt_history).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, HistoryActivity.class);

                startActivity(intent);
            }
        });
    }

    private void switchCatImage() {
        if (isCat1Visible) {
            catImageView.setImageResource(R.drawable.cat2);
        } else {
            catImageView.setImageResource(R.drawable.cat1);
        }
        isCat1Visible = !isCat1Visible;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // Handlerのメモリリークを防ぐためにActivityが破棄されたらHandlerも終了する
        handler.removeCallbacksAndMessages(null);
    }
}