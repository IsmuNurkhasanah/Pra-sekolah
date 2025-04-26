package com.example.pra_sekolah;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);

    }

    public void Login_user (View view){
        EditText username, password;

        username = findViewById(R.id.username_edit_text);
        password = findViewById(R.id.password_edit_text);

        String username_us = username.getText().toString();
        String pass_us  = password.getText().toString();

        if (!username_us.isEmpty() && !pass_us.isEmpty()) {
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            String url = "http://192.168.15.126/prasekolah/login.php";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            if (response.equals("Success")) {
                                Toast.makeText(getApplicationContext(), "Login berhasil!" , Toast.LENGTH_SHORT).show();
                                Intent login = new Intent(LoginActivity.this, MenuActivity.class);
                                startActivity(login);
                                finish();
                            } else {
                                Toast.makeText(LoginActivity.this, "Username atau Password Salah!", Toast.LENGTH_SHORT).show();
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