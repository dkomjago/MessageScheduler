package com.jeezer.messagescheduler.ui.account

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.jeezer.messagescheduler.dal.entity.Account
import com.jeezer.messagescheduler.dal.repository.AccountRepository
import javax.inject.Inject

class AccountViewModel @Inject constructor(private val repository: AccountRepository): ViewModel(){
    private val messages: LiveData<List<Account>> = repository.getAllAccounts()

    private fun insert(account: Account) {
        repository.insert(account)
    }

    fun getAllAccounts(): LiveData<List<Account>> {
        return messages
    }
}