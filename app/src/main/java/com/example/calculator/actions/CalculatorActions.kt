package com.example.calculator.actions

sealed class CalculatorActions {
    data class Number(val number: Int):CalculatorActions()

    object Clear: CalculatorActions()


    object Delete: CalculatorActions()
    object Decimal: CalculatorActions()
    object Calculate: CalculatorActions()

    data class Operations(val operations: CalculationOperations): CalculatorActions()

}
