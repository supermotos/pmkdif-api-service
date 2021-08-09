package com.scb.pmkfe.api.service;

import com.scb.pmkdif.api.model.CommonRs;
import com.scb.pmkdif.api.model.aa05.AA05Request;
import com.scb.pmkdif.api.service.aa05.AA05ApiService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.Assert.assertEquals;

@ExtendWith(MockitoExtension.class)
public class AA05ApiServiceTest {

    @InjectMocks
    private AA05ApiService aa05ApiService;


    @Nested
    @DisplayName("test")
    class test {

        @Test
        @DisplayName("xxx")
        public void xxxx() {
            AA05Request aa05RequestMock = new AA05Request();
            CommonRs commonRs = aa05ApiService.xxx(aa05RequestMock);
            assertEquals("0000", commonRs.getCode());
        }

    }
}
