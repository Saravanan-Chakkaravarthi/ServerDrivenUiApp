package com.serverdrivenapp.presentation.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.serverdrivenapp.R
import com.serverdrivenapp.data.models.all_matches.MatchesComponents

@Composable
fun RenderIconComponent(component: MatchesComponents) {
    val context = LocalContext.current
    AsyncImage(
        model = ImageRequest.Builder(context)
            .data(component.properties?.url)
            .crossfade(true)
            .placeholder(R.drawable.ic_gallery)
            .error(R.drawable.ic_gallery_error)
            .build(),
        contentDescription = component.properties?.contentDescription,
        contentScale = ContentScaleType.fromString(component.properties?.contentScale).scale,
        modifier = Modifier
            .size(
                width = (component.properties?.width?.toInt() ?: 0).dp,
                height = (component.properties?.height?.toInt() ?: 0).dp
            )
            .padding((component.properties?.padding ?: 0).dp)
    )
}