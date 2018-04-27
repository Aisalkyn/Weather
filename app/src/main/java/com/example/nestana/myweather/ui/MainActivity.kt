 package com.example.nestana.myweather.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.nestana.myweather.R

 class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         val searchText = findViewById<EditText>(R.id.editText)
         val forecastbtn = findViewById<Button>(R.id.searchWeatherBtn)
         forecastbtn.setOnClickListener {
             Log.i("searchString", searchText.text.toString())
             var i =  Intent(this@MainActivity, ForecastActivity::class.java)
             val searchText = findViewById<EditText>(R.id.editText)
             i.putExtra("searchString", searchText.text.toString())
             startActivity(i)
         }
     }
 }
