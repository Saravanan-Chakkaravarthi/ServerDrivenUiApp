package com.serverdrivenapp.data.models.all_matches

import com.google.gson.annotations.SerializedName

data class Matches (
  @SerializedName("data") var data : MatchesData?,
  @SerializedName("layout") var layout : MatchesLayout?
)

data class MatchesLayout(
  val title: String,
  val components: List<MatchesComponents>?,
)

data class MatchesComponents(
  val type: String?,
  val properties: ComponentProperties?,
  val children: List<MatchesComponents>?,
)

data class ComponentProperties(
  val width: String?,
  val height: String?,
  val horizontalAlignment: String?,
  val padding: Int?,
  val verticalArrangement: String?,
  val horizontalArrangement: String?,
  val verticalAlignment: String?,
  val url: String?,
  val contentDescription: String?,
  val text: String?,
  val fontSize: Int?,
  val fontWeight: String?,
  val textColor: String?,
  val action: MatchesAction?,
  val shape: String?,
  val corner: Int?,
  val elevation: Int?,
  val contentScale: String?,
  val backgroundColor: String?,
  val borderStroke: Int?,
  val strokeColor: String?,
)

data class MatchesAction(
  val type: String?,
  val destination: String?,
  val parameters: ActionParameter?,
)

data class ActionParameter(
  val profileId: String?,
)