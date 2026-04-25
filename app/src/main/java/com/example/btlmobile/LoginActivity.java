package com.example.btlmobile;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private EditText etEmail, etPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnLogin = findViewById(R.id.btnLoginAction);

        findViewById(R.id.btnBackLogin).setOnClickListener(v -> finish());

        btnLogin.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String password = etPassword.getText().toString().trim();

            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                return;
            }

            checkEmailAndLogin(email);
        });
    }

    private void checkEmailAndLogin(String email) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        CheckEmailRequest request = new CheckEmailRequest(email);

        apiService.checkEmail(request).enqueue(new Callback<CheckEmailResponse>() {
            @Override
            public void onResponse(Call<CheckEmailResponse> call, Response<CheckEmailResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    if (response.body().exists) {
                        Toast.makeText(LoginActivity.this, "Đăng nhập thành công!", Toast.LENGTH_SHORT).show();
                        // Chuyển sang màn hình chọn hồ sơ
                        startActivity(new Intent(LoginActivity.this, profile.class));
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Email không tồn tại trên hệ thống", Toast.LENGTH_LONG).show();
                    }
                }
            }

            @Override
            public void onFailure(Call<CheckEmailResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Lỗi kết nối: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}