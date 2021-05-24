package com.assignment.android.common.response;


import com.assignment.android.common.constants.Constants;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ResponseData {
    private String errorCode; //Constants.ERROR_CODE.
    private String message;
    private Object data;

    public static ResponseData ofSuccess() {
        ResponseData responseData = new ResponseData();
        responseData.setErrorCode(Constants.RETURN_CODE_SUCCESS);
        return responseData;
    }

    public static ResponseData ofSuccess(String message) {
        ResponseData responseData = new ResponseData();
        responseData.setMessage(message);
        responseData.setErrorCode(Constants.RETURN_CODE_SUCCESS);
        return responseData;
    }

    public static ResponseData ofSuccess(String message, Object data) {
        ResponseData responseData = new ResponseData();
        responseData.setMessage(message);
        responseData.setData(data);
        responseData.setErrorCode(Constants.RETURN_CODE_SUCCESS);
        return responseData;
    }

    public static ResponseData ofFail(String message) {
        ResponseData responseData = new ResponseData();
        responseData.setMessage(message);
        responseData.setErrorCode(Constants.RETURN_CODE_ERROR);
        return responseData;
    }
}
