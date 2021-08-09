package com.scb.pmkdif.api.model;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;

@Data
public class ErrorDetailRs implements Serializable {
    private Timestamp timestamp;
    private List<ErrorRs> errors;
}
