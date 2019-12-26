package ru.samara.ta;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass {
    private static final String TEST_STRING = "Что такое новый год? новый год — мороз и лед!";
    private static final int TEST_STRING_LENGTH = TEST_STRING.length();

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

    @Test(testName = "Получить строку, если передан номер символа > длины строки", expectedExceptions = {StringIndexOutOfBoundsException.class},
            expectedExceptionsMessageRegExp = "String index out of range: -5")
    public void testGetStringByNonexistentIndex() throws StringIndexOutOfBoundsException {
        TEST_STRING.substring(TEST_STRING_LENGTH + 5);
    }

    @Test(testName = "Получить строку с первого по последний символ + 1", expectedExceptions = {StringIndexOutOfBoundsException.class},
            expectedExceptionsMessageRegExp = "begin 0, end 46, length 45")
    public void testGetStringFromFirstToIncrementalLastIndex() throws StringIndexOutOfBoundsException {
        TEST_STRING.substring(0, TEST_STRING_LENGTH + 1);
    }

    @Test(testName = "Индекс начала > Индекса окончания", expectedExceptions = {StringIndexOutOfBoundsException.class},
            expectedExceptionsMessageRegExp = "begin 8, end 2, length 45")
    public void testGetStringWithLargerStartingIndex() throws StringIndexOutOfBoundsException {
        TEST_STRING.substring(8, 2);
    }

    @Test(testName = "Получить строку, если передан отрицательный индекс", expectedExceptions = {StringIndexOutOfBoundsException.class},
            expectedExceptionsMessageRegExp = "String index out of range: -3")
    public void testGetStringByNegativeIndex() throws StringIndexOutOfBoundsException {
        TEST_STRING.substring(-3);
    }
}

