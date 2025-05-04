package com.example.pra_sekolah;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import api.ApiClient;

public class MenuActivity extends AppCompatActivity {

    String user_us;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_menu);

        user_us = getIntent().getStringExtra("username_us");
        RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

        StringRequest stringRequest = new StringRequest(Request.Method.POST, ApiClient.READ_URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String status = jsonObject.getString("status");
                            if (status.equals("Success")) {
                                JSONObject data = jsonObject.getJSONObject("data");
                                String namaAnak = data.getString("nama_anak");
                                TextView nama = findViewById(R.id.nama_user);
                                nama.setText("Hi, " +namaAnak);
                            } else {
                                Toast.makeText(MenuActivity.this, "Tidak Falid", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception e){
                            e.printStackTrace();
                            Toast.makeText(MenuActivity.this, "Terjadi kesalahan saat memproses data!", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MenuActivity.this, "Network error: " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        }) {
            protected Map<String, String> getParams() {
                Map<String, String> paramV = new HashMap<>();
                paramV.put("username_us", user_us);
                return paramV;
            }
        };
        queue.add(stringRequest);
    }

    public void alfabet (View view){
        Intent start_alfa = new Intent(MenuActivity.this, AlfabetActivity.class);
        start_alfa.putExtra("username_us", user_us);
        startActivity(start_alfa);
        finish();
    }

    public void number (View view){
        Intent start_numb = new Intent(getApplicationContext(), NumberActivity.class);
        start_numb.putExtra("username_us", user_us);
        startActivity(start_numb);
        finish();
    }

    public void form (View view){
        Intent start_form = new Intent(getApplicationContext(), FormActivity.class);
        start_form.putExtra("username_us", user_us);
        startActivity(start_form);
        finish();
    }

    public void color (View view){
        Intent start_color = new Intent(getApplicationContext(), ColorActivity.class);
        start_color.putExtra("username_us", user_us);
        startActivity(start_color);
        finish();
    }

    public void direction (View view){
        Intent start_direct = new Intent(getApplicationContext(), DirectionActivity.class);
        start_direct.putExtra("username_us", user_us);
        startActivity(start_direct);
        finish();
    }

    public void animal (View view){
        Intent start_animal = new Intent(getApplicationContext(), AnimalsActivity.class);
        start_animal.putExtra("username_us", user_us);
        startActivity(start_animal);
        finish();
    }

    public void quit (View view){
        Intent start_quit = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(start_quit);
        finish();
    }
}