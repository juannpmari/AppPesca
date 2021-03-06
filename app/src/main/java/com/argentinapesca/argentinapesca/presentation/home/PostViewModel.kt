package com.argentinapesca.argentinapesca.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import kotlinx.coroutines.Dispatchers
import com.argentinapesca.argentinapesca.repository.home.Repository

class PostViewModel(private val repo: Repository):ViewModel() {
    fun fetchPost()= liveData(Dispatchers.IO){
        emit(repo.getPosts())
    }
}

class PostViewModelFactory(private val repo: Repository): ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(Repository::class.java).newInstance(repo)
    }
}