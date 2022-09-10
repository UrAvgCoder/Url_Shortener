package com.example.tinyurlclone.service;

import com.example.tinyurlclone.model.Url;
import com.example.tinyurlclone.model.UrlDto;
import com.example.tinyurlclone.repository.UrlRepository;
import com.google.common.hash.Hashing;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;

import static java.time.LocalDateTime.parse;

@Service
public class UrlServiceImpl implements UrlService {
    @Autowired
    private UrlRepository urlRepository;

    @Override
    public Url generateShortLink(UrlDto urlDto) {
        if (StringUtils.isEmpty(urlDto.getUrl())) return null;

        String encodedUrl = encodeUrl(urlDto.getUrl());
        if(encodedUrl.equals("INVALID_URL")) return null;

        Url urlToPersist = new Url();
        urlToPersist.setCreationDate(LocalDateTime.now());
        urlToPersist.setOriginalUrl(urlDto.getUrl());
        urlToPersist.setShortLink(encodedUrl);
        urlToPersist.setExpirationDate(getExpirationDate(urlDto.getExpirationDate(),urlToPersist.getCreationDate()));

        return persistShortLink(urlToPersist);
    }

    private String encodeUrl(String url) {
        UrlValidator urlValidator = new UrlValidator(new String[]{"http", "https"});
        if(!urlValidator.isValid(url)) return "INVALID_URL";

        String encodedUrl = "";
        LocalDateTime time = LocalDateTime.now();
        encodedUrl = Hashing.murmur3_32_fixed()
                .hashString(url.concat(time.toString()), StandardCharsets.UTF_8)
                .toString();
        return encodedUrl;
    }

    private LocalDateTime getExpirationDate(String expirationDate, LocalDateTime creationDate) {
        if(StringUtils.isBlank(expirationDate))
        {
            return creationDate.plusDays(1);
        }
        return parse(expirationDate);
    }

    @Override
    public Url persistShortLink(Url url) {
        Url urlToRet = urlRepository.save(url);
        return urlToRet;
    }

    @Override
    public Url getEncodedUrl(String url) {
        Url urlToRet = urlRepository.findByShortLink(url);
        return urlToRet;
    }

    @Override
    public void deleteShortLink(Url url) {
        urlRepository.delete(url);
    }
}
