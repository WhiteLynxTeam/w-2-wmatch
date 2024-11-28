package ru.w_2_wmatch.view.main.match_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.w_2_wmatch.databinding.ItemRecommendedBrandsBinding
import ru.w_2_wmatch.domain.models.RecommendedBrands

class RecommendedBrandsAdapter(private val brandsList: List<RecommendedBrands>) : RecyclerView.Adapter<RecommendedBrandsAdapter.RecommendedBrandsViewHolder>() {

    class RecommendedBrandsViewHolder(private val binding: ItemRecommendedBrandsBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(brands: RecommendedBrands) {
            binding.img.setImageResource(brands.img)
            binding.brandName.text = brands.brandName
            binding.geo.setImageResource(brands.icGeo)
            binding.city.text = brands.city
            binding.icSubscribes.setImageResource(brands.icSubscribes)
            binding.subscribes.text = brands.subscribes
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecommendedBrandsViewHolder {
        val binding = ItemRecommendedBrandsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecommendedBrandsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecommendedBrandsViewHolder, position: Int) {
        holder.bind(brandsList[position])
    }

    override fun getItemCount() = brandsList.size

}