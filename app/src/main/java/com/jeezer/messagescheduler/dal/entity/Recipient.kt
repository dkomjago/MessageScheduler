package com.jeezer.messagescheduler.dal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName= "recipients")
data class Recipient(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "username") val username: String?,
    @ColumnInfo(name = "email") val email: String?
)