package com.jeezer.messagescheduler.ui.message

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jeezer.messagescheduler.databinding.FragmentMessageBinding
import com.jeezer.messagescheduler.di.Injectable
import com.jeezer.messagescheduler.di.injectViewModel
import javax.inject.Inject

class MessageFragment : Fragment(), Injectable{
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MessageViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)

        val binding = FragmentMessageBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = MessageAdapter()

        binding.messageView.adapter = adapter

        subscribeUi(binding, adapter)

        return binding.root
    }

    private fun subscribeUi(binding: FragmentMessageBinding, adapter: MessageAdapter) {
        viewModel.getAllMessages()
            .observe(viewLifecycleOwner, Observer { adapter.submitList(it) })
    }
}