import android.content.Context
import android.text.Layout
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.NavController
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
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
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PostModulBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val current = postList[position]
        holder.apply {
            postUserName.text = current.userName
            postDesc.text = current.text

            val resID = context.resources.getIdentifier(current.userImage, "drawable", context.packageName)
            val drawable = context.resources.getDrawable(resID)

            val resIDx = context.resources.getIdentifier(current.postImage, "drawable", context.packageName)
            val drawablex = context.resources.getDrawable(resIDx)

            Glide.with(context)
                .load(drawablex)
                .override(335, 275)
                .centerCrop()
                .into(postImage)

            Glide.with(context)
                .load(drawable)
                .override(35, 35)
                .centerCrop()
                .into(postUserImage)


        }
    }

    override fun getItemCount(): Int {
        return postList.size
    }





}
