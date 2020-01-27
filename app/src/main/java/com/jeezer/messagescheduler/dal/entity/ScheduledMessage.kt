package com.jeezer.messagescheduler.dal.entity

import androidx.room.*
import com.google.gson.annotations.Expose
import com.google.gson.annotations.JsonAdapter
import com.jeezer.messagescheduler.util.OffsetDateTimeConverter
import org.threeten.bp.OffsetDateTime

@Entity(tableName = "scheduledMessages", foreignKeys = [ForeignKey(entity = Message::class,
    parentColumns = ["id"],
    childColumns = ["message_id"],
    onDelete = ForeignKey.CASCADE)])
data class ScheduledMessage(
    @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @JsonAdapter(OffsetDateTimeConverter::class)
    @ColumnInfo(name = "time") val time: OffsetDateTime,
    @Expose
        @ColumnInfo(name = "message_id", index = true) val messageId: Long
)