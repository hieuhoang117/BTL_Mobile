package com.example.btlmobile;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.SearchViewHolder> {

    private List<Movie> list;

    public SearchAdapter(List<Movie> list) {
        this.list = list;
    }

    public class SearchViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;

        public SearchViewHolder(View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgPoster);
        }
    }

    @Override
    public SearchViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_search, parent, false);
        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SearchViewHolder holder, int position) {
        Movie m = list.get(position);

        String posterUrl = m.Poster != null ? m.Poster.replace("localhost", Config.IP_ADDRESS) : "";

        Glide.with(holder.itemView.getContext())
                .load(posterUrl)
                .placeholder(android.R.drawable.ic_menu_report_image)
                .into(holder.imgPoster);

        holder.itemView.setOnClickListener(v -> {
            // Kiểm tra xem là phim hay series dựa trên ID (giả sử phim bắt đầu bằng MV, series bằng SV)
            // Hoặc bạn có thể thêm trường type vào model
            Intent intent;
            if (m.IDmovie != null && m.IDmovie.startsWith("SV")) {
                intent = new Intent(v.getContext(), SeriesDetailActivity.class);
                intent.putExtra("IDseries", m.IDmovie);
                intent.putExtra("SeriesName", m.NameMovie);
                intent.putExtra("Poster", m.Poster);
            } else {
                intent = new Intent(v.getContext(), MovieDetailActivity.class);
                intent.putExtra("NameMovie", m.NameMovie);
                intent.putExtra("Poster", m.Poster);
                intent.putExtra("Film", m.Film);
            }
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}