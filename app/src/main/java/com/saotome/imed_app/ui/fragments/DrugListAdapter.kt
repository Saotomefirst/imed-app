package com.saotome.imed_app.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import com.saotome.imed_app.databinding.ItemDrugBinding
import com.saotome.imed_app.model.Drug

class DrugListAdapter : ListAdapter <Drug, DrugListAdapter.DrugViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DrugViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemDrugBinding.inflate(inflater, parent, false)
        return DrugViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DrugViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DrugViewHolder(
        private val binding: ItemDrugBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Drug) {
            binding.tvMedicationName.text = item.name
            binding.tvDosage.text = item.dosage
            binding.tvFrequency.text = item.frequency
            binding.tvStartTime.text = item.startTime
        }
    }
}

class DiffCallback : DiffUtil.ItemCallback<Drug> () {
    override fun areItemsTheSame(oldItem: Drug, newItem: Drug): Boolean = oldItem == newItem

    override fun areContentsTheSame(oldItem: Drug, newItem: Drug): Boolean = oldItem.id == newItem.id

}