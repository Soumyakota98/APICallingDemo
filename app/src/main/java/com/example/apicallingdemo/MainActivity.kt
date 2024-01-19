package com.example.apicallingdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    private lateinit var adapterRV : RecyclerViewAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerview : RecyclerView = findViewById(R.id.recycler_view)
        val retrofit = Retrofit.Builder().baseUrl("https://simplifiedcoding.net/demos/").
        addConverterFactory(GsonConverterFactory.create()).build()
        val api = retrofit.create(SuperHeroApi::class.java)

        api.getHeros()?.enqueue(object :Callback<List<Heros?>?>{
            override fun onResponse(call: Call<List<Heros?>?>, response: Response<List<Heros?>?>) {
            val list:List<Heros> = response.body() as List<Heros>
                adapterRV = RecyclerViewAdapter(list)
                recyclerview.apply {
                    layoutManager= LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
                    adapter= adapterRV
                }
            }

            override fun onFailure(call: Call<List<Heros?>?>, t: Throwable) {
                Log.d("MainActivity", "onFailure: "+t.message)
            }
             })
    }
}