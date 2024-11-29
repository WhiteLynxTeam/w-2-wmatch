package ru.w_2_wmatch.view.main.mane_page.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.w_2_wmatch.databinding.ItemNewsEducationBinding
import ru.w_2_wmatch.domain.models.NewsEducation

class NewsEducationAdapter(private val newsEducationList: List<NewsEducation>) : RecyclerView.Adapter<NewsEducationAdapter.NewsEducationViewHolder>() {
    class NewsEducationViewHolder(private val binding: ItemNewsEducationBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(newsEducation: NewsEducation) {
            binding.img.setImageResource(newsEducation.img)
            binding.title.text = newsEducation.title
            binding.description.text = newsEducation.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsEducationViewHolder {
        val binding =
            ItemNewsEducationBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NewsEducationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: NewsEducationViewHolder, position: Int) {
        holder.bind(newsEducationList[position])
    }

    override fun getItemCount() = newsEducationList.size

}