package com.example.mypersonapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        register_button.setOnClickListener { _ ->
            val name = name_editText.text.toString()
            val phone = phone_editText.text.toString()
            val email = email_editText.text.toString()

            val myPerson = Person(name, phone, email)

            val personIntent = Intent(this, SecondActivity::class.java)
            personIntent.putExtra("MY_PERSON_KEY", myPerson)

            startActivity(personIntent)



        }

    }
}
