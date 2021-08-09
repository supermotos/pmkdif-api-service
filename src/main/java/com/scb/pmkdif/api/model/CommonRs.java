package com.scb.pmkdif.api.model;

import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@Accessors(chain = true)
public class CommonRs implements Serializable {
    private String data;
    private String code = "0000";
    private String message = "successful";
}


