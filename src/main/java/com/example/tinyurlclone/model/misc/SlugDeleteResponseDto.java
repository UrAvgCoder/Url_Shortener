package com.example.tinyurlclone.model.misc;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SlugDeleteResponseDto {
    public SlugDeleteResponseDto() {
    }

    @JsonProperty("id")
    private String id;

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "SlugDeleteResponseDto{" +
                "id='" + id + '\'' +
                '}';
    }
}
