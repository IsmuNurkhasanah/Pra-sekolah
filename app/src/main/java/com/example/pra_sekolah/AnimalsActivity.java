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

        String user_us = getIntent().getStringExtra("username_us");

        ImageView before = findViewById(R.id.before_img);
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent before_page = new Intent(AnimalsActivity.this, DirectionActivity.class);
                before_page.putExtra("username_us", user_us);
                startActivity(before_page);
                finish();
            }
        });

        ImageView home = findViewById(R.id.home_img);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home_page = new Intent(AnimalsActivity.this, MenuActivity.class);
                home_page.putExtra("username_us", user_us);
                startActivity(home_page);
                finish();
            }
        });

        ImageView next = findViewById(R.id.next_img);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_page = new Intent(AnimalsActivity.this, MenuActivity.class);
                next_page.putExtra("username_us", user_us);
                startActivity(next_page);
                finish();
            }
        });

        ImageView imageA = findViewById(R.id.image_a);
        imageA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Rusa itu apa?", R.drawable.antelope);
            }
        });
        ImageView imageB = findViewById(R.id.image_b);
        imageB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Beruang itu apa?", R.drawable.bear);
            }
        });
        ImageView imageC = findViewById(R.id.image_c);
        imageC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Kucing itu apa?", R.drawable.cat);
            }
        });
        ImageView imageD = findViewById(R.id.image_d);
        imageD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Anjing itu apa?", R.drawable.dog);
            }
        });
        ImageView imageE = findViewById(R.id.image_e);
        imageE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Gajah itu apa?", R.drawable.elephant);
            }
        });
        ImageView imageF = findViewById(R.id.image_f);
        imageF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Rubah itu apa?", R.drawable.fox);
            }
        });
        ImageView imageG = findViewById(R.id.image_g);
        imageG.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Jerapah itu apa?", R.drawable.giraffe);
            }
        });
        ImageView imageH = findViewById(R.id.image_h);
        imageH.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Kuda itu apa?", R.drawable.horse);
            }
        });
        ImageView imageI = findViewById(R.id.image_i);
        imageI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Iguana itu apa?", R.drawable.iguana);
            }
        });
        ImageView imageJ = findViewById(R.id.image_j);
        imageJ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Jaguar itu apa?", R.drawable.jaguar);
            }
        });
        ImageView imageK = findViewById(R.id.image_k);
        imageK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Kanguru itu apa?", R.drawable.kangaroo);
            }
        });
        ImageView imageL = findViewById(R.id.image_l);
        imageL.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Singa itu apa?", R.drawable.lion);
            }
        });
        ImageView imageM = findViewById(R.id.image_m);
        imageM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Monyet itu apa?", R.drawable.monkey);
            }
        });
        ImageView imageN = findViewById(R.id.image_n);
        imageN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Kadal itu apa?", R.drawable.newt);
            }
        });
        ImageView imageO = findViewById(R.id.image_o);
        imageO.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Burung Hantu itu apa?", R.drawable.owl);
            }
        });
        ImageView imageP = findViewById(R.id.image_p);
        imageP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Pinguin itu apa?", R.drawable.penguin);
            }
        });
        ImageView imageQ = findViewById(R.id.image_q);
        imageQ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Burung Puyuh itu apa?", R.drawable.quail);
            }
        });
        ImageView imageR = findViewById(R.id.image_r);
        imageR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Kelinci itu apa?", R.drawable.rabbit);
            }
        });
        ImageView imageS = findViewById(R.id.image_s);
        imageS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Ular itu apa?", R.drawable.snake);
            }
        });
        ImageView imageT = findViewById(R.id.image_t);
        imageT.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Harimau itu apa?", R.drawable.tiger);
            }
        });
        ImageView imageU = findViewById(R.id.image_u);
        imageU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Sapi itu apa?", R.drawable.urial);
            }
        });
        ImageView imageV = findViewById(R.id.image_v);
        imageV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Burung Nasar itu apa?", R.drawable.vulture);
            }
        });
        ImageView imageW = findViewById(R.id.image_w);
        imageW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Serigala itu apa?", R.drawable.wolf);
            }
        });
        ImageView imageX = findViewById(R.id.image_x);
        imageX.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Meerkat itu apa?", R.drawable.xerus);
            }
        });
        ImageView imageY = findViewById(R.id.image_y);
        imageY.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Kerbau itu apa?", R.drawable.yak);
            }
        });
        ImageView imageZ = findViewById(R.id.image_z);
        imageZ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bukalamanHewan("Hewan Zebra itu apa?", R.drawable.zebra);
            }
        });
    }

    private void bukalamanHewan(String hewan, int gambar_hewan) {
        Intent buka_hal = new Intent(this, AnimalsActivity2.class);
        buka_hal.putExtra("hewan", hewan);
        buka_hal.putExtra("gambar_hewan", gambar_hewan);
        startActivity(buka_hal);
    }
}