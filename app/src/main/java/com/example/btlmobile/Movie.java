package com.example.btlmobile;

import com.google.gson.annotations.SerializedName;

public class Movie {

    @SerializedName("IDmovie")
    public String IDmovie;

    @SerializedName("NameMovie")
    public String NameMovie;

    @SerializedName("Category")
    public String Category;

    @SerializedName("ReleaseDate")
    public String ReleaseDate;

    @SerializedName("Director")
    public String Director;

    @SerializedName("Duration")
    public int Duration;

    @SerializedName("Country")
    public String Country;

    @SerializedName("Description")
    public String Description;

    @SerializedName("Status")
    public boolean Status;

    @SerializedName("ContentID")
    public String ContentID;

    @SerializedName("Poster")
    public String Poster;

    @SerializedName("Film")
    public String Film;
}