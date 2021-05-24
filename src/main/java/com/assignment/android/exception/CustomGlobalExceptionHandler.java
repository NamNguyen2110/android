package com.assignment.android.exception;

import com.assignment.android.common.constants.Constants;
import com.assignment.android.common.response.ResponseData;
import com.assignment.android.common.utils.MessageUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Locale;

@ControllerAdvice()
public class CustomGlobalExceptionHandler extends ResponseEntityExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(CustomGlobalExceptionHandler.class);

    private final MessageSource messageSource;

    public CustomGlobalExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    @ExceptionHandler(CustomGlobalException.class)
    public ResponseEntity<ResponseData> handleBadRequestException(CustomGlobalException ex) {
        log.info("Bad request exception");
        return ResponseEntity.ok(ResponseData.ofFail(ex.getMessage()));
    }

    @ExceptionHandler({SQLException.class,Exception.class})
    public ResponseEntity<ResponseData> handleSystemException() {
        var responseDTO = new ResponseData();
        responseDTO.setErrorCode(Constants.ERROR_CODE.SYSTEM_ERROR);
        responseDTO.setMessage(MessageUtils.getMessage("Lỗi hệ thống"));
        return ResponseEntity.status(HttpStatus.OK).body(responseDTO);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        var bindingResult = ex.getBindingResult();
        HashMap<String, String> fieldErrors = new HashMap<>();
        bindingResult.getFieldErrors().forEach(fieldError ->
                fieldErrors.put(fieldError.getField(), getText(fieldError.getDefaultMessage(), request.getLocale())));

        var responseData = new ResponseData();
        responseData.setMessage(getText("Dữ liệu không hợp lệ", request.getLocale()));
        responseData.setData(fieldErrors);
        responseData.setErrorCode(Constants.ERROR_CODE.VALIDATE_FAIL);
        return ResponseEntity.ok(responseData);

    }

    public String getText(String key, Locale locale) {
        try {
            return messageSource.getMessage(key, null, locale);
        } catch (Exception e) {
            e.printStackTrace();
            return key;

        }
    }
}
