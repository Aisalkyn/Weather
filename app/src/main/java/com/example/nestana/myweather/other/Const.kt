package com.example.nestana.myweather.other


object Const {
    var REQUEST_TIME: Long = 1
    var BASE_URL = "http://46.101.146.101:8081/"

    fun addSignToTemp(temp: String): String {
        return (if (Integer.parseInt(temp) > 0) "+" else "") + temp + "°C"
    }


}