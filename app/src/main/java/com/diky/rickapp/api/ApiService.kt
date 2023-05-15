package com.diky.rickapp.api

import com.diky.rickapp.ResponseRick
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("character")
    fun getrick() : Call<ResponseRick>
}