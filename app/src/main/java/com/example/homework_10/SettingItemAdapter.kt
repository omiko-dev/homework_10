package com.example.homework_10

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.homework_10.databinding.MessageSettingItemBinding
import com.example.homework_10.databinding.NormalSettingItemBinding
import com.example.homework_10.databinding.RedSettingItemBinding
import com.example.homework_10.databinding.SwitchSettingItemBinding

class SettingItemAdapter :
    ListAdapter<SettingItem, RecyclerView.ViewHolder>(object :
        DiffUtil.ItemCallback<SettingItem>(){
        override fun areItemsTheSame(oldItem: SettingItem, newItem: SettingItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: SettingItem, newItem: SettingItem): Boolean {
            return oldItem == newItem
        }
    }){

    private val testList: MutableList<SettingItem> = mutableListOf(
        SettingItem(0, R.drawable.ic_user, "Edit Profile", SettingItemType.Normal),
        SettingItem(1, R.drawable.ic_address, "Address", SettingItemType.Normal),
        SettingItem(2, R.drawable.ic_notification, "Notification", SettingItemType.Normal),
        SettingItem(3, R.drawable.ic_payment, "Payment", SettingItemType.Normal),
        SettingItem(4, R.drawable.ic_security, "Security", SettingItemType.Normal),
        SettingItem(5, R.drawable.ic_language, "Language", SettingItemType.WithMessage),
        SettingItem(6, R.drawable.ic_eye, "Dark Mode", SettingItemType.WithSwitch),
        SettingItem(7, R.drawable.ic_lock, "Privacy Policy", SettingItemType.Normal),
        SettingItem(8, R.drawable.ic_help, "Help Center", SettingItemType.Normal),
        SettingItem(9, R.drawable.ic_people, "Invite Friend", SettingItemType.Normal),
        SettingItem(10, R.drawable.ic_log_out, "Logout", SettingItemType.RedItem)
    )

    inner class NormalSettingItemViewHolder(private val binding: NormalSettingItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val item = testList[adapterPosition]
            binding.apply {
                tvIconAndTitle.text = item.title
                tvIconAndTitle.setCompoundDrawablesWithIntrinsicBounds(
                    item.icon,
                    0,
                    0,
                    0
                )
            }
        }
    }

    inner class MessageSettingItemViewHolder(private val binding: MessageSettingItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val item = testList[adapterPosition]
            binding.apply {
                tvIconAndTitle.text = item.title
                tvIconAndTitle.setCompoundDrawablesWithIntrinsicBounds(
                    item.icon,
                    0,
                    0,
                    0
                )
            }
        }
    }

    inner class SwitchSettingItemViewHolder(private val binding: SwitchSettingItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val item = testList[adapterPosition]
            binding.apply {
                tvIconAndTitle.text = item.title
                tvIconAndTitle.setCompoundDrawablesWithIntrinsicBounds(
                    item.icon,
                    0,
                    0,
                    0
                )
            }
        }
    }

    inner class RedSettingItemViewHolder(private val binding: RedSettingItemBinding):
        RecyclerView.ViewHolder(binding.root){
        fun bind(){
            val item = testList[adapterPosition]
            binding.apply {
                tvTitle.text = item.title
                ivIcon.setImageResource(item.icon)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (testList[position].settingItemType) {
            SettingItemType.Normal -> 0
            SettingItemType.WithMessage -> 1
            SettingItemType.WithSwitch -> 2
            SettingItemType.RedItem -> 3
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        when (viewType) {
            0 -> return NormalSettingItemViewHolder(
                NormalSettingItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            1 -> return MessageSettingItemViewHolder(
                MessageSettingItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            2 -> return SwitchSettingItemViewHolder(
                SwitchSettingItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            else -> return RedSettingItemViewHolder(
                RedSettingItemBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (holder) {
            is NormalSettingItemViewHolder -> {
                holder.bind()
            }

            is MessageSettingItemViewHolder -> {
                holder.bind()
            }

            is SwitchSettingItemViewHolder -> {
                holder.bind()
            }

            is RedSettingItemViewHolder -> {
                holder.bind()
            }
        }
    }

    override fun getItemCount(): Int {
        return testList.size
    }


}