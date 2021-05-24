package com.assignment.android.common.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.stereotype.Component;

@Component
public class MessageUtils {
    private static ResourceBundleMessageSource messageSource;

    @Autowired
    MessageUtils(ResourceBundleMessageSource messageSource) {
        MessageUtils.messageSource = messageSource;
    }

    public static String getMessage(String msgCode) {
        var locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage(msgCode, null, locale);
    }
}
