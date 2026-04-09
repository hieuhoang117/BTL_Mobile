package com.example.btlmobile;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MoviePlay extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie_play);

        VideoView videoView = findViewById(R.id.videoView);
        TextView tvTitle = findViewById(R.id.tvMovieTitle);

        // Nhận dữ liệu từ Intent
        String videoUrl = getIntent().getStringExtra("video_url");
        String title = getIntent().getStringExtra("movie_title");

        tvTitle.setText(title);

        // MoviePlay.java
        if (videoUrl != null && !videoUrl.isEmpty()) {
            // Đổi localhost thành IP máy tính hiện tại (192.168.1.12)
            videoUrl = videoUrl.replace("localhost", "192.168.1.12");

            Uri uri = Uri.parse(videoUrl);
            videoView.setVideoURI(uri);

            MediaController mediaController = new MediaController(this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);

            videoView.start();
        } else {
            Toast.makeText(this, "Phim này hiện chưa có video!", Toast.LENGTH_SHORT).show();
            finish();
        }
    }
}