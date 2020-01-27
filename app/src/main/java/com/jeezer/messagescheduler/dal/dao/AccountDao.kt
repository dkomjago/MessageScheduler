package com.jeezer.messagescheduler.dal.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.jeezer.messagescheduler.dal.entity.Account

@Dao
interface AccountDao: BaseDao<Account>{
    @Query("SELECT * FROM accounts WHERE id = :id")
    override fun get(id: Long): Account

    @Query("SELECT * FROM accounts WHERE id IN (:ids)")
    override fun getAllByIds(ids: LongArray): List<Account>

    @Query("SELECT * FROM accounts")
    override fun getAll(): List<Account>

    @Query("SELECT * FROM accounts WHERE id = :id")
    override fun load(id: Long): LiveData<Account>

    @Query("SELECT * FROM accounts WHERE id IN (:ids)")
    override fun loadAllByIds(ids: LongArray): LiveData<List<Account>>

    @Query("SELECT * FROM accounts")
    override fun loadAll(): LiveData<List<Account>>

    @Query("DELETE FROM accounts")
    override fun truncate()
}
