package com.hamtz.sistemkeamanan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.bumptech.glide.Glide

class AboutActivity : AppCompatActivity() {
//    private lateinit var imageView2 : ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        val imgProfile = findViewById<ImageView>(R.id.imageView2)
        Glide.with(this).load(R.drawable.profil).circleCrop().into(imgProfile)


    }
}