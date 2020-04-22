package com.example.chaseapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.chaseapp.R
import com.example.chaseapp.databinding.FragmentDetailViewBinding
import com.example.chaseapp.model.ScoreModel

/**
 * A simple [Fragment] subclass.
 */
class DetailViewFragment : Fragment() {

    private var _bind: FragmentDetailViewBinding? = null
    private val bind get() = _bind
    private lateinit var scores: List<ScoreModel>
    private var score = ScoreModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bind = FragmentDetailViewBinding.inflate(inflater, container, false)
        @Suppress("UNCHECKED_CAST")
        scores = arguments?.get("scores") as List<ScoreModel>
        bind?.scoreModel = scores[0]
        return bind?.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }

}
