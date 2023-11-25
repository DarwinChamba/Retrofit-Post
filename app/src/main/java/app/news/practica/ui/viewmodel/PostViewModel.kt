package app.news.practica.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import app.news.practica.data.model.Posts
import app.news.practica.dominio.GetListPostsUseCase
import app.news.practica.dominio.model.NuevoPosts
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(
    val useCase: GetListPostsUseCase,
    val secondUse: GetListPostsUseCase
) : ViewModel() {

    val lista = MutableLiveData<List<NuevoPosts>>()
    var isLoading = MutableLiveData<Boolean>()

    fun getListPosts() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = useCase()
            if (!result.isNullOrEmpty()) {
                lista.postValue(result)
                isLoading.postValue(false)
            }
        }
    }

    fun listaPosts() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val posts = secondUse()
            if (posts != null) {
                lista.postValue(posts)
            }
            isLoading.postValue(false)
        }
    }
}