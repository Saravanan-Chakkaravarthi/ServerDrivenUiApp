package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.utils.hexToColor

@Composable
fun RenderTextComponent(component: MatchesComponents) {
    Text(
        text = component.properties?.text ?: "",
        fontSize = component.properties?.fontSize?.sp ?: 0.sp,
        fontWeight = when (component.properties?.fontWeight) {
            "bold" -> FontWeight.Bold
            "thin" -> FontWeight.Thin
            "normal" -> FontWeight.Normal
            else -> FontWeight.Normal
        },
        color = hexToColor(component.properties?.textColor),
        modifier = Modifier
            .padding(component.properties?.padding?.dp ?: 0.dp)
    )
}