package com.gama.task.data.api

import androidx.constraintlayout.solver.state.State
import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import kotlin.jvm.Throws


object RetrofitClient {

    private const val BASE_URL="http://143.198.117.2:8080/api/"

    private val okHttpClient:OkHttpClient.Builder= OkHttpClient.Builder()





    val instance:ApiService by lazy{
        val gson = GsonBuilder()
                .setLenient()
                .create()
        val retrofit=Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()

        retrofit.create(ApiService::class.java)
    }


}