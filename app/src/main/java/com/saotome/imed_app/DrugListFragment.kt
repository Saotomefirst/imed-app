package com.saotome.imed_app

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.saotome.imed_app.databinding.FragmentDrugListBinding
import com.saotome.imed_app.model.Drug
import com.saotome.imed_app.ui.DrugListAdapter

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class DrugListFragment : Fragment() {

    private var _binding: FragmentDrugListBinding? = null
    private val drugList = arrayListOf<Drug>()
    // This property is only valid between onCreateView and

    private val adapter by lazy { DrugListAdapter() }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        loadDrugMockList()
        //do not forget to SEND THE LIST to the adapter!
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

//        binding.buttonFirst.setOnClickListener {
//            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
//        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}