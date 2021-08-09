package com.scb.pmkfe.api.util;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.scb.pmkdif.api.util.JsonUtil;
import com.scb.pmkdif.api.util.MaskingUtil;
import org.apache.commons.lang.StringUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ExtendWith(MockitoExtension.class)
public class JsonUtilTest {

    private static final Logger log = LoggerFactory.getLogger(JsonUtilTest.class);

    @Test
    public void jsonToStringSuccessTest() throws JsonProcessingException {
        ObjectMapper c = new ObjectMapper();
        MaskingUtil m = new MaskingUtil();
        JsonUtil jsonUtil = new JsonUtil(c,m);

        String jsonInput = "{\n" +
                "  \"applicationKey\": \"l7a50ef1ad80614dd888096507bd7417b3\",\n" +
                "  \"applicationSecret\": \"8c039c2b7efe462ca832e6ad7c089faf\",\n" +
                "  \"authCode\": \"9ae0bade-9323-4657-8de2-460baeed29d1\"\n" +
                "}";

        String result = jsonUtil.jsonToString(jsonInput);
        Assert.assertTrue(!StringUtils.isEmpty(result));
    }
}
