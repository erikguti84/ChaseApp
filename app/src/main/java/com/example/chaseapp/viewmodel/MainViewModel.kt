package com.example.chaseapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.chaseapp.model.SchoolModel
import com.example.chaseapp.model.ScoreModel
import com.example.chaseapp.repository.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {
    private val schools = MutableLiveData<List<SchoolModel>>()
    private val scores = MutableLiveData<List<ScoreModel>>()
    private val repo = Repository.INSTANCE

    fun schoolObservable(): LiveData<List<SchoolModel>> = schools

    fun scoreObservable(): LiveData<List<ScoreModel>> = scores

    fun fetchSchools(){
        viewModelScope.launch{
            schools.value = repo.getSchools()
        }
    }

    fun fetchScores(){
        viewModelScope.launch{
            scores.value = repo.getScores()
        }
    }


}