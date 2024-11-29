package ru.w_2_wmatch.view.main.mane_page.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.w_2_wmatch.databinding.ItemCommunityBinding
import ru.w_2_wmatch.domain.models.Community

class CommunityAdapter(private val communityList: List<Community>) :RecyclerView.Adapter<CommunityAdapter.CommunityViewHolder>() {
    class CommunityViewHolder (private val binding:ItemCommunityBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(community: Community){
            binding.img.setImageResource(community.img)
            binding.title.text = community.title
            binding.description.text = community.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommunityViewHolder {
       val binding = ItemCommunityBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CommunityViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CommunityViewHolder, position: Int) {
        holder.bind(communityList[position])
    }

    override fun getItemCount() = communityList.size

}