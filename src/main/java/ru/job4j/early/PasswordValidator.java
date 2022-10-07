package ru.job4j.early;

public class PasswordValidator {

    public static String validate(String password) {
        String rsl = "The password is valid";
        if (password == null) {
            throw new IllegalArgumentException("The password cannot be null");
        }
        if (password.length() < 8 || password.length() > 32) {
            throw new IllegalArgumentException("Invalid password length");
        }
        String[] words = new String[]{"qwerty", "12345", "password", "admin", "user"};
        for (String word : words) {
            if (password.equalsIgnoreCase(word)) {
                throw new IllegalArgumentException("Such a word cannot be used");
            }
        }
        boolean checkU = false;
        boolean checkL = false;
        boolean checkD = false;
        boolean checkS = false;
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (Character.isUpperCase(ch)) {
                checkU = true;
            }
            if (Character.isLowerCase(ch)) {
                checkL = true;
            }
            if (Character.isDigit(ch)) {
                checkD = true;
            }
            if (!Character.isUpperCase(ch) && !Character.isLowerCase(ch) && !Character.isDigit(ch)) {
                checkS = true;
            }
            if (checkU == checkL == checkD == checkS) {
                break;
            }
        }
        if (!checkU) {
            throw new IllegalArgumentException("The password does not contain at least one uppercase character");
        }
        if (!checkL) {
            throw new IllegalArgumentException("The password does not contain at least one lowercase character");
        }
        if (!checkD) {
            throw new IllegalArgumentException("The password does not contain a digit");
        }
        if (!checkS) {
            throw new IllegalArgumentException("The password does not contain a special character");
        }
        return rsl;
    }
}

