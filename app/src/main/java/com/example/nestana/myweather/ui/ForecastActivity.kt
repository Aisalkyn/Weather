package com.example.nestana.myweather.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.LinearLayout
import com.example.nestana.myweather.R
import com.example.nestana.myweather.model.WeatherNew
import kotlinx.android.synthetic.main.activity_forecast.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class ForecastActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forecast)

        val weatherRecyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        weatherRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayout.HORIZONTAL, false)

        val searchTerm = intent.extras.getString("searchString")
        Log.i("ForcastActivitySrchStr", searchTerm)
        val weather = ArrayList<WeatherNew>()
        var retriever = WeatherRetriever()
        city_name.text = intent.extras.getString("searchString")

        val callback = object: Callback<Weather2> {
            override fun onResponse(call: Call<Weather2>?, response: Response<Weather2>?) {
                Log.i("Response","Obtained")
                val forecastResponse = response?.body()?.query?.results?.channel?.item?.forecast
                //title = response?.body()?.query?.results?.channel?.title
                //city_name.text = response?.body()?.query?.results?.channel?.title

                temperature_c.text  = ((((response?.body()?.query?.results?.channel?.item?.forecast!![0].high).toInt()-32)*5)/9).toString() +"°C"
                city_date.text = response.body()?.query?.results?.channel?.item?.forecast!![0].date
                for(resp in forecastResponse!!) {
                    Log.i("Text", resp.text)
                    weather.add(WeatherNew(resp.date.substring(0, 2), resp.day, resp.high, resp.low, resp.text, resp.date.substring(3, 7)))
                }
                val adapter = WeatherListAdapter(weather)
                weatherRecyclerView.adapter = adapter
            }

            override fun onFailure(call: Call<Weather2>?, t: Throwable?) {

            }
        }
        retriever.getForecast(callback, searchTerm)
    }


}
