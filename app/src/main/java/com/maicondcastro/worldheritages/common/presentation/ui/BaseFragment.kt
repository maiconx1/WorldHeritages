package com.maicondcastro.worldheritages.common.presentation.ui

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.appcompat.content.res.AppCompatResources
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.maicondcastro.worldheritages.R
import com.maicondcastro.worldheritages.main.presentation.ui.MainActivity
import kotlinx.android.synthetic.main.activity_main.*


abstract class BaseFragment : Fragment() {

    private val navController: NavController by lazy { findNavController() }

    @DrawableRes
    protected open val customNavigationIcon: Int = 0

    protected abstract val layoutResId: Int

    private var customToolbar: Toolbar? = null

    private val baseActivity: BaseActivity?
        get() = activity as? BaseActivity

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val layout = inflater.inflate(layoutResId, container, false)
        customToolbar = layout.findViewById(R.id.toolbar)
        hideDefaultToolbar()
        setupCustomToolbar()
        return layout
    }

    private fun setupCustomToolbar() {
        customToolbar?.apply {
            navigationIcon = if (customNavigationIcon == 0) {
                null
            } else {
                AppCompatResources.getDrawable(context, customNavigationIcon)
            }
            setNavigationOnClickListener { onBackPressed() }
        }
    }

    protected fun navigateTo(action: NavDirections) {
        try {
            navController.navigate(action)
        } catch (e: IllegalArgumentException) {
            e.printStackTrace()
        }
    }

    private fun hideDefaultToolbar() {
        if (customToolbar != null) {
            val actionBar = baseActivity?.supportActionBar
            actionBar?.hide()
        }
    }

    open fun onBackPressed() {
        (activity as? MainActivity)?.back()
    }

    fun setToolbarTitle(title: String) {
        customToolbar?.title = title
        baseActivity?.toolbar?.title = title
    }
}