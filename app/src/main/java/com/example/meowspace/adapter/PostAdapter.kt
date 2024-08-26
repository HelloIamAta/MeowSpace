import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meowspace.R
import com.example.meowspace.databinding.PostModulBinding
import com.example.meowspace.response.PostResponse
import com.example.meowspace.utils.session.SessionManager

class PostAdapter(
    private val context: Context,
    private var postList: List<PostResponse>,
    private val navController: NavController,
    private val session: SessionManager,
) : RecyclerView.Adapter<PostAdapter.ViewHolder>() {

    class ViewHolder(view: PostModulBinding) : RecyclerView.ViewHolder(view.root) {
        val postUserName = view.postUserName
        val postUserImage = view.postUserImage
        val postImage = view.postImage
        val postDesc = view.postDesc
        val likeButton = view.likeButton
        val pawText = view.pawText
        val commentButton = view.commentButton
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostModulBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = postList[position]
        var isButtonClicked = false
        holder.apply {
            postUserName.text = current.userName
            postDesc.text = current.text

            val resID = context.resources.getIdentifier(current.userImage, "drawable", context.packageName)
            val drawable = context.resources.getDrawable(resID)

            val resIDx = context.resources.getIdentifier(current.postImage, "drawable", context.packageName)
            val drawablex = context.resources.getDrawable(resIDx)

            Glide.with(context)
                .load(drawablex)
                .override(335, 325)
                .centerCrop()
                .into(postImage)

            Glide.with(context)
                .load(drawable)
                .override(35, 35)
                .centerCrop()
                .into(postUserImage)

            likeButton.setOnClickListener {

                    if (isButtonClicked) {
                        isButtonClicked = false
                        pawText.text = "Paw"
                        likeButton.drawable.setTint(ContextCompat.getColor(context, R.color.black))
                    }else{
                        likeButton.drawable.setTint(ContextCompat.getColor(context, R.color.like_button_clicked))

                        pawText.text = "1"
                        isButtonClicked = true
                    }
            }

            commentButton.setOnClickListener {
                Toast.makeText(context, "Comment Button Clicked", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }

}
