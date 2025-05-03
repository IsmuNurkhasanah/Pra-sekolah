package com.example.pra_sekolah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import com.example.pra_sekolah.DrawingView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class DirectionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_direction);

        ImageView before = findViewById(R.id.before_img);
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent before_page = new Intent(DirectionActivity.this, ColorActivity.class);
                startActivity(before_page);
                finish();
            }
        });

        ImageView home = findViewById(R.id.home_img);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home_page = new Intent(DirectionActivity.this, MenuActivity.class);
                startActivity(home_page);
                finish();
            }
        });

        ImageView next = findViewById(R.id.next_img);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_page = new Intent(DirectionActivity.this, MenuActivity.class);
                startActivity(next_page);
                finish();
            }
        });
    }

    public void KlikDirect(View view) {
        View tampil = findViewById(R.id.isiHuruf);
        TextView sample1 = findViewById(R.id.sample1);
        if (view instanceof ImageView) {
            ImageView klik = (ImageView) view;
            klik.getDrawable().setCallback(null);
            tampil.setBackground(klik.getDrawable());

            String textPilih1 = klik.getContentDescription().toString();
            sample1.setText(textPilih1);
        }
    }
}