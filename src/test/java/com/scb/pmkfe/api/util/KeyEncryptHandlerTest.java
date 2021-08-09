package com.scb.pmkfe.api.util;

import com.scb.pmkdif.api.util.KeyDecryptHandler;
import com.scb.pmkdif.api.util.KeyEncryptHandler;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

@ExtendWith(MockitoExtension.class)
public class KeyEncryptHandlerTest {

    private static final Logger log = LoggerFactory.getLogger(KeyEncryptHandlerTest.class);

//    @Value("${application.secret-key}")
    private String secretKey = "cbf99a6322868ccf";

    @Test
    public void encryptSuccessTest() {

        String inputText = "pmkfesit1234!";
        log.debug("input text: {}", inputText);

        String textEncrypt = KeyEncryptHandler.encrypt(inputText, secretKey);

        log.debug("result: {}", textEncrypt);

        Assert.assertTrue(!StringUtils.isEmpty(textEncrypt));

    }


    @Test
    public void decryptSuccessTest() {

        String inputText = "Mz0/J2QP9ZWnTKmMPs99Jw==";
        log.debug("input text: {}", inputText);

        String textDecrypt = KeyDecryptHandler.decrypt(inputText, secretKey);

        log.debug("result: {}", textDecrypt);

        Assert.assertTrue(!StringUtils.isEmpty(textDecrypt));

    }

    @Test
    public void encryptAndDecryptSuccessTest() {

        String inputText = "1288";
        String inputTextEncrypt = KeyEncryptHandler.encrypt(inputText, secretKey);
        String inputTextDecrypt = KeyDecryptHandler.decrypt(inputTextEncrypt, secretKey);

        log.debug("inputText: {}", inputText);
        log.debug("inputTextEncrypt: {}", inputTextEncrypt);
        log.debug("inputTextDecrypt: {}", inputTextDecrypt);

        Assert.assertTrue(inputTextDecrypt.equals(inputText));

    }

    @Test
    public void encryptByteTest() {

        byte[] iv = secretKey.getBytes();

        log.debug("result: {}", new String(iv));
    }
}
