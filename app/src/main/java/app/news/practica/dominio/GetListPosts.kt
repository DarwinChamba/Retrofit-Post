package app.news.practica.dominio

import app.news.practica.data.PostsRepository
import app.news.practica.data.model.Posts
import app.news.practica.dominio.model.NuevoPosts
import javax.inject.Inject

class GetListPosts @Inject constructor(val repository: PostsRepository) {
    suspend operator fun  invoke():NuevoPosts?{
        val posts=repository.getAllPostsFromDatabase()
        if(!posts.isNullOrEmpty()){
           val random=(posts.indices).random()
           return posts[random]
        }
        return  null
    }
}