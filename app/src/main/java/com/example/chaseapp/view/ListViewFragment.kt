package com.example.chaseapp.view

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager

import com.example.chaseapp.R
import com.example.chaseapp.adapter.SchoolAdapter
import com.example.chaseapp.databinding.FragmentListViewBinding
import com.example.chaseapp.model.SchoolModel
import com.example.chaseapp.model.ScoreModel
import com.example.chaseapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.android.synthetic.main.fragment_list_view.*

/**
 * A simple [Fragment] subclass.
 */
class ListViewFragment : Fragment() {

    private var _bind: FragmentListViewBinding? = null
    private val bind get() = _bind
    private var schools: List<SchoolModel> = ArrayList()
    private var scores: List<ScoreModel> = ArrayList()
    private lateinit var schoolAdapter: SchoolAdapter
    private lateinit var viewModel: MainViewModel
    private var dbn: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        lazyLoadData()
        _bind = FragmentListViewBinding.inflate(inflater, container, false)
        @Suppress("UNCHECKED_CAST")
        schools = arguments?.get("schoolList") as List<SchoolModel>
        schoolAdapter = SchoolAdapter {position ->
            dbn = schools[position].dbn
            launchNavigation()
        }

        return bind?.root
    }

    override fun onResume() {
        super.onResume()
        rv_main.apply{
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            schoolAdapter.loadData(schools)
            schoolAdapter.notifyDataSetChanged()
            adapter = schoolAdapter
        }
    }

    private fun lazyLoadData(){
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.scoreObservable().observe(viewLifecycleOwner, Observer {scoreList ->
            scores = scoreList
        })
        viewModel.fetchScores()
    }

    private fun launchNavigation(){
        val scoreModel = getScoreModel()
        val scores = mutableListOf<ScoreModel>()
        scores.add(scoreModel)
        val bundle = bundleOf("scores" to scores)
        this.findNavController().navigate(R.id.next_detailviewfragment, bundle)
    }

    private fun getScoreModel(): ScoreModel{
        var model = ScoreModel()
        scores.forEach { school ->
            if(dbn == school.dbn)
                model = school
        }
        return model
    }

    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }

}
