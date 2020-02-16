package com.maicondcastro.worldheritages.heritage.presentation.ui.adapter

import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.maicondcastro.worldheritages.R
import com.maicondcastro.worldheritages.common.util.inflateInto
import com.maicondcastro.worldheritages.heritage.presentation.entity.HeritageView
import com.maicondcastro.worldheritages.heritage.presentation.viewmodel.HeritageViewModel
import kotlinx.android.synthetic.main.item_list_heritage.view.*


class HeritageHolder(parent: ViewGroup, private val viewModel: HeritageViewModel) :
    RecyclerView.ViewHolder(parent.inflateInto(R.layout.item_list_heritage)) {

    private val imageHeritage: ImageView = itemView.imageHeritage
    private val textName: TextView = itemView.textName
    private val textShortInfo: TextView = itemView.textShortInfo
    private val imageShowMore: ImageView = itemView.imageShowMore
    private var heritage: HeritageView? = null

    fun setupView(heritage: HeritageView) {
        bindView(heritage)
        setListener()
    }

    private fun bindView(heritage: HeritageView) {
        this.heritage = heritage
        textName.text = heritage.name
        textShortInfo.text = heritage.shortInfo
        Glide.with(itemView.context)
            .load(heritage.image)
            .transition(DrawableTransitionOptions.withCrossFade())
            .into(imageHeritage)
    }

    private fun setListener() {
        imageShowMore.setOnClickListener {
            val context = itemView.context
            heritage?.let {
                if (it.showingInfo) {
                    textShortInfo.maxHeight = context.resources.getDimension(R.dimen.shortInfoMaxHeight).toInt()
                    imageShowMore.background = ContextCompat.getDrawable(context, R.drawable.bg_show_more)
                    imageShowMore.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_arrow_down))
                } else {
                    textShortInfo.maxHeight = 99999
                    imageShowMore.background = null
                    imageShowMore.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_arrow_up))
                }
                viewModel.showMore(it.listId)
            }
        }
    }
}