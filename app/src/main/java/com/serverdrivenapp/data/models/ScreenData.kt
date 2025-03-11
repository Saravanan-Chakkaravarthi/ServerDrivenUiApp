package com.serverdrivenapp.data.models

import com.google.gson.annotations.SerializedName

data class ScreenData(
    @SerializedName("screen_two") val screenTwo: List<Screen>?,
    @SerializedName("screen_three") val screenThree: List<Screen>?,
    @SerializedName("screen_four") val screenFour: List<Screen>?
)

data class Screen(
    @SerializedName("screen_two_layout") val layoutTwo: List<Component>?,
    @SerializedName("screen_three_layout") val layoutThree: List<Component>?,
    @SerializedName("screen_four_layout") val layoutFour: List<Component>?
)

data class Component (
    val type: String,
    val properties: Map<String, Any>,
    @SerializedName("screen_two_children") val childrenTwo: List<Component>?,
    @SerializedName("screen_three_children") val childrenThree: List<Component>?,
    @SerializedName("screen_four_children") val childrenFour: List<Component>?,
)

