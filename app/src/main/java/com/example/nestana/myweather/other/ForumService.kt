package com.example.nestana.myweather.other

import com.example.nestana.myweather.model.Weather
import okhttp3.Call
import retrofit2.http.GET


interface ForumService {

    @GET("api/weather")
     fun getWeather(): Call<Weather>


}