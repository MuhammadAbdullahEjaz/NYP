package com.example.nyp
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nyp.network.nyt.Articals
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.lang.Exception

class ArticalsFeedAdapter(private val data:List<Articals>):RecyclerView.Adapter<ArticalsFeedAdapter.ViewHolder>(){

    class ViewHolder(view:View):RecyclerView.ViewHolder(view){
        val circularImageView: CircleImageView = view.findViewById(R.id.thumbnail)
        val textView: TextView = view.findViewById(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.artical_feed_view, parent,false)
        return ViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val artical = data[position]
        Log.d("fetch","onBinding $artical")
        holder.textView.text = artical.title
        if(artical.media.isNotEmpty()) {
            val picasso = Picasso.get()
            picasso
                .load(artical.media.first().mediaMetadata?.first()?.url)
                .into(holder.circularImageView, object : com.squareup.picasso.Callback {
                    override fun onSuccess() {
                        Log.d("fetch", "image loaded")
                    }

                    override fun onError(e: Exception?) {
                        Log.d("fetch", "image loading failed ${e}")
                    }
                })
        }
    }
    override fun getItemCount(): Int = data.size
}