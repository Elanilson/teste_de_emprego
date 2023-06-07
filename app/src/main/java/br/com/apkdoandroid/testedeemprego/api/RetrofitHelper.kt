package br.com.apkdoandroid.testedeemprego.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object RetrofitHelper {
    fun recuperarServico() : jsonplaceholderAPI{
        return Retrofit.Builder()
            .baseUrl("https://jsonplaceholder.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(jsonplaceholderAPI::class.java)
    }
}