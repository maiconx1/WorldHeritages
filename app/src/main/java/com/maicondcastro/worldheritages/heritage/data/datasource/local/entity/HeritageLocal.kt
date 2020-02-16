package com.maicondcastro.worldheritages.heritage.data.datasource.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "Heritage")
data class HeritageLocal(
    val coordinates: String,
    @PrimaryKey
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