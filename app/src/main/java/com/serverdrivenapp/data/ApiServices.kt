package com.serverdrivenapp.data

import com.serverdrivenapp.data.models.all_matches.MatchesLayoutResponse
import com.serverdrivenapp.data.models.all_matches.ProfileResponse
import retrofit2.http.GET

interface ApiServices {
    @GET(value = "/sdui/all_matches_response.json")
    suspend fun getMatchesLayout(): MatchesLayoutResponse

    @GET(value = "/sdui/profiles.json")
    suspend fun getMatchesProfiles(): ProfileResponse
}