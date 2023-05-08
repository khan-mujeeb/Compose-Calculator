package com.example.calculator.ui.theme

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.actions.CalculationOperations
import com.example.calculator.actions.CalculatorActions
import com.example.calculator.state.CalculationState

@Composable
fun Calculator(
    state: CalculationState,
    buttonSpacing: Dp = 16.dp,
    modifier: Modifier,
    onAction: (CalculatorActions) -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colors.background)

    ) {
        Column(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .background(MaterialTheme.colors.background),

            verticalArrangement = Arrangement.spacedBy(buttonSpacing)

        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()


                    .padding(vertical = 70.dp, horizontal = 20.dp),
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                color = MaterialTheme.colors.onPrimary,
                maxLines = 2
            )

            /*
        first row
         */
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "C",
                    modifier = Modifier
                        .background(MaterialTheme.colors.primary)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }
                )

                CalculatorButton(
                    symbol = "del",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Delete)
                    }
                )

                CalculatorButton(
                    symbol = "%",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Clear)
                    }
                )

                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(orange)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operations(CalculationOperations.Divide))
                    }
                )
            }

            /*
            second row
             */
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(7))
                    }
                )
                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(8))
                    }
                )
                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(9))
                    }
                )
                CalculatorButton(
                    symbol = "x",
                    modifier = Modifier
                        .background(orange)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operations(CalculationOperations.Multiple))
                    }
                )
            }

            /*
            third row
             */
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(4))
                    }
                )
                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(5))
                    }
                )
                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(6))
                    }
                )
                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(orange)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operations(CalculationOperations.Subtract))
                    }
                )
            }

            /*
            fourth row
             */
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(1))
                    }
                )
                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(2))
                    }
                )
                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(3))
                    }
                )
                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(orange)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Operations(CalculationOperations.Add))
                    }
                )
            }

            /*
            sixth row
             */
            Row(
                modifier = Modifier.fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(bottom = 20.dp),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)

            ) {
                CalculatorButton(
                    symbol = "00",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(4))
                    }
                )

                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Number(0))
                    }
                )

                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(MaterialTheme.colors.surface)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Decimal)
                    }
                )

                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(green)
                        .weight(1f),
                    onClick = {
                        onAction(CalculatorActions.Calculate)
                    }
                )
            }
        }
    }
}




