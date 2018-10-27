package com.pptraining.webshop.service;

import com.pptraining.webshop.service.exception.*;

public class UserValidator {


    public static void isValidUserAccount(User user){
        if (user.getUsername() != null) {
            if (!UserValidator.isValidUsername(user.getUsername())) {
                throw new UserFieldFormatException("Username");
            }
        } else {
            throw new UserFieldNullException("Username");
        }

        if (user.getEmail() != null) {
            if (!UserValidator.isValidEmail(user.getEmail())) {
                throw new UserFieldFormatException("Email");
            }
        } else {
            throw new UserFieldNullException("Email");
        }

        if (user.getPassword() == null) {
            throw new UserFieldNullException("Password");
        }

        if (user.getFirstName() == null) {
            throw new UserFieldNullException("First name");
        }

        if (user.getLastName() == null) {
            throw new UserFieldNullException("Last name");
        }

        if (user.getPhoneNumber() != null) {
            if (!UserValidator.isValidPhoneNumber(user.getPhoneNumber())) {
                throw new UserFieldFormatException("Phone number");
            }
        }

        if (user.getAddress().getZipCode() != null) {
            if (!UserValidator.isValidZipCode(user.getAddress().getZipCode())) {
                throw new UserFieldFormatException("Zip Code");
            }
        }
    }

    public static boolean isValidUsername(String username){
        if(username.length()<=32 && username.length() >=8){
            return true;
        }
        return false;
    }

    public static boolean isValidEmail(String email){
        if(email.matches("(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`" +
                "{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]" +
                "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])" +
                "?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)" +
                "\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:" +
                "(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]" +
                "|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\\\])")){
            return true;
        }
        return false;
    }

    public static boolean isValidPhoneNumber(String phoneNumber){
        if(phoneNumber.matches("^[+]*[(]{0,1}[0-9]{1,4}[)]{0,1}[-\\s\\./0-9]*$")){
            return true;
        }
        return false;
    }

    public static boolean isValidZipCode(String zipCode){
        if(zipCode.matches("^[0-9]*(?:-[0-9]*)?$")){
            return true;
        }
        return false;
    }
}
