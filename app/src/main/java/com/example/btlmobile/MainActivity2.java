package com.example.btlmobile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main2), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Spinner help=findViewById(R.id.helplist);
        List<String> list = Arrays.asList("Hỏi đáp", "Trợ giúp");
        ArrayAdapter<String> adapter =
                new ArrayAdapter<>(this,
                        android.R.layout.simple_spinner_item,
                        list);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);

        help.setAdapter(adapter);

        ViewPager2 viewPager = findViewById(R.id.viewpager);

        int[] images = {
                R.drawable.bg1,
                R.drawable.bg2,
                R.drawable.bg3
        };

        SlideAdapter slideAdapter = new SlideAdapter(images);
        viewPager.setAdapter(slideAdapter);

// bắt đầu ở giữa để lướt 2 chiều
        viewPager.setCurrentItem(1000);
    }
}
