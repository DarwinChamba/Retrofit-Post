package app.news.practica.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import app.news.practica.data.database.entiti.PostData

@Dao
interface PostsDao {
    @Query("select * from tablaPosts order by id desc")
    suspend fun getAllPosts():List<PostData>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPosts(postData: List<PostData>)

    @Query("delete from tablaPosts")
    suspend fun delete()
}