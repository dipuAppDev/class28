package com.example.signupsigninform

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import com.google.android.material.imageview.ShapeableImageView

class MainActivity : AppCompatActivity() {
    private lateinit var signUpUserNameET:EditText
    private lateinit var signUpEmailET:EditText
    private lateinit var signUpPassET:EditText
    private lateinit var signUpAgeET:EditText
    private lateinit var signUpAddressET:EditText
    private lateinit var submitBtn:Button
    private lateinit var profileImg:ShapeableImageView
    private lateinit var signUpCameraV: ImageView
    var uri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.signup_page)
        signUpUserNameET = findViewById(R.id.userNameET)
        signUpEmailET = findViewById(R.id.emailET)
        signUpPassET = findViewById(R.id.passET)
        signUpAgeET = findViewById(R.id.ageET)
        signUpAddressET = findViewById(R.id.addressET)
        submitBtn = findViewById(R.id.submitBtn)
        profileImg = findViewById(R.id.profileImg)
        signUpCameraV = findViewById(R.id.signUpCameraV)

        signUpCameraV.setOnClickListener {
            imagePick()
        }

        submitBtn.setOnClickListener {


            var username = signUpUserNameET.text.toString()
            var userEmail = signUpEmailET.text.toString()
            var userPass = signUpPassET.text.toString()
            var userAge = signUpAgeET.text.toString()
            var userAddress = signUpAddressET.text.toString()


            val intent = Intent(
                this@MainActivity,
                HomeActivity::class.java
            )
            //pass image into another activity
            intent.putExtra("img", uri)
            startActivity(intent)

            intent.putExtra(
                "userName",
                username
            )
            intent.putExtra(
                "userEmail",
                userEmail
            )
            intent.putExtra(
                "userPass",
                userPass
            )
            intent.putExtra(
                "userAge",
                userAge
            )
            intent.putExtra(
                "userAddress",
                userAddress
            )
            startActivity(intent)
        }
    }
    private fun imagePick() {
        val intent = Intent()
        intent.action = Intent.ACTION_GET_CONTENT
        intent.type = "image/*"
        startActivityForResult(intent,1)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
//        if (resultCode == RESULT_OK){
//            if (requestCode == 1){
//                profileImg.setImageURI(data?.data)
//            }
//        }
        if (requestCode == 1 && data != null) {
            uri = data.data
            profileImg.setImageURI(uri)
        }
    }
}