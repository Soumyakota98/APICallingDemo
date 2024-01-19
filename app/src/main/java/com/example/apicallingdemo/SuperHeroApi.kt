package com.example.apicallingdemo

import retrofit2.Call
import retrofit2.http.GET

interface SuperHeroApi {
    @GET("marvel")
    fun getHeros():Call<List<Heros?>?>?
}