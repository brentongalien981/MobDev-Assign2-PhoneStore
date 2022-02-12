package com.example.brenbaga_comp304_001_assign2;

import android.text.TextUtils;

import java.util.Arrays;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyValidator {

    public static void validateName(String fieldName, String val) throws Exception {

        MyValidator.validateMinLength(fieldName, val, 1);
        MyValidator.validateMaxLength(fieldName, val, 32);

    }

    private static void validateMaxLength(String fieldName, String val, int length) throws Exception {
        if (val.length() > length) {
            String exceptionMsg = "Oops! " + fieldName + " must be " + length + " characters or less.";
            throw new Exception(exceptionMsg);
        }
    }


    public static void validateMinLength(String fieldName, String val, int length) throws Exception {
        if (val.length() < length) {
            String exceptionMsg = "Oops! " + fieldName + " must be " + length + " characters or more.";
            throw new Exception(exceptionMsg);
        }
    }


    public static void validateExactLength(String fieldName, String val, int length) throws Exception {
        if (val.length() != length) {
            String exceptionMsg = "Oops! " + fieldName + " must be " + length + " characters.";
            throw new Exception(exceptionMsg);
        }
    }


    public static void validateEmail(String fieldName, String val) throws Exception {

        MyValidator.validateMinLength(fieldName, val, 5);
        MyValidator.validateMaxLength(fieldName, val, 64);

        String emailRegexPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(emailRegexPattern);
        Matcher matcher = pattern.matcher(val);

        if (!matcher.matches()) {
            String exceptionMsg = "Oops! " + fieldName + " is not valid.";
            throw new Exception(exceptionMsg);
        }

    }

    public static void validatePhoneNumber(String fieldName, String val) throws Exception {
        MyValidator.validateExactLength(fieldName, val, 10);

        if (!TextUtils.isDigitsOnly(val)) {
            String exceptionMsg = "Oops! " + fieldName + " is not valid.";
            throw new Exception(exceptionMsg);
        }
    }

    public static void validateAddress(String fieldName, String val) throws Exception {
        MyValidator.validateMinLength(fieldName, val, 4);
        MyValidator.validateMaxLength(fieldName, val, 128);
    }

    public static void validateProvince(String fieldName, String val) throws Exception {

        MyValidator.validateMinLength(fieldName, val, 2);
        MyValidator.validateMaxLength(fieldName, val, 64);

        val = val.toLowerCase();

        String[] canadaProvinceCodes = {"ab", "bc", "mb", "nb", "nl", "nt", "ns", "nu", "on", "pe", "qc", "sk", "yu"};

        for (int i = 0; i < canadaProvinceCodes.length; i++) {
            String provinceCode = canadaProvinceCodes[i];
            if (provinceCode.equals(val)) {
                return;
            }
        }


        String[] canadaProvinces = {"alberta", "british columbia", "manitoba", "new brunswick", "newfoundland and labrador", "northwest territories", "nova scotia", "nunavut", "ontario", "prince edward island", "quebec", "saskatchewan", "yukon"};

        for (int i = 0; i < canadaProvinces.length; i++) {
            String province = canadaProvinces[i];
            if (province.equals(val)) {
                return;
            }
        }


        String exceptionMsg = "Oops! " + fieldName + " is not a Canadian province.";
        throw new Exception(exceptionMsg);
    }



    public static void validatePostalCode(String fieldName, String val) throws Exception {

        MyValidator.validateMinLength(fieldName, val, 6);
        MyValidator.validateMaxLength(fieldName, val, 12);

        String regexPattern = "^[A-Za-z]\\d[A-Za-z][ -]?\\d[A-Za-z]\\d$";
        Pattern pattern = Pattern.compile(regexPattern);
        Matcher matcher = pattern.matcher(val);

        if (!matcher.matches()) {
            String exceptionMsg = "Oops! " + fieldName + " is not valid.";
            throw new Exception(exceptionMsg);
        }

    }



    public static void validatePaymentCardNumber(String fieldName, String val) throws Exception {
        MyValidator.validateExactLength(fieldName, val, 16);

        if (!TextUtils.isDigitsOnly(val)) {
            String exceptionMsg = "Oops! " + fieldName + " is not valid.";
            throw new Exception(exceptionMsg);
        }
    }


    public static void validateMonthNum(String fieldName, String val) throws Exception {
        MyValidator.validateMinLength(fieldName, val, 1);
        MyValidator.validateMaxLength(fieldName, val, 2);

        String exceptionMsg = "Oops! " + fieldName + " should be 1-12.";

        if (!TextUtils.isDigitsOnly(val)) {
            throw new Exception(exceptionMsg);
        }

        if (Integer.parseInt(val) < 1 || Integer.parseInt(val) > 12) {
            throw new Exception(exceptionMsg);
        }
    }



    public static void validateYearNum(String fieldName, String val) throws Exception {
        MyValidator.validateExactLength(fieldName, val, 4);

        String exceptionMsg = "Oops! " + fieldName + " is not valid.";

        if (!TextUtils.isDigitsOnly(val)) {
            throw new Exception(exceptionMsg);
        }

        if (Integer.parseInt(val) < 2022 || Integer.parseInt(val) > 2999) {
            throw new Exception(exceptionMsg);
        }
    }



    public static void validateCvc(String fieldName, String val) throws Exception {
        MyValidator.validateExactLength(fieldName, val, 3);

        String exceptionMsg = "Oops! " + fieldName + " is not valid.";

        if (!TextUtils.isDigitsOnly(val)) {
            throw new Exception(exceptionMsg);
        }
    }
}
