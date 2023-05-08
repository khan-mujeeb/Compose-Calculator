package com.example.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.calculator.ui.theme.Calculator
import com.example.calculator.ui.theme.CalculatorTheme
import com.example.calculator.viewmodel.CalculationViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            CalculatorTheme {
                val viewModel = viewModel<CalculationViewModel>()
                val state = viewModel.state
                Calculator(
                    state = state,
                    onAction = viewModel::onAction,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.White)

                )
            }
        }
    }


    @Preview
    @Composable
    fun Preview() {
        val viewModel = viewModel<CalculationViewModel>()
        val state = viewModel.state
        Calculator(
            state = state,
            onAction = viewModel::onAction,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(16.dp)

        )
    }
}
