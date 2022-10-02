package ru.job4j.early;

public class PasswordValidator {
    public static String validate(String password) {
        String rsl = "The password is valid";
        if (password == null) {
            throw new IllegalArgumentException("The password cannot be null");
        }
        for (int i = 0; i < password.length(); i++) {
            char ch = password.charAt(i);
            if (!Character.isUpperCase(ch)) {
                rsl = "The password does not contain at least one uppercase character";
            }
            if (!Character.isLowerCase(ch)) {
                rsl = "The password does not contain at least one lowercase character";
            }
            if (Character.isDigit(ch)) {
                rsl = "The password does not contain a digit";
            }
        }
        if (!(password.contains("@") || password.contains("#")
                || password.contains("!") || password.contains("~")
                || password.contains("$") || password.contains("%")
                || password.contains("^") || password.contains("&")
                || password.contains("*") || password.contains("(")
                || password.contains(")") || password.contains("-")
                || password.contains("+") || password.contains("/")
                || password.contains(":") || password.contains(".")
                || password.contains(", ") || password.contains("<")
                || password.contains(">") || password.contains("?")
                || password.contains("|"))) {
            rsl = "The password does not contain a special character";
        }
        String[] words = new String[]{"qwerty", "12345", "password", "admin", "user"};
        for (String word : words) {
            if (password.equalsIgnoreCase(word)) {
                rsl = "Such a word cannot be used";
                break;
            }
        }
        if (password.length() <= 8 || password.length() >= 32) {
            rsl = "Invalid password length";
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println(PasswordValidator.validate("Ky"));
    }
}
