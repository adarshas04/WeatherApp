package dev.adarsh.weather

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.weather_card.view.*

class WeatherAdapter(val data:List<WeatherModel.Main>) : RecyclerView.Adapter<WeatherAdapter.WeatherHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): WeatherHolder{
        val view = LayoutInflater.from(parent.context).inflate(R.layout.weather_card,parent,false)
        return WeatherHolder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: WeatherHolder, position: Int) {
        holder.bind(data[position])
    }

    class WeatherHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        fun bind(main: WeatherModel.Main) {
            itemView.temperature.text = main.temp.toString()
            itemView.humidity.text = main.humidity.toString()
        }

    }
}