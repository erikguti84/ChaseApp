package com.example.chaseapp.model
import com.google.gson.annotations.SerializedName

data class ScoreModel(

	@field:SerializedName("dbn")
	val dbn: String? = null,

	@field:SerializedName("sat_writing_avg_score")
	val satWritingAvgScore: String? = null,

	@field:SerializedName("sat_critical_reading_avg_score")
	val satCriticalReadingAvgScore: String? = null,

	@field:SerializedName("sat_math_avg_score")
	val satMathAvgScore: String? = null,

	@field:SerializedName("school_name")
	val schoolName: String? = null,

	@field:SerializedName("num_of_sat_test_takers")
	val numOfSatTestTakers: String? = null
)
