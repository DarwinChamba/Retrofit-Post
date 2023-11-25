package app.news.practica.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import app.news.practica.R
import app.news.practica.databinding.ActivityMainBinding
import app.news.practica.ui.viewmodel.PostViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var model:PostViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        model=ViewModelProvider(this).get(PostViewModel::class.java)
        model.getListPosts()
        model.lista.observe(this, Observer {
            binding.respuesta.text=it.toString()
        })
        model.isLoading.observe(this, Observer {
            binding.bar.isVisible=it
        })
    }
}