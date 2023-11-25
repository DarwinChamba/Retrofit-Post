package app.news.practica.data.network

import app.news.practica.data.model.Posts
import retrofit2.Response
import retrofit2.http.GET

interface ApiClient {
    @GET("posts")
    suspend fun getPosts(): Response<List<Posts>>
}