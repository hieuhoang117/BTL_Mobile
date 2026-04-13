package com.example.btlmobile;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SeriesPlayActivity extends AppCompatActivity {

    private VideoView videoView;
    private TextView tvCurrentEpisode;
    private RecyclerView rvEpisodes;
    private String currentIP = "192.168.1.13";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_series_play);

        videoView = findViewById(R.id.videoViewSeries);
        tvCurrentEpisode = findViewById(R.id.tvCurrentEpisode);
        rvEpisodes = findViewById(R.id.rvEpisodes);
        rvEpisodes.setLayoutManager(new LinearLayoutManager(this));

        // Nhận ID Series từ Intent
        String seriesId = getIntent().getStringExtra("IDseries");

        loadEpisodes(seriesId);
    }

    private void loadEpisodes(String seriesId) {
        ApiService apiService = ApiClient.getClient().create(ApiService.class);
        apiService.getEpisodesBySeriesId(seriesId).enqueue(new Callback<List<Episode>>() {
            @Override
            public void onResponse(Call<List<Episode>> call, Response<List<Episode>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Episode> episodes = response.body();
                    
                    EpisodeAdapter adapter = new EpisodeAdapter(episodes, episode -> playVideo(episode));
                    rvEpisodes.setAdapter(adapter);

                    // Tự động phát tập đầu tiên nếu có
                    if (!episodes.isEmpty()) {
                        playVideo(episodes.get(0));
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Episode>> call, Throwable t) {
                Log.e("SERIES_PLAY", "Error: " + t.getMessage());
            }
        });
    }

    private void playVideo(Episode episode) {
        tvCurrentEpisode.setText("Đang phát: Tập " + episode.EpisodeNumber + " - " + episode.EpisodeName);
        
        String videoUrl = episode.film != null ? episode.film.replace("localhost", currentIP) : "";
        
        if (!videoUrl.isEmpty()) {
            Uri uri = Uri.parse(videoUrl);
            videoView.setVideoURI(uri);

            MediaController mc = new MediaController(this);
            mc.setAnchorView(videoView);
            videoView.setMediaController(mc);

            videoView.start();
        }
    }
}