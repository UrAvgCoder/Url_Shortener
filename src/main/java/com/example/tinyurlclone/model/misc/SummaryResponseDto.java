package com.example.tinyurlclone.model.misc;

import com.fasterxml.jackson.annotation.JsonProperty;

public class SummaryResponseDto {

    @JsonProperty("total_clicks")
    private int count;

    public SummaryResponseDto() {
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "SummaryResponseDto{" +
                "total_clicks=" + count +
                '}';
    }
}
