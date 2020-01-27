package com.jeezer.messagescheduler.dal.dto

import androidx.room.Embedded
import androidx.room.Relation
import com.jeezer.messagescheduler.dal.entity.Message
import com.jeezer.messagescheduler.dal.entity.ScheduledMessage

data class ScheduledMessageDto(
    @Embedded val schedule: ScheduledMessage,
    @Relation(parentColumn = "message_id", entityColumn = "id") val message: Message
)