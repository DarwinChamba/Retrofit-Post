package app.news.practica.data

import app.news.practica.data.database.dao.PostsDao
import app.news.practica.data.database.entiti.PostData
import app.news.practica.data.model.Posts
import app.news.practica.data.network.ApiServices
import app.news.practica.dominio.model.NuevoPosts
import app.news.practica.dominio.model.toDomain
import javax.inject.Inject


class PostsRepository @Inject constructor(val api: ApiServices, val dao: PostsDao) {

    suspend fun getAllPostsFromApi(): List<NuevoPosts> {
        val response = api.getPostsList()
        return response.map { it.toDomain() }
    }

    suspend fun getAllPostsFromDatabase(): List<NuevoPosts> {
        val response = dao.getAllPosts()
        return response.map { it.toDomain() }
    }
    suspend fun insert(posts:List<PostData>){
        dao.insertPosts(posts)
    }
    suspend fun deletePosts(){
        dao.delete()
    }
}