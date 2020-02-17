package com.maicondcastro.worldheritages.heritage.presentation.ui

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.maicondcastro.worldheritages.R
import com.maicondcastro.worldheritages.common.presentation.ui.BaseFragment
import com.maicondcastro.worldheritages.heritage.presentation.HeritageDetailInteractor
import com.maicondcastro.worldheritages.heritage.presentation.entity.HeritageView
import kotlinx.android.synthetic.main.fragment_heritage_detail.*
import java.lang.Exception

class HeritageDetailFragment : BaseFragment(), HeritageDetailInteractor.View, OnMapReadyCallback {

    override val layoutResId: Int = R.layout.fragment_heritage_detail
    override val customNavigationIcon: Int = R.drawable.ic_arrow_back

    private val args: HeritageDetailFragmentArgs by navArgs()
    private lateinit var heritageView: HeritageView

    private var showingImage = false

    override fun setupView() {
        heritageView = args.heritage
        setToolbarTitle(heritageView.name ?: "")
        context?.let { context ->
            Glide.with(context)
                .load(heritageView.image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .addListener(object : RequestListener<Drawable> {
                    override fun onLoadFailed(
                        e: GlideException?,
                        model: Any?,
                        target: Target<Drawable>?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                    override fun onResourceReady(
                        resource: Drawable?,
                        model: Any?,
                        target: Target<Drawable>?,
                        dataSource: DataSource?,
                        isFirstResource: Boolean
                    ): Boolean {
                        return false
                    }

                })
                .into(imageHeritage)
            Glide.with(context)
                .load(heritageView.image)
                .transition(DrawableTransitionOptions.withCrossFade())
                .into(imageFullHeritage)
        }
        textYear.text = heritageView.year.toString()
        textRegion.text = heritageView.regionLong
        textInfo.text = heritageView.longInfo
        if (textInfo.text.isEmpty()) {
            textInfo.text = heritageView.shortInfo
        }
        textImageAuthor.text = heritageView.imageAuthor
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
        setListeners()

        mapView.onCreate(savedInstanceState)
        mapView.onResume()

        try {
            MapsInitializer.initialize(context)
        } catch (ex: Exception) {
            ex.printStackTrace()
        }

        mapView.getMapAsync(this)
    }

    override fun onBackPressed() {
        if (showingImage) {
            closeImage()
        } else {
            super.onBackPressed()
        }

    }

    private fun closeImage() {
        frameFullImage.visibility = GONE
        showingImage = false
    }

    override fun setListeners() {
        imageHeritage.setOnClickListener {
            frameFullImage.visibility = VISIBLE
            showingImage = true
        }
    }

    override fun onMapReady(googleMap: GoogleMap?) {
        val latLng = LatLng(heritageView.lat, heritageView.lng)
        googleMap?.apply {
            addMarker(
                MarkerOptions().position(latLng)
                    .title(heritageView.name)
            )
            googleMap.moveCamera(CameraUpdateFactory.newLatLng(latLng))
        }

    }
}