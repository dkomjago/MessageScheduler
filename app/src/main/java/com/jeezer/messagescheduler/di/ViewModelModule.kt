package com.jeezer.messagescheduler.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jeezer.messagescheduler.ui.account.AccountViewModel
import com.jeezer.messagescheduler.ui.message.MessageViewModel
import com.jeezer.messagescheduler.ui.schedule.ScheduleViewModel

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Suppress("unused")
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(ScheduleViewModel::class)
    abstract fun bindScheduleViewModel(viewModel: ScheduleViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(MessageViewModel::class)
    abstract fun bindMessageViewModel(viewModel: MessageViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(AccountViewModel::class)
    abstract fun bindAccountViewModel(viewModel: AccountViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}
