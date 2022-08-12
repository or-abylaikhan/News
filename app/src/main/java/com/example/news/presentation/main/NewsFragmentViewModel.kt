package com.example.news.presentation.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.domain.model.Article
import com.example.news.domain.use_case.GetBreakingNewsUseCase
import com.example.news.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsFragmentViewModel @Inject constructor(private val getBreakingNewsUseCase: GetBreakingNewsUseCase) :
    ViewModel() {

    private val _breakingNews = MutableLiveData<Resource<List<Article>>>()
    private var breakingNewsPage = 1
    val breakingNews: LiveData<Resource<List<Article>>> = _breakingNews

    init {
        getBreakingNews("us")
    }

    private fun getBreakingNews(countryCode: String) =
        viewModelScope.launch {
            _breakingNews.postValue(Resource.Loading())
            val resource = getBreakingNewsUseCase.getBreakingNews(countryCode, breakingNewsPage)
            Log.d("ViewModel", resource.message.toString())
            _breakingNews.postValue(resource)
        }
}