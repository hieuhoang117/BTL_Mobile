package com.example.btlmobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class profile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.chose_profile);

        // Sử dụng ID "main" đã được đặt trong file chose_profile.xml
        View mainView = findViewById(R.id.main);
        if (mainView != null) {
            ViewCompat.setOnApplyWindowInsetsListener(mainView, (v, insets) -> {
                Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
                v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
                return insets;
            });
        }

        // Lấy các layout hồ sơ từ XML mới (Dùng LinearLayout thay vì Button)
        LinearLayout profile1 = findViewById(R.id.llProfile1);
        LinearLayout profile2 = findViewById(R.id.llProfile2);
        LinearLayout profile3 = findViewById(R.id.llProfile3);

        Intent intent = new Intent(profile.this, af_login.class);

        // Gán sự kiện click cho các hồ sơ
        if (profile1 != null) {
            profile1.setOnClickListener(v -> startActivity(intent));
        }
        if (profile2 != null) {
            profile2.setOnClickListener(v -> startActivity(intent));
        }
        if (profile3 != null) {
            profile3.setOnClickListener(v -> startActivity(intent));
        }
    }
}
