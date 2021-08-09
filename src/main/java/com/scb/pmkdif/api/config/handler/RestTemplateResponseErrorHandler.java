package com.scb.pmkdif.api.config.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class RestTemplateResponseErrorHandler
        implements ResponseErrorHandler {
    private static Logger log = LoggerFactory.getLogger(RestTemplateResponseErrorHandler.class);

    @Override
    public boolean hasError(ClientHttpResponse httpResponse)
            throws IOException {

        log.info("httpResponse.getStatusCode.series {}", httpResponse
                .getStatusCode()
                .series());

        return (httpResponse
                .getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR || httpResponse
                .getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR);
    }

    @Override
    public void handleError(ClientHttpResponse httpResponse)
            throws IOException {
        if (httpResponse
                .getStatusCode()
                .series() == HttpStatus.Series.SERVER_ERROR) {
            //Handle SERVER_ERROR
            throw new HttpClientErrorException(httpResponse.getStatusCode());
        } else if (httpResponse
                .getStatusCode()
                .series() == HttpStatus.Series.CLIENT_ERROR) {
            //Handle CLIENT_ERROR
            throw new HttpClientErrorException(httpResponse.getStatusCode());
        }
    }
}