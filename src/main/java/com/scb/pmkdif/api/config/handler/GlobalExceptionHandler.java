package com.scb.pmkdif.api.config.handler;

import com.scb.pmkdif.api.model.ErrorDetailRs;
import com.scb.pmkdif.api.model.ErrorRs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.sql.Timestamp;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

import static com.scb.pmkdif.api.model.ErrorCodes.SE00001;

@ControllerAdvice
public class GlobalExceptionHandler {
    private static Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);


    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleException(ApiException ex) {
        ErrorDetailRs errorDetailRs = new ErrorDetailRs();
        List<ErrorRs> errors = Collections.singletonList(new ErrorRs(ex.getCode(), ex.getMessage()));
        errorDetailRs.setErrors(errors);
        errorDetailRs.setTimestamp(new Timestamp(System.currentTimeMillis()));
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(errorDetailRs, HttpStatus.CONFLICT);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorRs> handleException(Exception ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorRs(SE00001.name(), getCauseWithCaseId(ex.getMessage())), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorRs> handleException(BusinessException ex) {
        log.error(ex.getMessage(), ex);
        return new ResponseEntity<>(new ErrorRs(ex.getCode(), ex.getMessage()), HttpStatus.CONFLICT);
    }

    public String getCauseWithCaseId(String cause){
        return "ISSUE-ID: " + UUID.randomUUID().toString().replaceAll("-", "") + ", CAUSE BY:  " + cause;
    }
}
