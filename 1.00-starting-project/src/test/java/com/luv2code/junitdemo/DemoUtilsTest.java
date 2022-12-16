package com.luv2code.junitdemo;

import org.junit.jupiter.api.*;

import java.lang.reflect.Method;
import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DemoUtilsTest.ReplaceCamelCase.class)
@TestMethodOrder(MethodOrderer.MethodName.class)
class DemoUtilsTest {
    private static DemoUtils demoUtils;

    @BeforeAll
    static void setUp() {
        demoUtils = new DemoUtils();
    }

    @Test
    void getAcademyInListTest() {
        List<String> academyInList = List.of("luv", "2", "code");

        assertIterableEquals(academyInList, demoUtils.getAcademyInList());
        assertLinesMatch(academyInList, demoUtils.getAcademyInList());
    }

    @Test
    void getAcademyTest() {
        String str = "Luv2Code";

        assertSame(demoUtils.getAcademy(), demoUtils.getAcademyDuplicate(), "Objects should refer to the same object");
        assertNotSame(str, demoUtils.getAcademyDuplicate(), "Objects should not refer to the same object");
    }

    @Test
    void getFirstThreeLettersOfAlphabetTest() {
        String[] firstThreeLettersOfAlphabet = {"A", "B", "C"};

        assertArrayEquals(firstThreeLettersOfAlphabet, demoUtils.getFirstThreeLettersOfAlphabet());
    }

    @Test
    void addTest() {
        assertEquals(6, demoUtils.add(1, 5));
        assertNotEquals(6, demoUtils.add(1, 1));
    }

    @Test
    void multiplyTest() {
        assertEquals(6, demoUtils.multiply(2, 3));
    }

    @Test
    void checkNullTest() {
        assertNotNull(demoUtils.checkNull(new Object()));
        assertNull(demoUtils.checkNull(null));
    }

    @Test
    void isGreaterTest() {
        assertTrue(demoUtils.isGreater(8, 3));
        assertFalse(demoUtils.isGreater(0, 3));
    }

    @Test
    void throwExceptionTest() {
        assertThrows(Exception.class, () -> demoUtils.throwException(-1));
        assertDoesNotThrow(() -> demoUtils.throwException(1));
    }

    @Test
    void checkTimeoutTest() {
        assertTimeoutPreemptively(Duration.ofSeconds(2), () -> demoUtils.checkTimeout(),
                "This test will fail immediately");
        assertTimeout(Duration.ofSeconds(2), () -> demoUtils.checkTimeout(),
                "This test will fail after all operations completing");
    }

    static class ReplaceCamelCase extends DisplayNameGenerator.Standard {
        public ReplaceCamelCase() {
        }

        public String generateDisplayNameForClass(Class<?> testClass) {
            return this.replaceCapitals(super.generateDisplayNameForClass(testClass));
        }

        public String generateDisplayNameForNestedClass(Class<?> nestedClass) {
            return this.replaceCapitals(super.generateDisplayNameForNestedClass(nestedClass));
        }

        public String generateDisplayNameForMethod(Class<?> testClass, Method testMethod) {
            return this.replaceCapitals(testMethod.getName());
        }

        private String replaceCapitals(String name) {
            name = name.replaceAll("([A-Z])", " $1");
            return name;
        }
    }
}