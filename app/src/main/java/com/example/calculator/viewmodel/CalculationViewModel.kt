package com.example.calculator.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.calculator.actions.CalculationOperations
import com.example.calculator.actions.CalculatorActions
import com.example.calculator.state.CalculationState

class CalculationViewModel: ViewModel() {
    var state by mutableStateOf(CalculationState())
        private set

    fun onAction(actions: CalculatorActions) {
        when(actions) {
            is CalculatorActions.Number -> enterNumber(actions.number)
            is CalculatorActions.Decimal -> enterDecimal()
            is CalculatorActions.Clear -> state = CalculationState()
            is CalculatorActions.Operations -> enterOperations(actions.operations)
            is CalculatorActions.Calculate -> performCalculation()
            is CalculatorActions.Delete -> performDelection()
        }
    }

    private fun enterNumber(number: Int) {
        if (state.operation == null) {

            if (state.operation == null) {
                if (state.number1.length >= MAX_NUM_LENGTH) return

                state = state.copy(
                    number1 = state.number1 + number
                )
                return
            }
        }
        if (state.number2.length >= MAX_NUM_LENGTH) return

        state = state.copy(
            number2 = state.number2 + number
        )
        return
    }

    private fun enterDecimal() {
        if (state.operation != null && !state.number1.contains('.')
        ) {
            if ( state.number1.isNotBlank()) {
                state = state.copy(
                    number1 = state.number1 + "."
                )
                return
            }

        }

        if ( !state.number2.contains('.') ) {
            if ( state.number2.isNotBlank()) {
                state = state.copy(
                    number2 = state.number2 + "."
                )
                return
            }
        }
    }

    private fun enterOperations(operations: CalculationOperations) {
        if (state.number1.isNotBlank()) {
            state = state.copy( operation = operations)
        }
    }

    private fun performCalculation() {
        val number1 = state.number1.toDoubleOrNull()
        val number2 = state.number2.toDoubleOrNull()

        if (number1 != null  && number2 != null ) {
            var result = when(state.operation) {
                is CalculationOperations.Add -> number1 + number2
                is CalculationOperations.Subtract -> number1 - number2
                is CalculationOperations.Multiple -> number1 * number2
                is CalculationOperations.Divide -> number1 / number2

                else -> return
            }

            val ans = if (result % 1 == 0.0 ) {
                result.toInt().toString()
            } else {
                result.toString().toDoubleOrNull()?.toString() ?: ""
            }

            if (result.toString().isNotBlank()) {
                state = state.copy(
                    previous = "${state.number1}" + "${state.operation?.symbol}" + "${state.number2}",
                    number1 = "",
                    number2 = "",
                    operation = null
                )
            }
            state = state.copy(
                number1 = ans.take(12),
                number2 = "",
                operation = null
            )

        }
    }

    private fun performDelection() {
        when {
            state.number2.isNotBlank() -> state = state.copy(
                number2 =  state.number2.dropLast(1)
            )

            state.operation != null -> state = state.copy(
                operation = null
            )


            state.number1.isNotBlank() -> state = state.copy(
                number1 = state.number1.dropLast(1)
            )
        }
    }

    companion object {
        private const val MAX_NUM_LENGTH = 8
    }

}