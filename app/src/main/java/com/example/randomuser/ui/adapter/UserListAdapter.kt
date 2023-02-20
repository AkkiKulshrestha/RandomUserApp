package com.example.randomuser.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.randomuser.R
import com.example.randomuser.databinding.LayoutUserChildViewBinding
import com.example.randomuser.model.User

class UserListAdapter : RecyclerView.Adapter<UserListAdapter.Holder>() {

    private val users = mutableListOf<User>()
    private var hasWarning = false
    private var listener: Listener? = null

    /**
     * sets adapter listener
     *
     * @param listener listener for adapter
     */
    fun setListener(listener: Listener) {
        this.listener = listener
    }

    /**
     * updates the adapter data
     *
     * @param data data of the adapter
     */
    fun updateData(data: List<User?>?) {
        this.users.clear()
        val safeList = data?.mapNotNull { it }
        if (!safeList.isNullOrEmpty()) this.users.addAll(safeList)
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            LayoutUserChildViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) = holder.bind(position)


    override fun getItemCount(): Int {
        return users.size
    }


    inner class Holder(
        private val binding: LayoutUserChildViewBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {

            with(binding) {

                val user = users[position]
                userName.text = user.name

                val emailTxt = user.contact.email
                if (!emailTxt.isNullOrEmpty()) {
                    email.text = "Email : $emailTxt"
                }

                val mobileNo = user.contact.phone
                if (!mobileNo.isNullOrEmpty()) {
                    phoneNo.text = mobileNo
                }

                val genderTxt = user.gender.name
                if (genderTxt.isNotEmpty()) {
                    gender.text = genderTxt
                }

                val profileImage = user.picture?.large
                Glide.with(root.context).load(profileImage)
                    .placeholder(R.drawable.ic_girl_profile)
                    .error(R.drawable.ic_girl_profile)
                    .into(binding.profileImage)

                binding.lvMain.setOnClickListener {
                    listener?.onViewProfileClicked(user)
                }
            }
        }

    }

    interface Listener {
        fun onViewProfileClicked(user: User)
    }
}