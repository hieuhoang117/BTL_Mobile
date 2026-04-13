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

public class SeriesNewHotAdapter extends RecyclerView.Adapter<SeriesNewHotAdapter.SeriesViewHolder> {

    private List<Series> list;

    public SeriesNewHotAdapter(List<Series> list) {
        this.list = list;
    }

    public class SeriesViewHolder extends RecyclerView.ViewHolder {
        ImageView imgThumbnail;
        TextView tvMovieName, tvReleaseDate, tvDesc;

        public SeriesViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = itemView.findViewById(R.id.imgThumbnail);
            tvMovieName = itemView.findViewById(R.id.tvMovieName);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }

    @Override
    public SeriesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_new_hot, parent, false);
        return new SeriesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(SeriesViewHolder holder, int position) {
        Series s = list.get(position);
        
        holder.tvMovieName.setText(s.SeriesName);
        holder.tvDesc.setText(s.Description);
        holder.tvReleaseDate.setText("Mùa mới ra mắt " + (s.ReleaseYear != null ? s.ReleaseYear : ""));

        String currentIP = "192.168.1.13";
        String thumbUrl = s.poster != null ? s.poster.replace("localhost", currentIP) : "";

        Glide.with(holder.itemView.getContext())
                .load(thumbUrl)
                .placeholder(android.R.drawable.ic_menu_report_image)
                .into(holder.imgThumbnail);

        holder.itemView.setOnClickListener(v -> {
            // Chuyển sang chi tiết Series (Bạn có thể dùng chung MovieDetailActivity hoặc tạo mới)
            Intent intent = new Intent(v.getContext(), MovieDetailActivity.class);
            intent.putExtra("NameMovie", s.SeriesName);
            intent.putExtra("Description", s.Description);
            intent.putExtra("Poster", s.poster);
            v.getContext().startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}