package dev.adarsh.weather

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        lateinit var list:List<WeatherModel.Main>
        val viewModel = ViewModelProviders.of(this)
            .get(ViewModel::class.java)
        viewModel.getWeather("1277333","4ad25c0f74ecf4c2b388c46f4d8e6606").observe(this, Observer {
            list = listOf<WeatherModel.Main>(it)
        })
        weatherList.adapter=WeatherAdapter(list)
        weatherList.layoutManager=LinearLayoutManager(this)
    }
}
//api.openweathermap.org/data/2.5/weather?id=2172797&appid=1741e18faa21068dac89f4b43dc6f5f5