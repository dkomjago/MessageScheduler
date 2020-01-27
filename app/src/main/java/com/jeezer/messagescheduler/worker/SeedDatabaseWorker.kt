package com.jeezer.messagescheduler.worker

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.jeezer.messagescheduler.dal.SchedulerDatabase
import com.jeezer.messagescheduler.util.ACCOUNT_DATA_FILENAME
import com.jeezer.messagescheduler.util.MESSAGE_DATA_FILENAME
import com.jeezer.messagescheduler.util.SCHEDULER_DATA_FILENAME
import com.jeezer.messagescheduler.util.readJson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import timber.log.Timber

class SeedDatabaseWorker(
        context: Context,
        workerParams: WorkerParameters
) : CoroutineWorker(context, workerParams) {

    override suspend fun doWork(): Result = coroutineScope {
        withContext(Dispatchers.IO) {

            try {
                with(SchedulerDatabase.getInstance(applicationContext)) {
                    messageDao().insertList(readJson(applicationContext, MESSAGE_DATA_FILENAME))
                    scheduledMessageDao().insertList(readJson(applicationContext, SCHEDULER_DATA_FILENAME))
                    accountDao().insertList(readJson(applicationContext, ACCOUNT_DATA_FILENAME))
                }
                Result.success()
            } catch (e: Exception) {
                Timber.e(e, "Error seeding database")
                Result.failure()
            }
        }
    }
}