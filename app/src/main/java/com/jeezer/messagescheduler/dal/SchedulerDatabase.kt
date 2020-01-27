package com.jeezer.messagescheduler.dal

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import androidx.sqlite.db.SupportSQLiteDatabase
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.google.gson.internal.bind.DateTypeAdapter
import com.jeezer.messagescheduler.dal.dao.*
import com.jeezer.messagescheduler.dal.entity.Account
import com.jeezer.messagescheduler.dal.entity.Message
import com.jeezer.messagescheduler.dal.entity.Recipient
import com.jeezer.messagescheduler.dal.entity.ScheduledMessage
import com.jeezer.messagescheduler.util.OffsetDateTimeConverter
import com.jeezer.messagescheduler.worker.SeedDatabaseWorker


@Database(entities = [Message::class, Recipient::class, Account::class, ScheduledMessage::class], version = 1, exportSchema = false)
@TypeConverters(OffsetDateTimeConverter::class)
abstract class SchedulerDatabase : RoomDatabase() {
    abstract fun messageDao(): MessageDao
    abstract fun recipientDao(): RecipientDao
    abstract fun accountDao(): AccountDao
    abstract fun scheduledMessageDao(): ScheduledMessageDao
    abstract fun scheduledMessageDtoDao(): ScheduledMessageDtoDao

    companion object {

        // For Singleton instantiation
        @Volatile
        private var instance: SchedulerDatabase? = null

        fun getInstance(context: Context):  SchedulerDatabase {
            return instance ?: synchronized(this) {
                instance ?: buildDatabase(context).also { instance = it}
            }
        }

        // Create and pre-populate the database. See this article for more details:
        // https://medium.com/google-developers/7-pro-tips-for-room-fbadea4bfbd1#4785
        private fun buildDatabase(context: Context):  SchedulerDatabase {
            return Room.databaseBuilder(context,  SchedulerDatabase::class.java, "PScheduler-db")
                .fallbackToDestructiveMigration()
                .addCallback(object : RoomDatabase.Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)
                        val request = OneTimeWorkRequestBuilder<SeedDatabaseWorker>().build()
                        WorkManager.getInstance(context).enqueue(request)
                    }
                })
                .build()
        }
    }
}
