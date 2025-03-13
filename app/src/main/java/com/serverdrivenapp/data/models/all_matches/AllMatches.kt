package com.serverdrivenapp.data.models.all_matches

import com.google.gson.annotations.SerializedName

data class Matches (
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
  val cardColor: String?,
  val maxLines: Int?,
  val softwrap: Boolean?,
  val overflow: String?,
  val textAlign: String?,
  val contentAlignment: String?,
  val alignment: String?,
  val outerPadding: Int?,
  val innerPadding: PaddingData?,

)

data class PaddingData(
  val vertical: Int?,
  val horizontal: Int?,
  val start: Int?,
  val top: Int?,
  val bottom: Int?,
  val end: Int?,
)

data class MatchesAction(
  val type: String?,
  val destination: String?,
  val parameters: ActionParameter?,
)

data class ActionParameter(
  val profileId: String?,
)