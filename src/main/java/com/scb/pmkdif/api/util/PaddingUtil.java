package com.scb.pmkdif.api.util;

import org.springframework.stereotype.Component;

@Component
public class PaddingUtil {

    public String padMobileNumber(String mobileNumber) {

        final String patternMobile = "^(\\d{3})(\\d{3})(\\d{3})(\\d{1})$";
        final String replacement = "xxx-xxx$3-$4";
        if (mobileNumber.isEmpty()) {
            return "";
        }

        return mobileNumber.replaceAll(patternMobile, replacement);
    }

    public String padCitizenId(String citizenId) {

        final String pattern = "^(\\d{1})(\\d{4})(\\d{4})(\\d{1})(\\d{3})$";
        final String replacement = "$1-$2-$3x-xxx";

        if (citizenId.isEmpty()) {
            return "";
        }

        return citizenId.replaceAll(pattern, replacement);
    }
}
