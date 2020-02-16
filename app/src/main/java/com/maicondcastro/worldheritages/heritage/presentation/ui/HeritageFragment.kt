package com.maicondcastro.worldheritages.heritage.presentation.ui

import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.maicondcastro.worldheritages.R
import com.maicondcastro.worldheritages.common.presentation.ui.BaseFragment
import com.maicondcastro.worldheritages.common.util.observe
import com.maicondcastro.worldheritages.heritage.presentation.HeritageInteractor
import com.maicondcastro.worldheritages.heritage.presentation.entity.HeritageView
import com.maicondcastro.worldheritages.heritage.presentation.ui.adapter.HeritageAdapter
import com.maicondcastro.worldheritages.heritage.presentation.viewmodel.HeritageViewModel
import kotlinx.android.synthetic.main.fragment_heritage.*

class HeritageFragment : BaseFragment(), HeritageInteractor.View {

    private val viewModel: HeritageViewModel by viewModel()
    override val layoutResId: Int = R.layout.fragment_heritage

    private var adapter: HeritageAdapter? = null

    override fun setupView() {
        fetchHeritage()
    }

    override fun onResume() {
        super.onResume()
        setToolbarTitle(getString(R.string.app_name))
    }

    override fun fetchHeritage() {
        showProgressLoading()
        firstPage()
    }

    override fun showProgressLoading() {

    }

    override fun hideProgressLoading() {

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        startObservers()
        setListeners()

        if (adapter?.itemCount == 0) {
            setupView()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setRecyclerView()
    }

    override fun setListeners() {
        imageFirst.setOnClickListener { firstPage() }
        imageNext.setOnClickListener { nextPage() }
        imagePrevious.setOnClickListener { previousPage() }
        imageLast.setOnClickListener { lastPage() }
    }

    override fun startObservers() {
        observe(viewModel.liveHeritage) { heritageList ->
            hideProgressLoading()
            changeList(heritageList)
        }
    }

    override fun setRecyclerView() {
        if (adapter == null) {
            adapter = HeritageAdapter(viewModel).apply {
                setHasStableIds(true)
            }
        }
        recyclerHeritage.adapter = adapter
    }

    override fun changeList(list: List<HeritageView>) {
        adapter?.apply {
            clear()
            addItems(list)
        }
    }

    private fun firstPage() {
        imageFirst.visibility = GONE
        imagePrevious.visibility = GONE
        imageLast.visibility = VISIBLE
        imageNext.visibility = VISIBLE

        viewModel.firstPage()
        setPage()
    }

    private fun previousPage() {
        viewModel.previousPage()
        if (viewModel.page == 0) {
            imageFirst.visibility = GONE
            imagePrevious.visibility = GONE
        } else {
            imageFirst.visibility = VISIBLE
            imagePrevious.visibility = VISIBLE
        }
        imageNext.visibility = VISIBLE
        imageLast.visibility = VISIBLE
        setPage()
    }

    private fun nextPage() {
        viewModel.nextPage()
        if (viewModel.page == viewModel.qtdPages) {
            imageLast.visibility = GONE
            imageNext.visibility = GONE
        } else {
            imageNext.visibility = VISIBLE
            imageLast.visibility = VISIBLE
        }
        imageFirst.visibility = VISIBLE
        imagePrevious.visibility = VISIBLE
        setPage()
    }

    private fun lastPage() {
        imageFirst.visibility = VISIBLE
        imagePrevious.visibility = VISIBLE
        imageLast.visibility = GONE
        imageNext.visibility = GONE

        viewModel.lastPage()
        setPage()
    }

    private fun setPage() {
        textPage.text = (viewModel.page+1).toString()
    }
}