package dev.adarsh.weather

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class WeatherRepository {

    companion object{
        lateinit var weatherRepository:WeatherRepository
        fun getInstance():WeatherRepository{
            weatherRepository = WeatherRepository()
            return weatherRepository
        }
    }

    fun getWeather(id:String, api_key:String):MutableLiveData<WeatherModel.Main>{
        var weatherData = MutableLiveData<WeatherModel.Main>()
        Api().getCurrentWeather(id,api_key).enqueue(object : Callback<WeatherModel>{
            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                Log.d("Repository","Error occured")
            }

            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                weatherData.value = response.body()?.main
            }
        })
        return weatherData
    }

}