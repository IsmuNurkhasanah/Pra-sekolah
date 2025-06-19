package com.example.pra_sekolah;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import io.noties.markwon.Markwon;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;

import okhttp3.*;

public class AnimalsActivity2 extends AppCompatActivity {

    private static final String API_KEY = "AIzaSyBmJ2HzFs1dnITBCczbqIK5RC1BUDug2iA";
    private static final String ENDPOINT = "https://generativelanguage.googleapis.com/v1beta/models/gemini-2.0-flash:generateContent?key=" + API_KEY;

    private EditText inputPertanyaan;
    private Button kirimPertanyaan;
    private TextView jawaban;
    private ImageView g_hewan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_animals2);

        String user_us = getIntent().getStringExtra("username_us");

        ImageView before = findViewById(R.id.before_img);
        before.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent before_page = new Intent(AnimalsActivity2.this, AnimalsActivity.class);
                before_page.putExtra("username_us", user_us);
                startActivity(before_page);
                finish();
            }
        });

        ImageView home = findViewById(R.id.home_img);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent home_page = new Intent(AnimalsActivity2.this, MenuActivity.class);
                home_page.putExtra("username_us", user_us);
                startActivity(home_page);
                finish();
            }
        });

        ImageView next = findViewById(R.id.next_img);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent next_page = new Intent(AnimalsActivity2.this, MenuActivity.class);
                next_page.putExtra("username_us", user_us);
                startActivity(next_page);
                finish();
            }
        });

        inputPertanyaan = findViewById(R.id.gemini_input_text);
        kirimPertanyaan = findViewById(R.id.send_button);
        jawaban = findViewById(R.id.gemini_response_text);
        g_hewan = findViewById(R.id.animal_image_view);

        int gambar_hewan = getIntent().getIntExtra("gambar_hewan", -1);
        if (gambar_hewan != 1){
            g_hewan.setImageResource(gambar_hewan);
        }

        String hewan = getIntent().getStringExtra("hewan");
        if (hewan != null){
            inputPertanyaan.setText(hewan);
            sendQuestion(hewan);
        }

        kirimPertanyaan.setOnClickListener(view -> {
            String pertanyaan = inputPertanyaan.getText().toString();
            if (!pertanyaan.isEmpty()) {
                sendQuestion(pertanyaan);
            }
        });
    }

    private void sendQuestion(String prompt){
        OkHttpClient client = new OkHttpClient();

        String json = "{ \"contents\": [ { \"parts\": [ { \"text\": \"" + prompt + "\" } ] } ] }";
        RequestBody body = RequestBody.create(json, MediaType.parse("application/json"));
        Request request = new Request.Builder()
                .url(ENDPOINT)
                .post(body)
                .build();

        new Thread(() -> {
            try (Response response = client.newCall(request).execute()) {
                if (response.isSuccessful() && response.body() != null) {
                    String result = parseResponse(response.body().string());
                    runOnUiThread(() -> {
                        Markwon markwon = Markwon.create(this);
                        markwon.setMarkdown(jawaban, result);
                    });
                } else {
                    runOnUiThread(() -> jawaban.setText("Gagal: " + response.code()));
                }
            } catch (IOException e) {
                runOnUiThread(() -> jawaban.setText("Error: " + e.getMessage()));
            }
        }).start();
    }

    private String parseResponse(String jsonResponse) {
        JsonObject json = JsonParser.parseString(jsonResponse).getAsJsonObject();
        JsonArray candidates = json.getAsJsonArray("candidates");
        if (candidates != null && candidates.size() > 0) {
            JsonObject content = candidates.get(0).getAsJsonObject()
                    .getAsJsonObject("content");
            JsonArray parts = content.getAsJsonArray("parts");
            return parts.get(0).getAsJsonObject().get("text").getAsString();
        }
        return "Tidak ada jawaban dari Gemini.";
    }
}