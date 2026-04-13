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

public class NewHotAdapter extends RecyclerView.Adapter<NewHotAdapter.NewHotViewHolder> {

    private List<Movie> list;

    public NewHotAdapter(List<Movie> list) {
        this.list = list;
    }

    public class NewHotViewHolder extends RecyclerView.ViewHolder {
        ImageView imgThumbnail;
        TextView tvMovieName, tvReleaseDate, tvDesc;

        public NewHotViewHolder(View itemView) {
            super(itemView);
            imgThumbnail = itemView.findViewById(R.id.imgThumbnail);
            tvMovieName = itemView.findViewById(R.id.tvMovieName);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDate);
            tvDesc = itemView.findViewById(R.id.tvDesc);
        }
    }

    @Override
    public NewHotViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_new_hot, parent, false);
        return new NewHotViewHolder(view);
    }

    @Override
    public void onBindViewHolder(NewHotViewHolder holder, int position) {
        Movie m = list.get(position);
        
        holder.tvMovieName.setText(m.NameMovie);
        holder.tvDesc.setText(m.Description);
        holder.tvReleaseDate.setText("Ra mắt vào " + (m.ReleaseDate != null ? m.ReleaseDate.substring(0, 10) : "Thứ Năm"));

        String currentIP = "192.168.1.13";
        String thumbUrl = m.Poster != null ? m.Poster.replace("localhost", currentIP) : "";

        Glide.with(holder.itemView.getContext())
                .load(thumbUrl)
                .placeholder(android.R.drawable.ic_menu_report_image)
                .into(holder.imgThumbnail);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(v.getContext(), MovieDetailActivity.class);
            intent.putExtra("NameMovie", m.NameMovie);
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