package com.maicondcastro.worldheritages.heritage.presentation.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.maicondcastro.worldheritages.heritage.presentation.entity.HeritageView
import com.maicondcastro.worldheritages.heritage.presentation.viewmodel.HeritageViewModel

class HeritageAdapter(private val viewModel: HeritageViewModel) :
    RecyclerView.Adapter<HeritageHolder>() {

    private var heritageList: MutableList<HeritageView> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HeritageHolder {
        return HeritageHolder(parent, viewModel)
    }

    override fun getItemId(position: Int): Long {
        return heritageList[position].listId
    }

    override fun getItemCount(): Int = heritageList.size

    override fun onBindViewHolder(heritageHolder: HeritageHolder, itemPosition: Int) {
        heritageHolder.setupView(heritageList[itemPosition])
        heritageHolder.itemView.setOnClickListener {
            viewModel.openHeritage(heritageList[itemPosition])
        }
    }

    fun clear() {
        heritageList.clear()
        notifyDataSetChanged()
    }

    fun addItems(list: List<HeritageView>) {
        heritageList.addAll(list)
        notifyDataSetChanged()
    }
}