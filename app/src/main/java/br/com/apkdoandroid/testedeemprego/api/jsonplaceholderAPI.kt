package br.com.apkdoandroid.testedeemprego.api

import br.com.apkdoandroid.testedeemprego.data.Foto
import br.com.apkdoandroid.testedeemprego.data.Post
import retrofit2.Response
import retrofit2.http.GET

interface jsonplaceholderAPI {

    @GET("photos")
    suspend fun recuperarFotos() : Response<List<Foto>>

    @GET("posts")
    suspend fun recuperarPosts() : Response<List<Post>>
}