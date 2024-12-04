package ru.w_2_wmatch.view.main.education.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.w_2_wmatch.databinding.ItemEducationPageBinding
import ru.w_2_wmatch.domain.models.Education

class EducationAdapter(private val educationList: List<Education>) :
    RecyclerView.Adapter<EducationAdapter.EducationViewHolder>() {
    class EducationViewHolder(private val binding: ItemEducationPageBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(education: Education) {
            binding.img.setImageResource(education.img)
            binding.title.text = education.title
            binding.description.text = education.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EducationViewHolder {
        val binding =
            ItemEducationPageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return EducationViewHolder(binding)
    }

    override fun onBindViewHolder(holder: EducationViewHolder, position: Int) {
        holder.bind(educationList[position])
    }

    override fun getItemCount() = educationList.size

}