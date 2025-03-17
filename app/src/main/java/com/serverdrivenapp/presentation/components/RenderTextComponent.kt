package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    profile: Profiles,
) {
    val onlineStatus = if (profile.onlineStatus == "OFFLINE") {
        "Last seen ${CalenderUtils.formatRelativeTime(profile.lastActiveTime)}"
    } else {
        "${profile.onlineStatus}"
    }
    val textValue = when (component.properties?.text) {
        "id" -> "${profile.profileId} | $onlineStatus"
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

        "photoCount" -> profile.photoCount
        else -> component.properties?.text
    }
    Text(
//        text = (component.properties?.text?.let { getPropertyValue(profile, it) } ?: component.properties?.text).toString(),
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

/*fun getPropertyValue(obj: Any?, path: String): Any? {
    var currentObj: Any? = obj
    for (prop in path.split(".")) {
        currentObj = currentObj?.let {
            val property = it::class.members
                .firstOrNull { member -> member.name == prop } as? KProperty1<Any, *>
            property?.get(it)
        } ?: return null
    }
    return currentObj
}*/
