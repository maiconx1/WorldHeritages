package com.maicondcastro.worldheritages.common.util

import com.maicondcastro.worldheritages.heritage.data.datasource.local.entity.HeritageLocal
import com.maicondcastro.worldheritages.heritage.domain.entity.Heritage
import com.maicondcastro.worldheritages.heritage.presentation.entity.HeritageView

fun HeritageLocal.mapToDomain() = Heritage(
    coordinates = coordinates,
    id = id,
    image = image,
    imageAuthor = imageAuthor,
    lat = lat,
    lng = lng,
    longInfo= longInfo,
    name = name,
    page = page,
    region = region,
    regionLong = regionLong,
    shortInfo = shortInfo,
    target = target,
    type = type,
    year = year
)

fun Heritage.mapToLocal() = HeritageLocal(
    coordinates = coordinates,
    id = id,
    image = image,
    imageAuthor = imageAuthor,
    lat = lat,
    lng = lng,
    longInfo= longInfo,
    name = name,
    page = page,
    region = region,
    regionLong = regionLong,
    shortInfo = shortInfo,
    target = target,
    type = type,
    year = year
)

fun HeritageView.mapToDomain() = Heritage(
    coordinates = coordinates ?: "",
    id = id ?: "",
    image = image ?: "",
    imageAuthor = imageAuthor ?: "",
    lat = lat,
    lng = lng,
    longInfo= longInfo ?: "",
    name = name ?: "",
    page = page ?: "",
    region = region ?: "",
    regionLong = regionLong ?: "",
    shortInfo = shortInfo ?: "",
    target = target ?: "",
    type = type ?: "",
    year = year
)

fun Heritage.mapToView() = HeritageView(
    coordinates = coordinates,
    id = id,
    image = image,
    imageAuthor = imageAuthor,
    lat = lat,
    lng = lng,
    longInfo= longInfo,
    name = name,
    page = page,
    region = region,
    regionLong = regionLong,
    shortInfo = shortInfo,
    target = target,
    type = type,
    year = year
)

fun List<Heritage>.mapToLocal() = map { it.mapToLocal() }

fun List<HeritageLocal>.mapToDomain() = map { it.mapToDomain() }