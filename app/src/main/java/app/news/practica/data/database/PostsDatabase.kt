package app.news.practica.data.database

import androidx.room.Dao
import androidx.room.Database
import androidx.room.RoomDatabase
import app.news.practica.data.database.dao.PostsDao
import app.news.practica.data.database.entiti.PostData

@Database(entities = [PostData::class], version = 1, exportSchema = false)
abstract class PostsDatabase:RoomDatabase() {

    abstract fun getPostDao():PostsDao
}