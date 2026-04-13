package com.example.btlmobile;

import com.google.gson.annotations.SerializedName;

public class Episode {

    @SerializedName("IDEpisode")
    public String IDEpisode;

    @SerializedName("EpisodeName")
    public String EpisodeName;

    @SerializedName("EpisodeNumber")
    public int EpisodeNumber;

    @SerializedName("SeasonNumber")
    public int SeasonNumber;

    @SerializedName("ContentID")
    public String ContentID;

    @SerializedName("Duration")
    public int Duration;

    @SerializedName("IDseries")
    public String IDseries;

    @SerializedName("film")
    public String film;

    @SerializedName("ThumbnailURL")
    public String ThumbnailURL;

    @SerializedName("EpisodeDescription")
    public String EpisodeDescription;

    @SerializedName("ReleaseDate")
    public String ReleaseDate;
}