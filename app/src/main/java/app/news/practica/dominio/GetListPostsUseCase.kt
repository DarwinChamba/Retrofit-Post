package app.news.practica.dominio

import androidx.lifecycle.MutableLiveData
import app.news.practica.data.PostsRepository
import app.news.practica.data.database.entiti.toDatbase
import app.news.practica.data.model.Posts
import app.news.practica.dominio.model.NuevoPosts
import javax.inject.Inject

class GetListPostsUseCase @Inject constructor(val repository: PostsRepository) {

    suspend operator fun invoke(): List<NuevoPosts> {
        val posts = repository.getAllPostsFromApi()
        return if (posts.isNotEmpty()) {
            repository.deletePosts()
            repository.insert(posts.map { it.toDatbase() })
            posts
        } else {
            repository.getAllPostsFromDatabase()
        }
    }
}