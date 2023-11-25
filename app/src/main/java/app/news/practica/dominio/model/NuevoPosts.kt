package app.news.practica.dominio.model

import app.news.practica.data.database.entiti.PostData
import app.news.practica.data.model.Posts

data class NuevoPosts(
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)
fun Posts.toDomain() = NuevoPosts(id, userId, title,body)
fun PostData.toDomain()=NuevoPosts(id, userId, title, body)
