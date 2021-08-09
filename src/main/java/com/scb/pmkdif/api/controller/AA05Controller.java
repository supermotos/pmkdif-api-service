package com.scb.pmkdif.api.controller;

import com.scb.pmkdif.api.model.aa05.AA05Request;
import com.scb.pmkdif.api.service.aa05.AA05ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
@RequestMapping("/v1/aa05")
public class AA05Controller {

    @Autowired
    private AA05ApiService aa05ApiService;

    @PostMapping("/1")
    public void receiveData(@Valid @RequestBody AA05Request aa05Request) {
        aa05ApiService.xxx(aa05Request);
    }
}
