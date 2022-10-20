package com.example.lab2

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var teksjudul: TextView
    private lateinit var button1 : Button
    private lateinit var button2 : Button
    private lateinit var button3 : Button
    private lateinit var teks : EditText
    private lateinit var etKirimData : EditText

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        teksjudul = findViewById(R.id.teksjudul)

        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)
        button3 = findViewById(R.id.button3)

        teks = findViewById(R.id.teks)
        etKirimData = findViewById(R.id.teks)

    }

    fun onClick (view : View) {
        when(view.id){
            R.id.button1 -> {
                val phoneNumber = "081234567890"
                val dialPhoneIntent = Intent (Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

            R.id.button2 -> {
                val text = etKirimData.text.toString()
                val intent = Intent (this@MainActivity, MainActivity2::class.java)
                intent.putExtra(MainActivity2.EXTRA_TEXT, text)
                startActivity(intent)
            }

            R.id.button3 -> {
                val carSpek = Car (
                    "Civic",
                    "Honda",
                    "Sedan",
                    1997,
                    57000000.00
                )
                val intent = Intent (this@MainActivity, MainActivity2::class.java)
                intent.putExtra(MainActivity2.EXTRA_CAR, carSpek)
                intent.putExtra(MainActivity2.EXTRA_BOOL, true)
                startActivity(intent)
            }
        }
    }
}