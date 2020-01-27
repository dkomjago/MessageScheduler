package com.jeezer.messagescheduler.ui.schedule

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.jeezer.messagescheduler.dal.entity.ScheduledMessage
import com.jeezer.messagescheduler.databinding.FragmentScheduleBinding
import com.jeezer.messagescheduler.di.Injectable
import com.jeezer.messagescheduler.di.injectViewModel
import org.threeten.bp.OffsetDateTime
import javax.inject.Inject

class ScheduleFragment : Fragment(), Injectable {
    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ScheduleViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = injectViewModel(viewModelFactory)

        val binding = FragmentScheduleBinding.inflate(inflater, container, false)
        context ?: return binding.root

        val adapter = ScheduleAdapter()

        binding.scheduleView.adapter = adapter

        subscribeUi(binding, adapter)

        binding.fab.setOnClickListener {
            viewModel.insert(ScheduledMessage(messageId = 1, time = OffsetDateTime.now()))
        }

       return binding.root
    }

    private fun subscribeUi(binding: FragmentScheduleBinding, adapter: ScheduleAdapter) {
        viewModel.getAllScheduledMessages()
            .observe(viewLifecycleOwner, Observer { adapter.submitList(it) })
    }
}