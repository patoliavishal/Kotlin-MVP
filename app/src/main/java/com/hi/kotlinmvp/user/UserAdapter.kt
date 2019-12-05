package com.hi.kotlinmvp.user

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.hi.kotlinmvp.R
import com.hi.kotlinmvp.user.model.UserResponse
import kotlinx.android.synthetic.main.item_user.view.*

/**
 * Created by Vishal Patel on 05/12/19.
 */
class UserAdapter(private val context: Context, private val userList: ArrayList<UserResponse>) :
        RecyclerView.Adapter<UserAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_user, parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.userName.text = userList[position].login
        Glide.with(context).load(userList[position].avatar_url).placeholder(R.drawable.ic_user).into(holder.userIcon)
        holder.userDetails.setOnClickListener {
            val uris = Uri.parse(userList[position].html_url)
            val intents = Intent(Intent.ACTION_VIEW, uris)
            context.startActivity(intents)
        }
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val userName: TextView = view.txtUserName
        val userIcon: ImageView = view.ivUserIcon
        val userDetails: LinearLayout = view.llUserDetails
    }
}
