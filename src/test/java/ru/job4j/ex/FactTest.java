package ru.job4j.ex;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class FactTest {

    @Test
    public void whenException() {
        IllegalArgumentException exception = assertThrows(
                IllegalArgumentException.class,
                () -> {
                    Fact fact = new Fact();
                    fact.calc(-5);
                });
        assertThat(exception.getMessage()).isEqualTo("N could not be less then 0");
    }
}