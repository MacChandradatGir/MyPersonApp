package com.example.mypersonapp

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        camera_button.setOnClickListener { _ ->
            val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(cameraIntent, 777)
        }

        val personIn: Person = intent?.getParcelableExtra("MY_PERSON_KEY") as Person
        personIn.let { person ->
            name_textView.text =  person.name
            phone_textView.text = person.phone
            email_textView.text = person.email

        }

        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?){
            super.onActivityResult(requestCode, resultCode, data)
            if(requestCode == 777 && resultCode == Activity.RESULT_OK){
                val bitmap: Bitmap = (data?.extras?.get("data") as Bitmap)
                my_imageView.setImageBitmap(bitmap)
            }

        }


    }


}
