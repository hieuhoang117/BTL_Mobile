package com.example.btlmobile;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class NewHotActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Tạm dùng chung layout Search để không bị lỗi
        setContentView(R.layout.activity_search); 
    }
}