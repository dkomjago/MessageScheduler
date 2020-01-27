package com.jeezer.messagescheduler.dal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "messages")
data class Message(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "subject") val subject: String?,
    @ColumnInfo(name = "text") val text: String
)