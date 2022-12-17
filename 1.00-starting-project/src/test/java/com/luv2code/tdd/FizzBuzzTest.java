package com.luv2code.tdd;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class FizzBuzzTest {

    @DisplayName("Divisible by three")
    @Test
    @Order(1)
    void testForDivisibleByThree() {
        assertEquals("Fizz", FizzBuzz.compute(3));
    }

    @DisplayName("Divisible by five")
    @Test
    @Order(2)
    void testForDivisibleByFive() {
        assertEquals("Buzz", FizzBuzz.compute(5));
    }

    @DisplayName("Divisible by three & five")
    @Test
    @Order(3)
    void testForDivisibleByThreeAndFive() {
        assertEquals("FizzBuzz", FizzBuzz.compute(15));
    }

    @DisplayName("Print number")
    @Test
    @Order(4)
    void testForDivisibleByNeitherThreeNorFive() {
        assertEquals("1", FizzBuzz.compute(1));
    }

    @DisplayName("Parametrized test")
    @Test
    @Order(5)
    void parametrizedTest() {
        String[][] data = {
                {"1", "1"},
                {"2", "2"},
                {"3", "Fizz"},
                {"4", "4"},
                {"5", "Buzz"},
                {"6", "Fizz"},
                {"7", "7"},
                {"8", "8"},
                {"9", "Fizz"},
                {"10", "Buzz"},
                {"11", "11"},
                {"12", "Fizz"},
                {"13", "13"},
                {"14", "14"},
                {"15", "FizzBuzz"}
        };

        for (int i = 0; i < data.length; i++) {
            String value = data[i][0];
            String expected = data[i][1];

            assertEquals(expected, FizzBuzz.compute(Integer.parseInt(value)));
        }
    }

    @DisplayName("Testing with small CSV file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/small-test-data.csv")
    @Order(6)
    void testingWithSmallCsvFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing with medium CSV file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/medium-test-data.csv")
    @Order(6)
    void testingWithMediumCsvFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }

    @DisplayName("Testing with large CSV file")
    @ParameterizedTest(name = "value={0}, expected={1}")
    @CsvFileSource(resources = "/large-test-data.csv")
    @Order(6)
    void testingWithLargeCsvFile(int value, String expected) {
        assertEquals(expected, FizzBuzz.compute(value));
    }
}