package ru.samara.ta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {
    private static final String TEST_STRING = "Что такое новый год? новый год — мороз и лед!";
    private static final int TEST_STRING_LENGTH = TEST_STRING.length();
    private static org.slf4j.Logger log;

    @Test(testName = "Получить значение, когда начальный индекс = конечному")
    public void testZeroLength() throws StringIndexOutOfBoundsException {
        String response = TEST_STRING.substring(5, 5);
        Assert.assertEquals(response, "");
    }

    @Test(testName = "Получить строку, начинающуюся с 5 символа")
    public void testGetStringFromFifthIndex() throws StringIndexOutOfBoundsException {
        String response = TEST_STRING.substring(5);
        Assert.assertEquals(response, "акое новый год? новый год — мороз и лед!");
    }

    @Test(testName = "Получить всю строку")
    public void testGetStringFromFirstToLastIndex() throws StringIndexOutOfBoundsException {
        String response = TEST_STRING.substring(0, TEST_STRING_LENGTH);
        Assert.assertEquals(response, TEST_STRING);
    }

    @Test(testName = "Получить строку, начинающуюся с 6 по 13 символ")
    public void testGetStringFromSixthToThirteenthIndex() throws StringIndexOutOfBoundsException {
        String response = TEST_STRING.substring(6, 13);
        Assert.assertEquals(response, "кое нов");
    }

    @Test(testName = "Получить строку, если передан номер символа > длины строки", expectedExceptions = {StringIndexOutOfBoundsException.class})
    public void testGetStringByNonexistentIndex() throws StringIndexOutOfBoundsException {
        setUp("testGetStringByNonexistentIndex");
        try {
            TEST_STRING.substring(TEST_STRING_LENGTH + 5);
        } catch (StringIndexOutOfBoundsException e) {
            logAndThrowException(e);
        }
    }

    @Test(testName = "Получить строку с первого по последний символ + 1", expectedExceptions = {StringIndexOutOfBoundsException.class})
    public void testGetStringFromFirstToIncrementalLastIndex() throws StringIndexOutOfBoundsException {
        setUp("testGetStringFromFirstToIncrementalLastIndex");
        try {
            TEST_STRING.substring(0, TEST_STRING_LENGTH + 1);
        } catch (StringIndexOutOfBoundsException e) {
            logAndThrowException(e);
        }
    }

    @Test(testName = "Индекс начала > Индекса окончания", expectedExceptions = {StringIndexOutOfBoundsException.class})
    public void testGetStringWithLargerStartingIndex() throws StringIndexOutOfBoundsException {
        setUp("testGetStringWithLargerStartingIndex");
        try {
            TEST_STRING.substring(8, 2);
        } catch (StringIndexOutOfBoundsException e) {
            logAndThrowException(e);
        }
    }

    @Test(testName = "Получить строку, если передан отрицательный индекс", expectedExceptions = {StringIndexOutOfBoundsException.class})
    public void testGetStringByNegativeIndex() throws StringIndexOutOfBoundsException {
        setUp("testGetStringByNegativeIndex");
        try {
            TEST_STRING.substring(-3);
        } catch (StringIndexOutOfBoundsException e) {
            logAndThrowException(e);
        }
    }

    private static void setUp(String name) {
        log = org.slf4j.LoggerFactory.getLogger(name);
    }

    private static void logAndThrowException(StringIndexOutOfBoundsException e) throws StringIndexOutOfBoundsException {
        log.info("message: " + e.getMessage());
        throw e;
    }
}

