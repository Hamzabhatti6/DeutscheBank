package com.hamza.deutschebank.presentation.ui.features.users.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.hamza.deutschebank.R
import com.hamza.deutschebank.data.users.domain.Users
import javax.inject.Inject
import com.hamza.deutschebank.BR
import com.hamza.deutschebank.presentation.ui.features.users.navigation.UserOnClick

class UsersAdapter @Inject constructor(): RecyclerView.Adapter<UsersAdapter.NewsViewHolder>() {

    private val usersList = ArrayList<Users>()
    private var itemOnClick: UserOnClick? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_users, parent, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount() = usersList.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val user = usersList[position]

        holder.binding?.setVariable(BR.model, user)
        holder.binding?.executePendingBindings()

        holder.itemView.setOnClickListener {
            this.itemOnClick?.onClick(position)
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setUsersList(list: List<Users>) {
        usersList.clear()
        usersList.addAll(list)
        notifyDataSetChanged()
    }

    class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var binding: ViewDataBinding?
        init {
            binding = DataBindingUtil.bind(itemView)
        }

    }
    fun setConfig(onClick: UserOnClick) {
        this.itemOnClick = onClick
    }
}