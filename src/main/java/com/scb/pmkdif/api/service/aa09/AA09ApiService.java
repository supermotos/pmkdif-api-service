package com.scb.pmkdif.api.service.aa09;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.scb.pmkdif.api.util.JsonUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class AA09ApiService {
    private static Logger log = LoggerFactory.getLogger(AA09ApiService.class);

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private JsonUtil jsonUtil;


    @Value("${dif.api.aa09.url}")
    private String difUrl;


    public void xxx() throws JsonProcessingException {
        String a ="dd";
        jsonUtil.jsonToString(a);
        log.info("");
        HttpHeaders httpHeaders = new HttpHeaders();
        List<String> req = new ArrayList<>();
        HttpEntity httpEntity = new HttpEntity(req, httpHeaders);
        restTemplate.exchange(difUrl, HttpMethod.POST, httpEntity, new ParameterizedTypeReference<List<String>>() {});
    }
}