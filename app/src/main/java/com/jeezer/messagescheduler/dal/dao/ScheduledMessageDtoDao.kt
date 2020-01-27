package com.jeezer.messagescheduler.dal.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.jeezer.messagescheduler.dal.dto.ScheduledMessageDto

@Dao
interface ScheduledMessageDtoDao{

    @Transaction
    @Query("SELECT * FROM scheduledMessages WHERE id = :id")
    fun get(id: Long): ScheduledMessageDto

    @Transaction
    @Query("SELECT * FROM scheduledMessages WHERE id IN (:ids)")
    fun getAllByIds(ids: LongArray): List<ScheduledMessageDto>

    @Transaction
    @Query("SELECT * FROM scheduledMessages")
    fun getAll(): List<ScheduledMessageDto>

    @Transaction
    @Query("SELECT * FROM scheduledMessages WHERE id = :id")
    fun load(id: Long): LiveData<ScheduledMessageDto>

    @Transaction
    @Query("SELECT * FROM scheduledMessages WHERE id IN (:ids)")
    fun loadAllByIds(ids: LongArray): LiveData<List<ScheduledMessageDto>>

    @Transaction
    @Query("SELECT * FROM scheduledMessages")
    fun loadAll(): LiveData<List<ScheduledMessageDto>>
}
