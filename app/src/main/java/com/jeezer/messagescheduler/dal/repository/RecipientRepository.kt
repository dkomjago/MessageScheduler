package com.jeezer.messagescheduler.dal.repository

import androidx.lifecycle.LiveData
import com.jeezer.messagescheduler.dal.dao.RecipientDao
import com.jeezer.messagescheduler.dal.entity.Recipient
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class RecipientRepository @Inject constructor(
    private val recipientDao: RecipientDao
) {
    fun getRecipient(recipientId: Long): LiveData<Recipient> {
        return recipientDao.load(recipientId)
    }

    companion object {
        val FRESH_TIMEOUT = TimeUnit.DAYS.toMillis(1)
    }
}
