package com.saotome.imed_app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.saotome.imed_app.R
import com.saotome.imed_app.databinding.FragmentDrugListBinding
import com.saotome.imed_app.model.Drug
import com.saotome.imed_app.ui.DrugListAdapter


class DrugListFragment : Fragment() {

    private var _binding: FragmentDrugListBinding? = null
    lateinit var drugListViewModel: DrugListViewModel

    private val adapter by lazy { DrugListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        drugListViewModel = ViewModelProvider(this).get(DrugListViewModel::class.java)
        _binding = FragmentDrugListBinding.inflate(inflater, container, false)
        _binding?.rvDrugs?.adapter = adapter

        initData()

        return _binding?.root
    }

    private fun initData() {
        adapter.submitList(drugListViewModel.getDrugList())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding?.fabNewDrug?.setOnClickListener {
            findNavController().navigate(R.id.action_DrugList_to_EditDrug)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}