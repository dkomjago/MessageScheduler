package com.jeezer.messagescheduler.dal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.jeezer.messagescheduler.dal.entity.Message

@Dao
interface MessageDao: BaseDao<Message>{
    @Query("SELECT * FROM messages WHERE id = :id")
    override fun get(id: Long): Message

    @Query("SELECT * FROM messages WHERE id IN (:ids)")
    override fun getAllByIds(ids: LongArray): List<Message>

    @Query("SELECT * FROM messages")
    override fun getAll(): List<Message>

    @Query("SELECT * FROM messages WHERE id = :id")
    override fun load(id: Long): LiveData<Message>

    @Query("SELECT * FROM messages WHERE id IN (:ids)")
    override fun loadAllByIds(ids: LongArray): LiveData<List<Message>>

    @Query("SELECT * FROM messages")
    override fun loadAll(): LiveData<List<Message>>

    @Query("DELETE FROM messages")
    override fun truncate()
}
