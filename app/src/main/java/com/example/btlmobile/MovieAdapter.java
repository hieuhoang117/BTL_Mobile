package com.example.btlmobile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {

    private List<Movie> list;

    public MovieAdapter(List<Movie> list) {
        this.list = list;
    }

    public class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;

        public MovieViewHolder(View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgPoster);
        }
    }

    @Override
    public MovieViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_movie, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, int position) {
        Movie m = list.get(position);

        // Thay localhost bằng IP bạn đang dùng (192.168.1.12)
        String currentIP = "192.168.1.12";
        String posterUrl = m.Poster != null ? m.Poster.replace("localhost", currentIP) : "";

        Glide.with(holder.itemView.getContext())
                .load(posterUrl)
                .placeholder(android.R.drawable.ic_menu_report_image)
                .into(holder.imgPoster);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), MovieDetailActivity.class);
            // Gửi toàn bộ thông tin phim sang MovieDetailActivity
            intent.putExtra("IDmovie", m.IDmovie);
            intent.putExtra("NameMovie", m.NameMovie);
            intent.putExtra("Category", m.Category);
            intent.putExtra("ReleaseDate", m.ReleaseDate);
            intent.putExtra("Director", m.Director);
            intent.putExtra("Duration", m.Duration);
            intent.putExtra("Country", m.Country);
            intent.putExtra("Description", m.Description);
            intent.putExtra("Poster", m.Poster);
            intent.putExtra("Film", m.Film);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}