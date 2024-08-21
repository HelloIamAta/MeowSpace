package com.example.meowspace.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meowspace.databinding.StoryModulBinding
import com.example.meowspace.response.StoryResponse

class StoryAdapter(
    private val context: Context,
    private var storyList:List<StoryResponse>
): RecyclerView.Adapter<StoryAdapter.ViewHolder>() {

    class ViewHolder(view: StoryModulBinding) : RecyclerView.ViewHolder(view.root) {

        val storyImg = view.storyImage
        val storyName = view.storyName
        val card = view.storyClickable

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = StoryModulBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = storyList[position]
        holder.apply {

            card.setOnClickListener {



            }

            val originalText = current.name
            val result = truncateTextWithDots(originalText, 9)
            storyName.text = result


            val resID = context.resources.getIdentifier(current.image, "drawable", context.packageName)
            val drawable = context.resources.getDrawable(resID)
            storyImg.setImageDrawable(drawable)
        }

    }

    override fun getItemCount(): Int {
        return storyList.size
    }

    private fun truncateTextWithDots(text: String, maxLength: Int): String {
        return if (text.length > maxLength) {
            text.substring(0, maxLength) + ".".repeat(1)
        } else {
            text
        }
    }
}