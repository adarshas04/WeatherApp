package dev.adarsh.weather

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ViewModel(val rep: WeatherRepository):ViewModel() {

    fun getWeather(id:String, key:String):MutableLiveData<WeatherModel.Main>{
        return rep.getWeather(id,key)
    }

}