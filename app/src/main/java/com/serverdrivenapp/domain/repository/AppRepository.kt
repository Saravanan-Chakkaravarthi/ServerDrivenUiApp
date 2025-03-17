package com.serverdrivenapp.domain.repository

import com.serverdrivenapp.data.models.all_matches.MatchesLayoutResponse
import com.serverdrivenapp.data.models.all_matches.ProfileResponse

interface AppRepository {
    suspend fun fetchLayoutResponse(): MatchesLayoutResponse
    suspend fun fetchProfileResponse(): ProfileResponse
}