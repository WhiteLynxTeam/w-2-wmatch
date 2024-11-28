package ru.w_2_wmatch.view.main.match_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.w_2_wmatch.databinding.ItemLikedUsersBinding
import ru.w_2_wmatch.domain.models.LikedUsers

class LikedUsersAdapter(private val usersList: List<LikedUsers>) : RecyclerView.Adapter<LikedUsersAdapter.LikedUsersViewHolder>() {

    class LikedUsersViewHolder(private val binding: ItemLikedUsersBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(users: LikedUsers) {
            binding.img.setImageResource(users.img)
            binding.userName.text = users.userName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LikedUsersViewHolder {
        val binding = ItemLikedUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LikedUsersViewHolder(binding)
    }

    override fun onBindViewHolder(holder: LikedUsersViewHolder, position: Int) {
        holder.bind(usersList[position])
    }

    override fun getItemCount() = usersList.size
}

