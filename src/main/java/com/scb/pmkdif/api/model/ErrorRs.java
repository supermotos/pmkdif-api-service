package com.scb.pmkdif.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
@AllArgsConstructor
public class ErrorRs implements Serializable {
    private String errorCode;
    private String errorDesc;
}