package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.data.models.all_matches.Profiles
import com.serverdrivenapp.utils.CalenderUtils
import com.serverdrivenapp.utils.hexToColor

@Composable
fun RenderTextComponent(
    component: MatchesComponents,
    profile: Profiles
) {
    val textValue = when(component.properties?.text) {
        "id" -> profile.profileId
        "lastSeen" -> CalenderUtils.formatRelativeTime(profile.lastActiveTime)
        "name" -> profile.name
        "address" -> {
            listOfNotNull(
                profile.ageYear?.let { "$it Yrs" },
                profile.height,
                profile.caste,
                profile.subcaste,
                profile.education,
                profile.occupation,
                profile.address?.city,
                profile.address?.state,
                profile.address?.country
            ).joinToString(" · ") + "."
        }
        else -> component.properties?.text
    }
    Text(
        text = textValue ?: "",
        fontSize = component.properties?.fontSize?.sp ?: 0.sp,
        fontWeight = when (component.properties?.fontWeight) {
            "bold" -> FontWeight.Bold
            "thin" -> FontWeight.Thin
            "normal" -> FontWeight.Normal
            else -> FontWeight.Normal
        },
        color = hexToColor(component.properties?.textColor),
        modifier = Modifier
            .widthComponent(component.properties?.width)
            .heightComponent(component.properties?.height)
            .padding(component.properties?.padding?.dp ?: 0.dp)
    )
}