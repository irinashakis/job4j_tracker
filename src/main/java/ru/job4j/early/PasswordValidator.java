package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        String rsl = "The password is valid";
        if (password == null) {
            throw new IllegalArgumentException("The password cannot be null");
        }
        if (password.length() <= 8 || password.length() >= 32) {
            throw new IllegalArgumentException("Invalid password length");
        }
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!Character.isUpperCase(ch)) {
                throw new IllegalArgumentException("The password does not contain at least one uppercase character");
            }
            if (!Character.isLowerCase(ch)) {
                throw new IllegalArgumentException("The password does not contain at least one lowercase character");
            }
            if (Character.isDigit(ch)) {
                throw new IllegalArgumentException("The password does not contain a digit");
            }
            if (Character.isUpperCase(ch) && Character.isLowerCase(ch) && Character.isDigit(ch)) {
                throw new IllegalArgumentException("The password does not contain a special character");
            }
        }
        String[] words = new String[]{"qwerty", "12345", "password", "admin", "user"};
        for (String word : words) {
            if (password.equalsIgnoreCase(word)) {
                throw new IllegalArgumentException("Such a word cannot be used");
            }
        }
        return rsl;
    }
}
