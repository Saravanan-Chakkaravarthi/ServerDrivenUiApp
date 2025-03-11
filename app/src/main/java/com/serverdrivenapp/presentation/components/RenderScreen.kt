package com.serverdrivenapp.presentation.components

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.serverdrivenapp.data.models.all_matches.Matches
import com.serverdrivenapp.data.models.all_matches.MatchesComponents

@Composable
fun RenderSDUIScreen(screen: Matches, navController: NavController) {
    screen.layout?.components?.forEach { component ->
        RenderComponent(component = component, navController = navController)
    }
}

@Composable
fun RenderComponent(component: MatchesComponents, navController: NavController) {

    when(component.type) {
        "LazyColumn" -> RenderLazyColumnComponent(components = component, navController = navController)
        "Column" -> RenderColumnComponent(component = component, navController = navController)
        "Card" -> RenderCardComponent(component = component, navController = navController)
        "Image" -> RenderImageComponent(component = component)
        "Text" -> RenderTextComponent(component = component)
        "Button" -> RenderButtonComponent(component = component, navController = navController)
        "Row" -> RenderRowComponent(component = component, navController = navController)
        "Icon" -> RenderIconComponent(component = component)
    }
}
