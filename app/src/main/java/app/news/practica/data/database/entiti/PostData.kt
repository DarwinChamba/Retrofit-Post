package app.news.practica.data.database.entiti

import androidx.room.Entity
import androidx.room.PrimaryKey
import app.news.practica.dominio.model.NuevoPosts

@Entity(tableName = "tablaPosts")
data class PostData(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val userId: Int,
    val title: String,
    val body: String
)
fun NuevoPosts.toDatbase() = PostData(id, userId, title, body)

