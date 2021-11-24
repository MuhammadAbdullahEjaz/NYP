package com.example.nyp.utils

import android.util.Log
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView
import java.lang.Exception

@BindingAdapter("android:setImage")
fun bindSetImage(circleImageView: CircleImageView, url:String){
    val picasso = Picasso.get()
    picasso
        .load(url)
        .into(circleImageView, object : com.squareup.picasso.Callback {
            override fun onSuccess() {
                Log.d("fetch", "image loaded")
            }

            override fun onError(e: Exception?) {
                Log.d("fetch", "image loading failed ${e}")
            }
        })
}