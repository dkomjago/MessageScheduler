package com.jeezer.messagescheduler.di

import android.app.Application
import com.jeezer.messagescheduler.dal.SchedulerDatabase
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class, CoreDataModule::class])
class AppModule {

    @Singleton
    @Provides
    fun provideDb(app: Application) = SchedulerDatabase.getInstance(app)

    @Singleton
    @Provides
    fun provideScheduledMessageDao(db: SchedulerDatabase) = db.scheduledMessageDao()

    @Singleton
    @Provides
    fun provideAccountDao(db: SchedulerDatabase) = db.accountDao()

    @Singleton
    @Provides
    fun provideRecipientDao(db: SchedulerDatabase) = db.recipientDao()

    @Singleton
    @Provides
    fun provideMessageDao(db: SchedulerDatabase) = db.messageDao()

    @Singleton
    @Provides
    fun provideScheduledMessageDtoDao(db: SchedulerDatabase) = db.scheduledMessageDtoDao()

    @CoroutineScropeIO
    @Provides
    fun provideCoroutineScopeIO() = CoroutineScope(Dispatchers.IO)
}
