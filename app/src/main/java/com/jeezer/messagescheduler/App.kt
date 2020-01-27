package com.jeezer.messagescheduler

import android.app.Application
import com.facebook.stetho.Stetho
import com.jeezer.messagescheduler.dal.SchedulerDatabase
import com.jeezer.messagescheduler.dal.SchedulerDatabase_Impl
import com.jeezer.messagescheduler.di.AppInjector
import com.jeezer.messagescheduler.util.CrashReportingTree
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) Stetho.initializeWithDefaults(this)

        if (BuildConfig.DEBUG) Timber.plant(Timber.DebugTree())
        else Timber.plant(CrashReportingTree())

        AppInjector.init(this)

        SchedulerDatabase.getInstance(applicationContext).query("select 1", null)
    }

    fun getContext() = applicationContext

    override fun androidInjector() = dispatchingAndroidInjector
}