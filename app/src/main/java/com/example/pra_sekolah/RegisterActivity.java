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

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);

    }

    public void Add_user (View view){
        EditText nama_anak, umur, email, username, password;

        nama_anak = findViewById(R.id.nama_anak_edit_text);
        umur = findViewById(R.id.umur_edit_text);
        email = findViewById(R.id.email_edit_text);
        username = findViewById(R.id.username_edit_text);
        password = findViewById(R.id.password_edit_text);

        String dtnama_anak = nama_anak.getText().toString();
        String dtumur_anak = umur.getText().toString();
        String dtemail = email.getText().toString();
        String dtusername = username.getText().toString();
        String dtpassword = password.getText().toString();

        if (!dtnama_anak.isEmpty() && !dtumur_anak.isEmpty() && !dtemail.isEmpty() && !dtusername.isEmpty() && !dtpassword.isEmpty()) {
            RequestQueue queue = Volley.newRequestQueue(getApplicationContext());
            String url = "http://192.168.15.126/prasekolah/create.php";

            StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            if (response.equals("Success")) {
                                Toast.makeText(getApplicationContext(), "Registrasi berhasil!" , Toast.LENGTH_SHORT).show();
                                Intent regist = new Intent(RegisterActivity.this, LoginActivity.class);
                                startActivity(regist);
                                finish();
                            } else {
                                Toast.makeText(RegisterActivity.this, "Registrasi Gagal!", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Toast.makeText(RegisterActivity.this, "Network error: " + error.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
                }
            }) {
                protected Map<String, String> getParams() {
                    Map<String, String> paramV = new HashMap<>();
                    paramV.put("nama_anak", dtnama_anak);
                    paramV.put("umur_anak", dtumur_anak);
                    paramV.put("email_user", dtemail);
                    paramV.put("username_us", dtusername);
                    paramV.put("pass_us", dtpassword);
                    return paramV;
                }
            };
            queue.add(stringRequest);
        } else {
            Toast.makeText(getApplicationContext(),"Isi Semua Data!", Toast.LENGTH_SHORT).show();
        }
    }
}