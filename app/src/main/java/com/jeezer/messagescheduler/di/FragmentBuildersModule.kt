package com.jeezer.messagescheduler.di

import com.jeezer.messagescheduler.ui.account.AccountFragment
import com.jeezer.messagescheduler.ui.message.MessageFragment
import com.jeezer.messagescheduler.ui.schedule.ScheduleFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Suppress("unused")
@Module
abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeAccountFragment(): AccountFragment

    @ContributesAndroidInjector
    abstract fun contributeMessageFragment(): MessageFragment

    @ContributesAndroidInjector
    abstract fun contributeScheduleFragment(): ScheduleFragment
}
