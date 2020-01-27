package com.jeezer.messagescheduler.ui.message

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jeezer.messagescheduler.dal.entity.Message
import com.jeezer.messagescheduler.dal.repository.MessageRepository
import javax.inject.Inject

class MessageViewModel @Inject constructor(private val repository: MessageRepository): ViewModel(){
    private val messages: LiveData<List<Message>> = repository.getAllMessages()

    private fun insert(message: Message) {
        repository.insert(message)
    }

    fun getAllMessages(): LiveData<List<Message>> {
        return messages
    }
}