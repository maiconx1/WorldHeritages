package com.maicondcastro.worldheritages.heritage.presentation.entity

import com.google.gson.annotations.SerializedName

data class HeritageView(
    @SerializedName("coordinates")
    val coordinates: String?,
    @SerializedName("id")
    val id: String?,
    @SerializedName("image")
    val image: String?,
    @SerializedName("imageAuthor")
    val imageAuthor: String?,
    @SerializedName("lat")
    val lat: Double,
    @SerializedName("lng")
    val lng: Double,
    @SerializedName("longInfo")
    val longInfo: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("page")
    val page: String?,
    @SerializedName("region")
    val region: String?,
    @SerializedName("regionLong")
    val regionLong: String?,
    @SerializedName("shortInfo")
    val shortInfo: String?,
    @SerializedName("target")
    val target: String?,
    @SerializedName("type")
    val type: String?,
    @SerializedName("year")
    val year: Int,
    var listId: Long = 0,
    var showingInfo: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        val heritage = other as HeritageView
        return id == heritage.id
    }

    override fun hashCode(): Int {
        var result = coordinates?.hashCode() ?: 0
        result = 31 * result + (id?.hashCode() ?: 0)
        result = 31 * result + (image?.hashCode() ?: 0)
        result = 31 * result + (imageAuthor?.hashCode() ?: 0)
        result = 31 * result + lat.hashCode()
        result = 31 * result + lng.hashCode()
        result = 31 * result + (longInfo?.hashCode() ?: 0)
        result = 31 * result + (name?.hashCode() ?: 0)
        result = 31 * result + (page?.hashCode() ?: 0)
        result = 31 * result + (region?.hashCode() ?: 0)
        result = 31 * result + (regionLong?.hashCode() ?: 0)
        result = 31 * result + (shortInfo?.hashCode() ?: 0)
        result = 31 * result + (target?.hashCode() ?: 0)
        result = 31 * result + (type?.hashCode() ?: 0)
        result = 31 * result + year
        result = 31 * result + listId.hashCode()
        result = 31 * result + showingInfo.hashCode()
        return result
    }
}