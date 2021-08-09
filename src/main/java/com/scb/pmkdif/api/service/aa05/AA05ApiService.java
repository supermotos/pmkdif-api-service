package com.scb.pmkdif.api.service.aa05;

import com.scb.pmkdif.api.config.handler.ApiException;
import com.scb.pmkdif.api.config.handler.BusinessException;
import com.scb.pmkdif.api.model.CommonRs;
import com.scb.pmkdif.api.model.ErrorCodes;
import com.scb.pmkdif.api.model.aa05.AA05Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AA05ApiService {
    private static Logger log = LoggerFactory.getLogger(AA05ApiService.class);

    public CommonRs xxx(AA05Request aa05Request) {
        if (aa05Request == null) {
            throw new BusinessException(ErrorCodes.SE00001);
            //throw new ApiException(ErrorCodes.AP00001);
        }
        return new CommonRs().setCode("0000");
    }
}