package com.example.btlmobile;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class MovieDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.movie_detail);

        ImageView imgPoster = findViewById(R.id.imgDetailPoster);
        TextView tvName = findViewById(R.id.tvDetailName);
        TextView tvMeta = findViewById(R.id.tvDetailMeta);
        TextView tvCategory = findViewById(R.id.tvDetailCategory);
        TextView tvDescription = findViewById(R.id.tvDetailDescription);
        TextView tvDirector = findViewById(R.id.tvDetailDirector);
        Button btnPlay = findViewById(R.id.btnPlayDetail);
        ImageButton btnBack = findViewById(R.id.btnBack);

        // Nhận dữ liệu từ Intent
        String id = getIntent().getStringExtra("IDmovie");
        String name = getIntent().getStringExtra("NameMovie");
        String category = getIntent().getStringExtra("Category");
        String date = getIntent().getStringExtra("ReleaseDate");
        String director = getIntent().getStringExtra("Director");
        int duration = getIntent().getIntExtra("Duration", 0);
        String country = getIntent().getStringExtra("Country");
        String description = getIntent().getStringExtra("Description");
        String poster = getIntent().getStringExtra("Poster");
        String film = getIntent().getStringExtra("Film");

        // Hiển thị dữ liệu
        tvName.setText(name);
        tvCategory.setText("Thể loại: " + category);
        tvDescription.setText(description);
        tvDirector.setText("Đạo diễn: " + director);
        
        String year = (date != null && date.length() >= 4) ? date.substring(0, 4) : "";
        tvMeta.setText(year + " | " + duration + " phút | " + country);

        String currentIP = "192.168.1.12"; // Hoặc .21 tùy mạng của bạn
        String posterUrl = (poster != null) ? poster.replace("localhost", currentIP) : "";

        Glide.with(this)
                .load(posterUrl)
                .placeholder(android.R.drawable.ic_menu_report_image)
                .into(imgPoster);

        btnBack.setOnClickListener(v -> finish());

        btnPlay.setOnClickListener(v -> {
            if (film == null || film.isEmpty()) {
                Toast.makeText(this, "Phim này chưa có video!", Toast.LENGTH_SHORT).show();
            } else {
                Intent intent = new Intent(MovieDetailActivity.this, MoviePlay.class);
                intent.putExtra("video_url", film);
                intent.putExtra("movie_title", name);
                startActivity(intent);
            }
        });
    }
}