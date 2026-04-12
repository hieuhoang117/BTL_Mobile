package com.example.btlmobile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class TopMovieAdapter extends RecyclerView.Adapter<TopMovieAdapter.TopViewHolder> {

    private List<Movie> list;

    public TopMovieAdapter(List<Movie> list) {
        this.list = list;
    }

    public class TopViewHolder extends RecyclerView.ViewHolder {
        TextView tvRank;
        ImageView imgPoster;

        public TopViewHolder(View itemView) {
            super(itemView);
            tvRank = itemView.findViewById(R.id.tvRank);
            imgPoster = itemView.findViewById(R.id.imgTopPoster);
        }
    }

    @Override
    public TopViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_top_movie, parent, false);
        return new TopViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TopViewHolder holder, int position) {
        Movie m = list.get(position);
        
        // Hiển thị số thứ tự (1, 2, 3...)
        holder.tvRank.setText(String.valueOf(position + 1));

        String currentIP = "192.168.1.13";
        String posterUrl = m.Poster != null ? m.Poster.replace("localhost", currentIP) : "";

        Glide.with(holder.itemView.getContext())
                .load(posterUrl)
                .placeholder(android.R.drawable.ic_menu_report_image)
                .into(holder.imgPoster);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), MovieDetailActivity.class);
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
        return Math.min(list.size(), 10); // Chỉ hiển thị top 10
    }
}