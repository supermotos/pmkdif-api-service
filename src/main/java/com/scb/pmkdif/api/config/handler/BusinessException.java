package com.scb.pmkdif.api.config.handler;

import com.scb.pmkdif.api.model.ErrorCodes;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.CONFLICT)
public class BusinessException extends StatusCodeException {

    public BusinessException(ErrorCodes code) {
        super(code.name(), code.getMessage());
    }

    public BusinessException(ErrorCodes code, String moreDesc) {
        super(code.name(), code.getMessage() + " -> " + moreDesc);
    }

    public BusinessException(ErrorCodes code, String value, String suffix) {
        super(code.name(), code.getMessage() +  value + suffix);
    }
}
