package com.example.nestana.myweather.ui

import android.arch.lifecycle.Lifecycle


interface MainContract {
    interface View  {
        fun onWeatherSuccess(city: String, currentWeather: String)
        fun onWeatherFail()

    }

    interface Presenter : Lifecycle<View> {
        fun loadWeather()

    }
}