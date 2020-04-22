package com.example.chaseapp.repository.remote

import com.example.chaseapp.model.SchoolModel
import com.example.chaseapp.model.ScoreModel
import io.reactivex.Single

class ApiClient {

    private val apiService: RestService =
        ApiEndPoint.retrofitInstance.create(
            RestService::class.java)

    suspend fun getSchoolList(): List<SchoolModel> =
        apiService.getListOfSchools()

    suspend fun getScoreList(): List<ScoreModel> =
        apiService.getListOfScores()

}