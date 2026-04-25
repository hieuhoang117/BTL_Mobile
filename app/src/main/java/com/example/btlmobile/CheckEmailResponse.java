package com.example.btlmobile;

import com.google.gson.annotations.SerializedName;

public class CheckEmailResponse {
    @SerializedName("exists")
    public boolean exists;

    @SerializedName("role")
    public String role;
}