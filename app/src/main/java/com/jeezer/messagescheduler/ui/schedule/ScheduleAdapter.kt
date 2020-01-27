package com.jeezer.messagescheduler.ui.schedule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jeezer.messagescheduler.dal.dto.ScheduledMessageDto
import com.jeezer.messagescheduler.databinding.ListItemScheduleBinding


class ScheduleAdapter : ListAdapter<ScheduledMessageDto, ScheduleAdapter.ViewHolder>(DiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val scheduledMessage = getItem(position)
        holder.apply {
            bind(createOnClickListener(scheduledMessage.schedule.id, scheduledMessage.message.toString()), scheduledMessage)
            itemView.tag = scheduledMessage
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemScheduleBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener(id: Long, name: String): View.OnClickListener {
        return View.OnClickListener {
            //val direction = FragmentScheduleDirections
            //it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: ListItemScheduleBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: ScheduledMessageDto) {
            binding.apply {
                clickListener = listener
                scheduledMessage = item
                executePendingBindings()
            }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<ScheduledMessageDto>() {

    override fun areItemsTheSame(oldItem: ScheduledMessageDto, newItem: ScheduledMessageDto): Boolean {
        return oldItem.schedule.id == newItem.schedule.id
    }

    override fun areContentsTheSame(oldItem: ScheduledMessageDto, newItem: ScheduledMessageDto): Boolean {
        return oldItem == newItem
    }
}