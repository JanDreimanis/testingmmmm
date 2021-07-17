package com.java14.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.*;

class ComplexFormulaAnalyzerTest {
    private ComplexFormulaAnalyzer complexFormulaAnalyzer = new ComplexFormulaAnalyzer();

    @ParameterizedTest
    @CsvFileSource(resources = "/test_data.csv", delimiter = ';')
    void applyFormula(double param, double expected, double delta) {
        System.out.println(param + " " + expected + " " + delta);

        Double result = complexFormulaAnalyzer.applyFormula(param);
        assertEquals(expected, result, delta);

    }
}