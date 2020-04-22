package com.example.chaseapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController

import com.example.chaseapp.R
import com.example.chaseapp.databinding.FragmentBaseBinding
import com.example.chaseapp.model.SchoolModel
import com.example.chaseapp.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.fragment_base.*

/**
 * A simple [Fragment] subclass.
 */
class BaseFragment : Fragment() {
    private var schools: List<SchoolModel> = ArrayList()
    private var _bind: FragmentBaseBinding? = null
    private val bind get() = _bind
    private lateinit var viewModel: MainViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _bind = FragmentBaseBinding.inflate(inflater, container, false)
        lazyLoadData()
        return bind?.root
    }

    override fun onResume() {
        super.onResume()
        setupListener()
    }
    private fun setupListener() = btn_next.setOnClickListener {launchNavigation()}

    private fun lazyLoadData(){
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.schoolObservable().observe(viewLifecycleOwner, Observer {schoolList ->
            schools = schoolList
        })
        viewModel.fetchSchools()
    }

    private fun launchNavigation(){
        val bundle = bundleOf("schoolList" to schools)
        this.findNavController().navigate(R.id.next_listviewfragment, bundle)
    }

    override fun onDestroy() {
        super.onDestroy()
        _bind = null
    }
}
