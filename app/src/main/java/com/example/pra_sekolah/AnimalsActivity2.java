package com.example.pra_sekolah;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AnimalsActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animals2);


        String huruf = getIntent().getStringExtra("huruf");
        TextView texthuruf = findViewById(R.id.text_huruf);

        if (huruf != null){
            texthuruf.setText("Hewan dengan Huruf " + huruf);
            searchGambar(huruf);
        } else {
            texthuruf.setText("Terjadi kesalahan: Huruf tidak diterima");
        }
    }

    private void searchGambar (String huruf){
        String query = "Hewan dengan huruf " + huruf;
        Uri gooleSearch = Uri.parse("https://www.google.com/search?q=" + query + "&tbm=isch");
        Intent openGoogle = new Intent(Intent.ACTION_VIEW, gooleSearch);
        startActivity(openGoogle);
        finish();
    }
}