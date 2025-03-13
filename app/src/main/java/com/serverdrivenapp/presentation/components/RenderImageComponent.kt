package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.serverdrivenapp.R
import com.serverdrivenapp.data.models.all_matches.MatchesComponents
import com.serverdrivenapp.data.models.all_matches.Profiles

@Composable
fun RenderImageComponent(
    component: MatchesComponents,
    profile: Profiles,
) {
    val context = LocalContext.current
    val imageUrl = when(component.properties?.url) {
        "imageUrl" -> profile.imageUrl
        else -> component.properties?.url
    }
    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(imageUrl)
            .crossfade(true)
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_foreground)
            .build(),
        contentDescription = component.properties?.contentDescription,
        contentScale = ContentScaleType.fromString(component.properties?.contentScale).scale,
        modifier = Modifier
            .widthComponent(input = component.properties?.width)
            .heightComponent(input = component.properties?.height)
            .clip(RoundedCornerShape(component.properties?.corner?.dp ?: 0.dp)),
        alignment = Alignment.Center
    )
}

// Fit, Crop, Inside, FillWidth, FillHeight, None
sealed class ContentScaleType(val scale: ContentScale) {
    data object None: ContentScaleType(scale = ContentScale.None)
    data object Fit: ContentScaleType(scale = ContentScale.Fit)
    data object Crop: ContentScaleType(scale = ContentScale.Crop)
    data object Inside: ContentScaleType(scale = ContentScale.Inside)
    data object FillWidth: ContentScaleType(scale = ContentScale.FillWidth)
    data object FillHeight: ContentScaleType(scale = ContentScale.FillHeight)

    companion object {
        fun fromString(value: String?): ContentScaleType {
            return when(value) {
                "None" -> None
                "Fit" -> Fit
                "Crop" -> Crop
                "Inside" -> Inside
                "FillWidth" -> FillWidth
                "FillHeight" -> FillHeight
                else -> Fit
            }
        }
    }
}