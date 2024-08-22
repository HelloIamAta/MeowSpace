package com.example.meowspace.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meowspace.R
import com.example.meowspace.databinding.PostModulBinding
import com.example.meowspace.databinding.StoryModulBinding
import com.example.meowspace.response.PostResponse
import com.example.meowspace.response.StoryResponse
import com.example.meowspace.utils.session.SessionManager

class PostAdapter(
    private val context: Context,
    private var postList:List<PostResponse>,
    private val navController: NavController,
): RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(view: PostModulBinding) : RecyclerView.ViewHolder(view.root) {

        val postUserName = view.postUserName
        val postUserImage = view.postUserImage
        val postImage = view.postImage

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostModulBinding.inflate(LayoutInflater.from(context),parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = postList[position]
        holder.apply {

            postUserName.text = current.userName


            val resID = context.resources.getIdentifier(current.userImage, "drawable", context.packageName)
            val drawable = context.resources.getDrawable(resID)

            val resIDx = context.resources.getIdentifier(current.postImage, "drawable", context.packageName)
            val drawablex = context.resources.getDrawable(resIDx)

            Glide
                .with(context)
                .load(drawable)
                .override(400, 400)
                .centerCrop() // or use fitcenter
                .into(postUserImage)


            Glide
                .with(context)
                .load(drawable)
                .override(400, 400)
                .centerCrop() // or use fitcenter
                .into(postImage)


        }

    }

    override fun getItemCount(): Int {
        return postList.size
    }


}
