package com.scb.pmkdif.api.controller;

import com.scb.pmkdif.api.service.aa09.AA09ApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/aa09")
public class AA09Controller {

    @Autowired
    private AA09ApiService aa09ApiService;

    @GetMapping("/")
    public void xxx() throws Exception {
        aa09ApiService.xxx();
    }
}
