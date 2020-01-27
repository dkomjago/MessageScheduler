package com.jeezer.messagescheduler.ui.message

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jeezer.messagescheduler.dal.entity.Message
import com.jeezer.messagescheduler.databinding.ListItemMessageBinding


class MessageAdapter : ListAdapter<Message, MessageAdapter.ViewHolder>(DiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = getItem(position)
        holder.apply {
            bind(createOnClickListener(message.id, message.toString()), message)
            itemView.tag = message
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemMessageBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener(id: Long, name: String): View.OnClickListener {
        return View.OnClickListener {
            //val direction = FragmentDirections
            //it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: ListItemMessageBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Message) {
            binding.apply {
                clickListener = listener
                message = item
                executePendingBindings()
            }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Message>() {

    override fun areItemsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Message, newItem: Message): Boolean {
        return oldItem == newItem
    }
}