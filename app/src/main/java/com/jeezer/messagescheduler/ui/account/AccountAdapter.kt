package com.jeezer.messagescheduler.ui.account

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.jeezer.messagescheduler.dal.entity.Account
import com.jeezer.messagescheduler.databinding.ListItemAccountBinding


class AccountAdapter : ListAdapter<Account, AccountAdapter.ViewHolder>(DiffCallback()){

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val account = getItem(position)
        holder.apply {
            bind(createOnClickListener(account.id, account.toString()), account)
            itemView.tag = account
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ListItemAccountBinding.inflate(
            LayoutInflater.from(parent.context), parent, false))
    }

    private fun createOnClickListener(id: Long, name: String): View.OnClickListener {
        return View.OnClickListener {
            //val direction = FragmentDirections
            //it.findNavController().navigate(direction)
        }
    }

    class ViewHolder(
        private val binding: ListItemAccountBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(listener: View.OnClickListener, item: Account) {
            binding.apply {
                clickListener = listener
                account = item
                executePendingBindings()
            }
        }
    }
}

private class DiffCallback : DiffUtil.ItemCallback<Account>() {

    override fun areItemsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Account, newItem: Account): Boolean {
        return oldItem == newItem
    }
}