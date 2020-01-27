package com.jeezer.messagescheduler.dal.repository

import androidx.lifecycle.LiveData
import com.jeezer.messagescheduler.dal.dao.ScheduledMessageDao
import com.jeezer.messagescheduler.dal.dao.ScheduledMessageDtoDao
import com.jeezer.messagescheduler.dal.dto.ScheduledMessageDto
import com.jeezer.messagescheduler.dal.entity.ScheduledMessage
import java.util.concurrent.TimeUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ScheduledMessageRepository @Inject constructor(private val scheduledMessageDao: ScheduledMessageDao, private val scheduledMessageDtoDao: ScheduledMessageDtoDao) {
    fun getScheduledMessage(scheduledMessageId: Long): LiveData<ScheduledMessage> {
        return scheduledMessageDao.load(scheduledMessageId)
    }

    fun getAllScheduledMessages(): LiveData<List<ScheduledMessageDto>> {
        return scheduledMessageDtoDao.loadAll()
    }

    suspend fun insert(scheduledMessage: ScheduledMessage) {
        scheduledMessageDao.insert(scheduledMessage)
    }

    companion object {
        val FRESH_TIMEOUT = TimeUnit.DAYS.toMillis(1)
    }
}
