package com.jeezer.messagescheduler.util

import androidx.room.TypeConverter
import com.google.gson.JsonDeserializer
import com.google.gson.JsonSerializer
import org.threeten.bp.OffsetDateTime
import org.threeten.bp.format.DateTimeFormatter
import com.google.gson.JsonParseException
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import com.google.gson.JsonSerializationContext
import timber.log.Timber
import java.lang.reflect.Type


object OffsetDateTimeConverter : JsonSerializer<OffsetDateTime>, JsonDeserializer<OffsetDateTime> {
    private val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME

    @TypeConverter
    @JvmStatic
    fun toOffsetDateTime(value: String?): OffsetDateTime? {
        return value?.let {
            return formatter.parse(value, OffsetDateTime::from)
        }
    }

    @TypeConverter
    @JvmStatic
    fun fromOffsetDateTime(date: OffsetDateTime?): String? {
        return date?.format(formatter)
    }

    override fun serialize(
        src: OffsetDateTime,
        typeOfSrc: Type,
        context: JsonSerializationContext
    ): JsonElement {
        return JsonPrimitive(formatter.format(src))
    }

    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): OffsetDateTime {
        return formatter.parse(json.asString, OffsetDateTime.FROM)
    }
}