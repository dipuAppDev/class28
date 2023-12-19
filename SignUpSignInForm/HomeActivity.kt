package com.example.signupsigninform

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresExtension
import com.google.android.gms.cast.framework.media.ImagePicker
import com.google.android.material.imageview.ShapeableImageView

class HomeActivity : AppCompatActivity() {
    private lateinit var homeNameTV:TextView
    private lateinit var homeEmailTV:TextView
    private lateinit var homePasswordTV:TextView
    private lateinit var homeAgeTV:TextView
    private lateinit var homeAddressTV:TextView
    private lateinit var profileImage:ShapeableImageView
    private lateinit var intent:Intent




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        homeNameTV = findViewById(R.id.homeNameTV)
        homeEmailTV = findViewById(R.id.homeEmailTV)
        homePasswordTV = findViewById(R.id.homePasswordTV)
        homeAgeTV = findViewById(R.id.homeAgeTV)
        homeAddressTV = findViewById(R.id.homeAddressTV)
        profileImage = findViewById(R.id.profileImgHome)
        intent = getIntent()
        val uri = intent.getParcelableExtra("img") as Uri?
        profileImage.setImageURI(uri)

        var username = intent.getStringExtra(
            "userName"
        )
        homeNameTV.text = username.toString()
        homeEmailTV.text = intent.getStringExtra("userEmail").toString()
        homePasswordTV.text = intent.getStringExtra("userPass").toString()
        homeAgeTV.text = intent.getStringExtra("userAge").toString()
        homeAddressTV.text = intent.getStringExtra("userAddress").toString()
    }


}