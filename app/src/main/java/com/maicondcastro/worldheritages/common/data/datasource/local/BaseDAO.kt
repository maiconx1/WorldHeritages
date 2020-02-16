package com.maicondcastro.worldheritages.common.data.datasource.local

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Update

interface BaseDAO<T> {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun save(vararg entities: T)

    @Update
    fun update(vararg entities: T)

    @Delete
    fun delete(vararg entities: T)
}