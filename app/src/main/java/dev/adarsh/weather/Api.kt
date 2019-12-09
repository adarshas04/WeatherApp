package dev.adarsh.weather

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Api() {

    val retrofit:Retrofit

    init{
        retrofit = Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    fun getCurrentWeather(id:String,apikey:String): Call<WeatherModel> {

        val apiService = retrofit.create(ApiService::class.java)
        val call = apiService.getCurrentWeather(id,apikey)
        return call
    }

}