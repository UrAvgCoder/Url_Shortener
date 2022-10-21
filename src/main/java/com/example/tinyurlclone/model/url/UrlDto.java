package com.example.tinyurlclone.model.url;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UrlDto {
    @JsonProperty("long_url")
    private String longUrl;

    public UrlDto(String url) {
        this.longUrl = url;
    }

    public UrlDto() {
    }

    public String getUrl() {
        return longUrl;
    }

    public void setUrl(String url) {
        this.longUrl = url;
    }


    @Override
    public String toString() {
        return "UrlDto{" +
                "long_url='" + longUrl + '\'' +
                '}';
    }
}
