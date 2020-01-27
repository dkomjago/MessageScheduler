package com.jeezer.messagescheduler.dal.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.jeezer.messagescheduler.dal.entity.ScheduledMessage

@Dao
interface ScheduledMessageDao: BaseDao<ScheduledMessage>{
    @Query("SELECT * FROM scheduledMessages WHERE id = :id")
    override fun get(id: Long): ScheduledMessage

    @Query("SELECT * FROM scheduledMessages WHERE id IN (:ids)")
    override fun getAllByIds(ids: LongArray): List<ScheduledMessage>

    @Query("SELECT * FROM scheduledMessages")
    override fun getAll(): List<ScheduledMessage>

    @Query("SELECT * FROM scheduledMessages WHERE id = :id")
    override fun load(id: Long): LiveData<ScheduledMessage>

    @Query("SELECT * FROM scheduledMessages WHERE id IN (:ids)")
    override fun loadAllByIds(ids: LongArray): LiveData<List<ScheduledMessage>>

    @Query("SELECT * FROM scheduledMessages")
    override fun loadAll(): LiveData<List<ScheduledMessage>>

    @Query("DELETE FROM scheduledMessages")
    override fun truncate()
}
