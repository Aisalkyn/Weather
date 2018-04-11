package com.example.nestana.myweather.ui

import android.content.Context
import com.example.nestana.myweather.model.Weather
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import com.example.nestana.myweather.other.ForumService


class MainPresenter(internal var service: ForumService, internal var context: Context) : MainContract.Presenter {
    internal var view: MainContract.View? = null

    private val canStopProgress = false

    val isViewAttached: Boolean
        get() = view != null

    fun bind(view: MainContract.View) {
        this.view = view
    }

    override fun loadWeather() {
        service.getWeather().enqueue(object : Callback<Weather>() {
            fun onResponse(call: Call<Weather>, response: Response<Weather>) {
                if (isViewAttached)
                    if (response.isSuccessful()) {
                        if (response.body().getToday().size() === 0 || response.body().getToday() == null) {
                            onWeatherFail()
                            return
                        }
                        onWeatherSuccess(response.body())
                    } else
                        onWeatherFail()
            }

            fun onFailure(call: retrofit2.Call<Weather>, t: Throwable) {
                t.printStackTrace()
                if (isViewAttached) onWeatherFail()
            }
        })
    }

    private fun onWeatherSuccess(body: Weather) {
        view!!.onWeatherSuccess("Bishkek", getCurrentWeather(body.getToday()).getTemp())
        Settings.setWeather(context, body)
    }

    private fun onWeatherFail() {
        val weather = Settings.getWeather(context)
        if (weather != null)
            view!!.onWeatherSuccess("Bishkek", getCurrentWeather(weather!!.getToday()).getTemp())
        else
            view!!.onWeatherFail()
    }



    fun unbind() {
        view = null
    }
}
