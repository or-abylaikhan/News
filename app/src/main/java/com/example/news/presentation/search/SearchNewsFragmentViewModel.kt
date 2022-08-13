package com.example.news.presentation.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.domain.model.Article
import com.example.news.domain.use_case.SearchForNewsUseCase
import com.example.news.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchNewsFragmentViewModel @Inject constructor(
    private val searchForNewsUseCase: SearchForNewsUseCase
) : ViewModel() {

    private val _searchNews = MutableLiveData<Resource<List<Article>>>()
    private var searchNewsPage = 1
    val searchNews: LiveData<Resource<List<Article>>> = _searchNews

    fun searchForNews(query: String) =
        viewModelScope.launch {
            _searchNews.postValue(Resource.Loading())
            val resource = searchForNewsUseCase.searchForNews(query, searchNewsPage)
            _searchNews.postValue(resource)
        }
}