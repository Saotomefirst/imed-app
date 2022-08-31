package com.saotome.imed_app.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.saotome.imed_app.R
import com.saotome.imed_app.databinding.FragmentDrugListBinding
import com.saotome.imed_app.model.Drug
import com.saotome.imed_app.ui.DrugListAdapter


class DrugListFragment : Fragment() {

    private var _binding: FragmentDrugListBinding? = null
    private val drugList = arrayListOf<Drug>()

    private val adapter by lazy { DrugListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loadDrugMockList()
        //set loaded Drug List to adapter
        adapter.submitList(drugList)

        _binding = FragmentDrugListBinding.inflate(inflater, container, false)
        _binding?.rvDrugs?.adapter = adapter

        return _binding?.root
    }

    private fun loadDrugMockList() {
        drugList.add(0, Drug(0, "Unak", "1 capsula", "20:00", "24:00"))
        drugList.add(0, Drug(0, "Glifage", "1 capsula", "20:00", "24:00"))
        drugList.add(0, Drug(0, "Indapen", "1 capsula", "10:00", "48:00"))
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