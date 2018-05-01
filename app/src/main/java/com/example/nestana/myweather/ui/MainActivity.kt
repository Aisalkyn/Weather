 package com.example.nestana.myweather.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import com.example.nestana.myweather.R
import kotlinx.android.synthetic.main.activity_main.*

 class MainActivity : AppCompatActivity() {

     override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
         setContentView(R.layout.activity_main)

         searchWeatherBtn.setOnClickListener {
             Log.i("searchString", editText.text.toString())
             var i =  Intent(this@MainActivity, ForecastActivity::class.java)
             i.putExtra("searchString", editText.text.toString())
             startActivity(i)
         }
     }
 }
