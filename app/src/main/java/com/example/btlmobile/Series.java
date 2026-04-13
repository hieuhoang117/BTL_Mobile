package com.example.btlmobile;

import com.google.gson.annotations.SerializedName;

public class Series {

    @SerializedName("IDseries")
    public String IDseries;

    @SerializedName("SeriesName")
    public String SeriesName;

    @SerializedName("Description")
    public String Description;

    @SerializedName("ReleaseYear")
    public String ReleaseYear;

    @SerializedName("Country")
    public String Country;

    @SerializedName("Status")
    public boolean Status;

    @SerializedName("ContentID")
    public String ContentID;

    @SerializedName("poster")
    public String poster;

    @SerializedName("Category")
    public String Category;
}