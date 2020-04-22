package com.example.chaseapp.repository

import com.example.chaseapp.repository.remote.ApiClient


class Repository {
    private object RepositoryInstanceHolder{internal val REPO_INSTANCE = Repository()}
    private val apiClient = ApiClient()

    suspend fun getSchools() = apiClient.getSchoolList()

    suspend fun  getScores() = apiClient.getScoreList()

    companion object{val INSTANCE = RepositoryInstanceHolder.REPO_INSTANCE}
}