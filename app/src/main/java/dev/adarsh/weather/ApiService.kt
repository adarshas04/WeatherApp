package dev.adarsh.weather

import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("data/2.5/weather?")
    fun getCurrentWeather(@Query("id")  id:String, @Query("appid") appid:String): Call<WeatherModel>

}