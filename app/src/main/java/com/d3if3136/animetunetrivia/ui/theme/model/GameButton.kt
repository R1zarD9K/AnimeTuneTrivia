package com.d3if3136.animetunetrivia.ui.theme.model

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

private fun String.capitalizeWords(): String = split(" ").joinToString(" ") { it.capitalize() }

@Composable
fun GameButton(buttonText : String, padding : Dp, onButtonClick : () -> Unit ){
    Button(onClick = {
        onButtonClick()
    },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = padding)
            .size(50.dp),
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray),
        border = BorderStroke(2.dp, Color.White)
    ) {
        val formattedText = buttonText.replace("_", " ").capitalizeWords()
        Text(text = formattedText, color = Color.White, fontSize = 18.sp)
    }
}