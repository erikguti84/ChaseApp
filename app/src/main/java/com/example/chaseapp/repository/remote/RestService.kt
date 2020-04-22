package com.example.chaseapp.repository.remote

import com.example.chaseapp.model.SchoolModel
import com.example.chaseapp.model.ScoreModel
import com.example.chaseapp.repository.remote.Constants.URL_PATH_SAT_SCORES
import com.example.chaseapp.repository.remote.Constants.URL_PATH_SCHOOLS
import io.reactivex.Single
import retrofit2.http.GET

interface RestService {

    @GET(URL_PATH_SCHOOLS)
    suspend fun getListOfSchools(): List<SchoolModel>

    @GET(URL_PATH_SAT_SCORES)
    suspend fun getListOfScores(): List<ScoreModel>

}