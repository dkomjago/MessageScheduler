package com.jeezer.messagescheduler.ui.schedule

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jeezer.messagescheduler.dal.dto.ScheduledMessageDto
import com.jeezer.messagescheduler.dal.entity.ScheduledMessage
import com.jeezer.messagescheduler.dal.repository.ScheduledMessageRepository
import kotlinx.coroutines.launch
import javax.inject.Inject


class ScheduleViewModel @Inject constructor(private val repository: ScheduledMessageRepository): ViewModel() {

    private val scheduledMessages: LiveData<List<ScheduledMessageDto>> = repository.getAllScheduledMessages()

    fun insert(scheduledMessage: ScheduledMessage) {
        viewModelScope.launch{repository.insert(scheduledMessage)}
    }

    fun deleteAllScheduledMessages() {
        repository.getAllScheduledMessages()
    }

    fun getAllScheduledMessages(): LiveData<List<ScheduledMessageDto>> {
        return scheduledMessages
    }
}