package com.example.pra_sekolah;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

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

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

        ImageView back = findViewById(R.id.back_button);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(LoginActivity.this, MainActivity2.class);
                startActivity(back);
                finish();
            }
        });
    }

    public void Login_user (View view){
        EditText username, password;

        username = findViewById(R.id.username_edit_text);
        password = findViewById(R.id.password_edit_text);

        String username_us = username.getText().toString();
        String pass_us  = password.getText().toString();

        if (!username_us.isEmpty() && !pass_us.isEmpty()) {
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());

            StringRequest stringRequest = new StringRequest(Request.Method.POST, ApiClient.LOGIN_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Log.d("SERVER_RESPONSE", response);
                            try {
                                JSONObject jsonObject = new JSONObject(response);
                                String status = jsonObject.getString("status");
                                if (status.equals("Success")) {
                                    Toast.makeText(getApplicationContext(), "Login berhasil!", Toast.LENGTH_SHORT).show();
                                    Intent login = new Intent(LoginActivity.this, MenuActivity.class);
                                    login.putExtra("username_us", username_us);
                                    startActivity(login);
                                    finish();
                                } else {
                                    Toast.makeText(LoginActivity.this, "Username atau Password Salah!", Toast.LENGTH_SHORT).show();
                                }
                            } catch (Exception e){
                                e.printStackTrace();
                                Toast.makeText(LoginActivity.this, "Terjadi kesalahan saat memproses data!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(LoginActivity.this, "Network error: " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                protected Map<String, String> getParams() {
                    Map<String, String> paramV = new HashMap<>();
                    paramV.put("username_us", username_us);
                    paramV.put("pass_us", pass_us);
                    return paramV;
                }
            };
            queue.add(stringRequest);
        } else {
            Toast.makeText(getApplicationContext(),"Isi Semua Data!", Toast.LENGTH_SHORT).show();
        }
    }
}