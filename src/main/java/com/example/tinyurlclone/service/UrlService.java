package com.example.tinyurlclone.service;

import com.example.tinyurlclone.model.Url;
import com.example.tinyurlclone.model.UrlDto;

public interface UrlService {
    public Url generateShortLink(UrlDto urlDto);
    public Url persistShortLink(Url url);
    public Url getEncodedUrl(String url);
    public  void  deleteShortLink(Url url);
}
