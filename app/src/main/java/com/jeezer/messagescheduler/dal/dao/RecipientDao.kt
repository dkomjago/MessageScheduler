package com.jeezer.messagescheduler.dal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.jeezer.messagescheduler.dal.entity.Recipient

@Dao
interface RecipientDao: BaseDao<Recipient> {
    @Query("SELECT * FROM recipients WHERE id = :id")
    override fun get(id: Long): Recipient

    @Query("SELECT * FROM recipients WHERE id IN (:ids)")
    override fun getAllByIds(ids: LongArray): List<Recipient>

    @Query("SELECT * FROM recipients")
    override fun getAll(): List<Recipient>

    @Query("SELECT * FROM recipients WHERE id = :id")
    override fun load(id: Long): LiveData<Recipient>

    @Query("SELECT * FROM recipients WHERE id IN (:ids)")
    override fun loadAllByIds(ids: LongArray): LiveData<List<Recipient>>

    @Query("SELECT * FROM recipients")
    override fun loadAll(): LiveData<List<Recipient>>

    @Query("DELETE FROM recipients")
    override fun truncate()
}
