package com.example.pra_sekolah;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ColorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_color);

        String user_us = getIntent().getStringExtra("username_us");

        ImageView before = findViewById(R.id.before_img);
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent before_page = new Intent(ColorActivity.this, FormActivity.class);
                before_page.putExtra("username_us", user_us);
                startActivity(before_page);
                finish();
            }
        });

        ImageView home = findViewById(R.id.home_img);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home_page = new Intent(ColorActivity.this, MenuActivity.class);
                home_page.putExtra("username_us", user_us);
                startActivity(home_page);
                finish();
            }
        });

        ImageView next = findViewById(R.id.next_img);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_page = new Intent(ColorActivity.this, DirectionActivity.class);
                next_page.putExtra("username_us", user_us);
                startActivity(next_page);
                finish();
            }
        });
    }

    public void KlikColor(View view) {
        View tampil = findViewById(R.id.isiColor);
        ColorDrawable klik = (ColorDrawable) view.getBackground();
        int warnaSet = klik.getColor();
        tampil.setBackgroundColor(warnaSet);
        TextView sample1 = findViewById(R.id.sample1);
        String textPilih1 = view.getContentDescription().toString();
        sample1.setText(textPilih1);

    }
}