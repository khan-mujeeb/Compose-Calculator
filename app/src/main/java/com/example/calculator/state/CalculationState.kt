package com.example.calculator.state

import com.example.calculator.actions.CalculationOperations

data class CalculationState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculationOperations? = null,
    val previous: String = ""
)
