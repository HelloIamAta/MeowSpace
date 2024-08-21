package com.example.meowspace.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meowspace.R
import com.example.meowspace.databinding.StoryModulBinding
import com.example.meowspace.response.StoryResponse

class StoryAdapter(
    private val context: Context,
    private var storyList:List<StoryResponse>,
    private val navController: NavController
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

            val resID = context.resources.getIdentifier(current.image, "drawable", context.packageName)
            val drawable = context.resources.getDrawable(resID)

            card.setOnClickListener {
                navController.navigate(R.id.action_mainPageFragment_to_storyFragment)
            }

            Glide
                .with(context)
                .load(drawable)
                .override(400, 400)
                .centerCrop() // or use fitcenter
                .into(storyImg)

            val originalText = current.name
            val result = truncateTextWithDots(originalText, 9)
            storyName.text = result

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
