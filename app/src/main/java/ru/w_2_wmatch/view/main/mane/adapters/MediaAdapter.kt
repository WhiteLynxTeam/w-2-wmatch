package ru.w_2_wmatch.view.main.mane.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.w_2_wmatch.databinding.ItemMediaBinding
import ru.w_2_wmatch.domain.models.Media

class MediaAdapter(private val mediaList: List<Media>) :
    RecyclerView.Adapter<MediaAdapter.MediaViewHolder>() {
    class MediaViewHolder(private val binding: ItemMediaBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(media: Media) {
            binding.img.setImageResource(media.img)
            binding.title.text = media.title
            binding.description.text = media.description
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MediaViewHolder {
        val binding = ItemMediaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MediaViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MediaViewHolder, position: Int) {
        holder.bind(mediaList[position])
    }

    override fun getItemCount() = mediaList.size

}
