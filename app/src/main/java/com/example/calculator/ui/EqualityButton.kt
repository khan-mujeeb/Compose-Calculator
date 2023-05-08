package com.example.calculator.ui

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculator.ui.theme.green

@Composable
fun CalculatorButton(
    symbol: String,
    onClick: () -> Unit
) {
    var textVisible by remember { mutableStateOf(true) }
    val scale by animateFloatAsState(if (textVisible) 1f else 0.5f)

    Box(
        modifier = Modifier
            .background(MaterialTheme.colors.surface)
            .clickable { onClick() }
            .scale(scale)
    ) {
        Text(
            text = symbol,
            fontWeight = FontWeight.Bold,
            fontSize = 32.sp,
            color = green,
            modifier = Modifier
                .padding(26.dp)
        )
    }
}
