package com.example.signinactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.graphics.Color
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout


class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imageArray = arrayOf(
            R.drawable.pepe1,
            R.drawable.pepe2,
            R.drawable.pepe3,
            R.drawable.pepe4,
            R.drawable.pepe5
        )

        val imageViewRandom = findViewById<ImageView>(R.id.imgView_Random)
        val textViewName = findViewById<TextView>(R.id.txt_name2)
        val textViewId = findViewById<TextView>(R.id.txt_id3)

        val randomIndex = (0 until imageArray.size).random()
        imageViewRandom.setImageResource(imageArray[randomIndex])

        val name = intent.getStringExtra("name")
        val id = intent.getStringExtra("id")


        textViewName.text = ""
        textViewId.text = ""

        if (!name.isNullOrBlank()) {
            textViewName.text = "이름 : $name"
        }
        if (!id.isNullOrBlank()) {
            textViewId.text = "아이디 : $id"
        }


        }

    fun onGoBackButtonClick(view: View) {


        finish()
    }
}