package com.scb.pmkdif.api.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class JsonUtil {

    private final ObjectMapper objectMapper;

    private final MaskingUtil maskingUtil;

    public JsonUtil(ObjectMapper objectMapper, MaskingUtil maskingUtil) {

        this.objectMapper = objectMapper;
        this.maskingUtil = maskingUtil;
    }

    public String jsonToString(Object o) throws JsonProcessingException {

        String json = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);

        return json;
    }

    public <T> T toJson(String jsonString, Class<T> o) {

        Gson gson = new Gson();
        return gson.fromJson(jsonString, o);
    }
}
