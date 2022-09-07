package com.saotome.imed_app.ui.fragments

import androidx.lifecycle.ViewModel
import com.saotome.imed_app.model.Drug

class DrugListViewModel : ViewModel() {

    private val drugList = arrayListOf<Drug>()

    private fun loadDrugMockList() {
        if (drugList.isEmpty()) {
            drugList.add(0, Drug(1, "Unak", "1 capsula", "20:00", "24:00"))
            drugList.add(0, Drug(2, "Glifage", "1 capsula", "20:00", "24:00"))
            drugList.add(0, Drug(3, "Indapen", "1 capsula", "10:00", "48:00"))
        }
    }

    fun getDrugList(): ArrayList<Drug> {
        loadDrugMockList()
        return drugList
    }
}