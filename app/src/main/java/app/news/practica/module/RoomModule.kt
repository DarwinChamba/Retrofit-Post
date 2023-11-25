package app.news.practica.module

import android.content.Context
import androidx.room.Room
import app.news.practica.data.database.PostsDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RoomModule {
    private const val NOMBRE_DATABASE="PostDatabase"
    @Singleton
    @Provides
    fun getRoom(@ApplicationContext context:Context)=
        Room.databaseBuilder(context,PostsDatabase::class.java,NOMBRE_DATABASE).build()

    @Singleton
    @Provides
    fun provideDao(database: PostsDatabase)=database.getPostDao()
}