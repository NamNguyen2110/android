package com.assignment.android.common.constants;

public final class Constants {
    public Constants() {}

    public static final String PATH_AVATAR = "";
    public static final String RANDOM_NUMBER = "999999";
    public static final String EXPIRED_TIME_BY_MINUTES = "5";

    public static final int ON = 1;
    public static final int OFF = 0;

    public static final String SYSTEM_ACCOUNT = "system";
    public static final String DEFAULT_LANGUAGE = "vi";
    public static final String ANONYMOUS_USER = "anonymoususer";

    public static final String USERNAME = "username";
    public static final String PASSWORD = "password";


    public static final String RETURN_CODE_SUCCESS = "200";
    public static final String RETURN_CODE_ERROR = "400";


    public static final class ERROR_CODE {

        public static final String SUCCESS = "0";
        public static final String FAIL = "1";
        public static final String VALIDATE_FAIL = "2";

        public static final String SYSTEM_ERROR = "-1";
    }

    public static final class STATUS {
        public static final String ACTIVE = "1";
        public static final String DEACTIVATE = "0";
        public static final String PENDING = "2";
    }

    public static final class GENDER {
        public static final Integer MALE = 1;
        public static final Integer FEMALE = 0;
    }

    public static class STATUS_COMMON {
        public static final Boolean RESPONSE_STATUS_TRUE = true;
        public static final Boolean RESPONSE_STATUS_FALSE = false;
    }
}
