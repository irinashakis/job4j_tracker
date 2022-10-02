package ru.job4j.early;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PasswordValidatorTest {

    @Test
    void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    PasswordValidator.validate(null);
                });
        assertThat(exception.getMessage()).isEqualTo("The password cannot be null");
    }

    @Test
    public void whenLength() {
        String in = "Bye";
        String result = PasswordValidator.validate(in);
        String expected = "Invalid password length";
        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void whenUpperCase() {
        String in = "hollo$$$gggg";
        String result = PasswordValidator.validate(in);
        String expected = "The password does not contain at least one uppercase character";
        assertThat(result).isEqualTo(expected);
    }
}