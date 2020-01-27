package com.jeezer.messagescheduler.dal.dao

import androidx.lifecycle.LiveData
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Update

interface BaseDao<T> {
    //region requires override
    fun get(id: Long): T

    fun getAllByIds(ids: LongArray): List<T>

    fun getAll(): List<T>

    fun load(id: Long): LiveData<T>

    fun loadAllByIds(ids: LongArray): LiveData<List<T>>

    fun loadAll(): LiveData<List<T>>

    fun truncate()
    //endregion

    //region full inheritance
    @Insert
    suspend fun insert(item: T) : Long

    @Insert
    suspend fun insertAll(vararg items: T): Array<Long>

    @Insert
    suspend fun insertList(items: List<T>): Array<Long>

    @Update
    fun update(item: T)

    @Update
    fun updateAll(vararg item: T)

    @Update
    fun updateList(items: List<T>)

    @Delete
    fun delete(item: T)
    //endregion
}
