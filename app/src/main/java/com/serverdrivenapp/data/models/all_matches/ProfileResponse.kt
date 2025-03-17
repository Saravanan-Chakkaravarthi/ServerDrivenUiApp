package com.serverdrivenapp.data.models.all_matches

import com.google.gson.annotations.SerializedName


data class ProfileResponse(
    @SerializedName("data") var data : MatchesData?,
)

data class MatchesData(
    val profiles: List<Profiles>?,
)

data class Profiles(
    @SerializedName(value = "id") val profileId: String?,
    val name: String?,
    @SerializedName(value = "photo") val imageUrl: String?,
    @SerializedName(value = "location") val address: Address?,
    val profileCreatedBy: String?,
    val lastActiveTime: String?,
    val ageYear: Int?,
    val height: String?,
    val education: String?,
    val occupation: String?,
    val income: String?,
    val photoVisibility: String?,
    val photoCount: String?,
    val profileVideoPreview: String?,
    val isNewlyJoined: Boolean?,
    val isShortlistedByYou: Boolean?,
    val isPaid: Boolean?,
    val isPhotoVerified: Boolean?,
    val isIdVerified: Boolean?,
    val phoneVisibility: String?,
    val onlineStatus: String?,
    val caste: String?,
    val subcaste: String?,
)

data class Address(
    val city: String?,
    val state: String?,
    val country: String?,
)
