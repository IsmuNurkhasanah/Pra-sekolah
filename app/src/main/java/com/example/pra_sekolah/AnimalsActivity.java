package com.example.pra_sekolah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnimalsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animals);

        ImageView imageA = findViewById(R.id.image_a);
        imageA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("A");
            }
        });
        ImageView imageB = findViewById(R.id.image_b);
        imageB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("B");
            }
        });
        ImageView imageC = findViewById(R.id.image_c);
        imageC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("C");
            }
        });
        ImageView imageD = findViewById(R.id.image_d);
        imageD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("D");
            }
        });
        ImageView imageE = findViewById(R.id.image_e);
        imageE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("E");
            }
        });
        ImageView imageF = findViewById(R.id.image_f);
        imageF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("F");
            }
        });
        ImageView imageG = findViewById(R.id.image_g);
        imageG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("G");
            }
        });
        ImageView imageH = findViewById(R.id.image_h);
        imageH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("H");
            }
        });
        ImageView imageI = findViewById(R.id.image_i);
        imageI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("I");
            }
        });
        ImageView imageJ = findViewById(R.id.image_j);
        imageJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("J");
            }
        });
        ImageView imageK = findViewById(R.id.image_k);
        imageK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("K");
            }
        });
        ImageView imageL = findViewById(R.id.image_l);
        imageL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("L");
            }
        });
        ImageView imageM = findViewById(R.id.image_m);
        imageM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("M");
            }
        });
        ImageView imageN = findViewById(R.id.image_n);
        imageN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("N");
            }
        });
        ImageView imageO = findViewById(R.id.image_o);
        imageO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("O");
            }
        });
        ImageView imageP = findViewById(R.id.image_p);
        imageP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("P");
            }
        });
        ImageView imageQ = findViewById(R.id.image_q);
        imageQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Q");
            }
        });
        ImageView imageR = findViewById(R.id.image_r);
        imageR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("R");
            }
        });
        ImageView imageS = findViewById(R.id.image_s);
        imageS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("S");
            }
        });
        ImageView imageT = findViewById(R.id.image_t);
        imageT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("T");
            }
        });
        ImageView imageU = findViewById(R.id.image_u);
        imageU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("U");
            }
        });
        ImageView imageV = findViewById(R.id.image_v);
        imageV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("V");
            }
        });
        ImageView imageW = findViewById(R.id.image_w);
        imageW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("W");
            }
        });
        ImageView imageX = findViewById(R.id.image_x);
        imageX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("X");
            }
        });
        ImageView imageY = findViewById(R.id.image_y);
        imageY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Y");
            }
        });
        ImageView imageZ = findViewById(R.id.image_z);
        imageZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Z");
            }
        });
    }

    private void bukalamanHewan(String huruf) {
        Intent buka_hal = new Intent(this, AnimalsActivity.class);
        buka_hal.putExtra("huruf", huruf);
        startActivity(buka_hal);
    }
}