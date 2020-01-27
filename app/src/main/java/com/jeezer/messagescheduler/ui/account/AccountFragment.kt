package com.jeezer.messagescheduler.ui.account

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jeezer.messagescheduler.databinding.FragmentAccountBinding
import com.jeezer.messagescheduler.di.Injectable
import com.jeezer.messagescheduler.di.injectViewModel
import javax.inject.Inject

class AccountFragment : Fragment(), Injectable{
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: AccountViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)

        val binding = FragmentAccountBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = AccountAdapter()

        binding.accountView.adapter = adapter

        subscribeUi(binding, adapter)

        return binding.root
    }

    private fun subscribeUi(binding: FragmentAccountBinding, adapter: AccountAdapter) {
        viewModel.getAllAccounts()
            .observe(viewLifecycleOwner, Observer { adapter.submitList(it) })
    }
}