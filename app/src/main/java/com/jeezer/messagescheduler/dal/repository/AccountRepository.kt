package com.jeezer.messagescheduler.dal.repository

import androidx.lifecycle.LiveData
import com.jeezer.messagescheduler.dal.dao.AccountDao
import com.jeezer.messagescheduler.dal.entity.Account
import com.jeezer.messagescheduler.dal.entity.Message
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AccountRepository @Inject constructor(
    private val accountDao: AccountDao
) {
    fun getAccount(accountId: Long): LiveData<Account> {
        return accountDao.load(accountId)
    }

    fun getAllAccounts(): LiveData<List<Account>> {
        return accountDao.loadAll()
    }

    fun insert(account: Account) {
    }

    companion object {
        val FRESH_TIMEOUT = TimeUnit.DAYS.toMillis(1)
    }
}
