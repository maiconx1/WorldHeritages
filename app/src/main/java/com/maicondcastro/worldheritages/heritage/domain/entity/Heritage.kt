package com.maicondcastro.worldheritages.heritage.domain.entity

data class Heritage(
    val coordinates: String,
    val id: String,
    val image: String,
    val imageAuthor: String,
    val lat: Double,
    val lng: Double,
    val longInfo: String,
    val name: String,
    val page: String,
    val region: String,
    val regionLong: String,
    val shortInfo: String,
    val target: String,
    val type: String,
    val year: Int
)