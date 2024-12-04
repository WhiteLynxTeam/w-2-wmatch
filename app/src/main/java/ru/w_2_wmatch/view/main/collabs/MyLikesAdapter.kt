package ru.w_2_wmatch.view.main.collabs

import ru.w_2_wmatch.databinding.ItemMyLikeBinding
import ru.w_2_wmatch.domain.models.MyLikes
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class MyLikesAdapter(private val mylikesList: List<MyLikes>) : RecyclerView.Adapter<MyLikesAdapter.MyLikesViewHolder>() {

    class MyLikesViewHolder(private val binding: ItemMyLikeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(myLikes: MyLikes) {
            binding.img.setImageResource(myLikes.img)
            binding.title.text = myLikes.title
            binding.description.text = myLikes.description
            binding.avatar.setImageResource(myLikes.avatar)
            binding.userName.text = myLikes.userName
            binding.geo.setImageResource(myLikes.icGeo)
            binding.city.text = myLikes.city
            binding.icSubscribes.setImageResource(myLikes.icSubscribes)
            binding.subscribes.text = myLikes.subscribes
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyLikesViewHolder {
        val binding = ItemMyLikeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyLikesViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyLikesViewHolder, position: Int) {
        holder.bind(mylikesList[position])
    }

    override fun getItemCount() = mylikesList.size

}