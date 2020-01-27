package com.jeezer.messagescheduler.dal.repository

import androidx.lifecycle.LiveData
import com.jeezer.messagescheduler.dal.dao.MessageDao
import com.jeezer.messagescheduler.dal.entity.Message
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MessageRepository @Inject constructor(
    private val messageDao: MessageDao
) {

    fun getMessage(messageId: Long): LiveData<Message> {
        return messageDao.load(messageId)
    }

    fun getAllMessages(): LiveData<List<Message>> {
        return messageDao.loadAll()
    }

    fun insert(message: Message) {
    }
}
