package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void whenExceptionNull() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("The password cannot be null");
    }

    @Test
    void whenExceptionLength() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("Ho");
                });
        assertThat(exception.getMessage()).isEqualTo("Invalid password length");
    }

    @Test
    void whenExceptionUpperCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("1hellO1234$");
                });
        assertThat(exception.getMessage()).isEqualTo("The password does not contain at least one uppercase character");
    }

    @Test
    void whenExceptionLowerCase() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("1HELLO1234$");
                });
        assertThat(exception.getMessage()).isEqualTo("The password does not contain at least one lowercase character");
    }

    @Test
    void whenExceptionDigit() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("HElLooooo$");
                });
        assertThat(exception.getMessage()).isEqualTo("The password does not contain a digit");
    }

   /* @Test
    void whenExceptionSpecial() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("hEllo123456");
                });
        assertThat(exception.getMessage()).isEqualTo("The password does not contain a special character");
    }*/

    @Test
    void whenExceptionWord() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate("password");
                });
        assertThat(exception.getMessage()).isEqualTo("Such a word cannot be used");
    }
   /*@Test
    public void whenValid() {
        String in = "Hello1$$";
        String result = PasswordValidator.validate(in);
        String expected = "The password is valid";
        assertThat(result).isEqualTo(expected);
    }*/
}