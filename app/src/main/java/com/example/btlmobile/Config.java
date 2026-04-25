package com.example.btlmobile;

public class Config {
    // Mỗi khi đổi mạng, bạn CHỈ CẦN thay đổi IP ở đúng dòng này
    public static final String IP_ADDRESS = "192.168.1.17";
    
    // Tự động tạo BASE_URL
    public static final String BASE_URL = "http://" + IP_ADDRESS + ":5000/";
}