package com.scb.pmkdif.api.util;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class MaskingUtil {

    public String maskAccountNo(String accountNo) {

        if (StringUtils.isEmpty(accountNo)) {

            return "";
        }

        final String pattern = "^(\\d{3})(\\d{1})(\\d{5})(\\d{1})$";
        final String replacement = "xxx-x$3-$4";


        return accountNo.replaceAll(pattern, replacement);
    }

    public String maskPrefix(String text, int unMaskSize) {

        if (StringUtils.isEmpty(text)) {

            return "";
        }

        boolean isTextLessThanUnMaskSize = text.length() < unMaskSize;

        if (isTextLessThanUnMaskSize) {

            throw new IllegalArgumentException("text size less than unMaskSize.");
        }

        final int originSize = text.length();
        final int prefixMaskSize = originSize - unMaskSize;

        String prefixText = new String(new char[prefixMaskSize]).replace("\0", "x");

        String postfixText = text.substring(prefixMaskSize);

        return prefixText.concat(postfixText);
    }

    public String maskCitizenId(String citizenId) {

        final String pattern = "^(\\d{1})(\\d{4})(\\d{4})(\\d{1})(\\d{3})$";
        final String replacement = "$1-$2-$3x-xx-x";

        if (citizenId.isEmpty()) {
            return "";
        }

        return citizenId.replaceAll(pattern, replacement);
    }
}
