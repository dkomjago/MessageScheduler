package com.jeezer.messagescheduler.util

import android.content.Context
import com.google.gson.Gson
import com.google.gson.stream.JsonReader
import com.google.gson.reflect.TypeToken


inline fun<reified T : Any> readJson(applicationContext: Context, fileName: String): T {
    applicationContext.assets.open(fileName).use { inputStream ->
        JsonReader(inputStream.reader()).use { jsonReader ->
            return Gson().fromJson(jsonReader, object: TypeToken<T>(){}.type)
        }
    }
}