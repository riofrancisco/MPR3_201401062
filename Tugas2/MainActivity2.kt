package com.example.lab2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

import android.widget.TextView

class MainActivity2 : AppCompatActivity() {

    private lateinit var textView2 : TextView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textView2 = findViewById(R.id.textView2)
        val getText = intent.getStringExtra(EXTRA_TEXT)
        val getBool = intent.getBooleanExtra(EXTRA_BOOL, false)
        textView2.text = getText

        if (getBool == true) {
            val getCar = intent?.getParcelableExtra<Car>(EXTRA_CAR)
            Log.i("TAG", getCar?.name.toString())
            val carSpek = "Car Specification:\n" +
                    "\nName : ${getCar?.name.toString()}" +
                    "\nBrand : ${getCar?.brand.toString()}" +
                    "\nType : ${getCar?.type.toString()}" +
                    "\nYear : ${getCar?.year.toString()}" +
                    "\nPrice : ${getCar?.price.toString()}"
            textView2.text = carSpek
        }

    }

    companion object {
        const val EXTRA_TEXT = "extra_text"
        const val EXTRA_BOOL = "extra_bool"
        const val EXTRA_CAR = "extra_car"
    }
}