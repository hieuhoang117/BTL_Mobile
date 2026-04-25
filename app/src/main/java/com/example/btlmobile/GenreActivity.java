package com.example.btlmobile;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class GenreActivity extends AppCompatActivity {
    private TextView tvGenreTitle;
    private RecyclerView rvGenreResult;
    private ApiService apiService;
    private String selectedGenre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_genre);

        tvGenreTitle = findViewById(R.id.tvGenreTitle);
        rvGenreResult = findViewById(R.id.rvGenreResult);
        ImageView btnBack = findViewById(R.id.btnBackGenre);

        if (btnBack != null) {
            btnBack.setOnClickListener(v -> finish());
        }

        selectedGenre = getIntent().getStringExtra("GENRE_NAME");
        if (tvGenreTitle != null) {
            tvGenreTitle.setText(selectedGenre);
        }

        rvGenreResult.setLayoutManager(new GridLayoutManager(this, 3));
        apiService = ApiClient.getClient().create(ApiService.class);

        loadGenreData();
    }

    private void loadGenreData() {
        apiService.getbycategory(selectedGenre).enqueue(new Callback<CategoryResponse>() {
            @Override
            public void onResponse(Call<CategoryResponse> call, Response<CategoryResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    List<Movie> combinedList = new ArrayList<>();
                    CategoryResponse data = response.body();
                    
                    if (data.getMovies() != null) combinedList.addAll(data.getMovies());
                    
                    // Chuyển Series sang Movie model để dùng chung SearchAdapter (hoặc tạo Adapter riêng)
                    if (data.getSeries() != null) {
                        for (Series s : data.getSeries()) {
                            Movie m = new Movie();
                            m.IDmovie = s.IDseries;
                            m.NameMovie = s.SeriesName;
                            m.Poster = s.poster;
                            m.Category = s.Category;
                            m.Description = s.Description;
                            combinedList.add(m);
                        }
                    }
                    rvGenreResult.setAdapter(new SearchAdapter(combinedList));
                }
            }

            @Override
            public void onFailure(Call<CategoryResponse> call, Throwable t) {
                Log.e("GenreActivity", "Error loading genre data", t);
            }
        });
    }
}
