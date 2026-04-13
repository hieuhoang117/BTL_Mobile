package com.example.btlmobile;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class EpisodeAdapter extends RecyclerView.Adapter<EpisodeAdapter.EpisodeViewHolder> {

    private List<Episode> list;
    private OnEpisodeClickListener listener;

    public interface OnEpisodeClickListener {
        void onEpisodeClick(Episode episode);
    }

    public EpisodeAdapter(List<Episode> list, OnEpisodeClickListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public class EpisodeViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle, tvDuration;
        ImageView imgThumb;

        public EpisodeViewHolder(View itemView) {
            super(itemView);
            tvTitle = itemView.findViewById(R.id.tvEpisodeTitle);
            tvDuration = itemView.findViewById(R.id.tvEpisodeDuration);
            imgThumb = itemView.findViewById(R.id.imgEpisodeThumb);
        }
    }

    @Override
    public EpisodeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_episode, parent, false);
        return new EpisodeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EpisodeViewHolder holder, int position) {
        Episode e = list.get(position);
        holder.tvTitle.setText("Tập " + e.EpisodeNumber + ": " + e.EpisodeName);
        holder.tvDuration.setText(e.Duration + " phút");

        String currentIP = "192.168.1.13";
        String thumbUrl = e.ThumbnailURL != null ? e.ThumbnailURL.replace("localhost", currentIP) : "";

        Glide.with(holder.itemView.getContext())
                .load(thumbUrl)
                .placeholder(android.R.drawable.ic_media_play)
                .into(holder.imgThumb);

        holder.itemView.setOnClickListener(v -> listener.onEpisodeClick(e));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}