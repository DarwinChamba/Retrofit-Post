package app.news.practica.data.network

import app.news.practica.core.RetrofitInstance
import app.news.practica.data.model.Posts
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class ApiServices @Inject constructor(val api :ApiClient){

    suspend fun getPostsList(): List<Posts> {
        return withContext(Dispatchers.IO) {
            val response = api.getPosts()
            response.body() ?: emptyList()
        }

    }
}