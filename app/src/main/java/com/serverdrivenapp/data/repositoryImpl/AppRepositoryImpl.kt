package com.serverdrivenapp.data.repositoryImpl

import com.serverdrivenapp.data.ApiServices
import com.serverdrivenapp.data.models.all_matches.MatchesLayoutResponse
import com.serverdrivenapp.data.models.all_matches.ProfileResponse
import com.serverdrivenapp.domain.repository.AppRepository
import javax.inject.Inject

class AppRepositoryImpl @Inject constructor(
    private val apiServices: ApiServices
): AppRepository {
    override suspend fun fetchLayoutResponse(): MatchesLayoutResponse {
        return apiServices.getMatchesLayout()
    }

    override suspend fun fetchProfileResponse(): ProfileResponse {
        return apiServices.getMatchesProfiles()
    }
}