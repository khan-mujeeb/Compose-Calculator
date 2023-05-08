package com.example.calculator.actions

sealed class CalculationOperations(val symbol: String) {
    object Add: CalculationOperations("+")
    object Subtract: CalculationOperations("-")
    object Multiple: CalculationOperations("*")
    object Divide: CalculationOperations("/")
}
