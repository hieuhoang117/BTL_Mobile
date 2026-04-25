package com.example.btlmobile;

import com.google.gson.annotations.SerializedName;

public class User {

    @SerializedName("UserID")
    public String UserID;

    @SerializedName("FullName")
    public String FullName;

    @SerializedName("Email")
    public String Email;

    @SerializedName("PasswordHash")
    public String PasswordHash;

    @SerializedName("Phone")
    public String Phone;

    @SerializedName("Role")
    public String Role;

    @SerializedName("CreatedAt")
    public String CreatedAt;

    @SerializedName("Status")
    public boolean Status;
}