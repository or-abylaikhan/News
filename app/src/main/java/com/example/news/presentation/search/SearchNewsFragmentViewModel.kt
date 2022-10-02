package com.example.news.presentation.search

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.news.domain.use_case.SearchForNewsUseCase
import com.example.news.util.Constants.DEFAULT_QUERY
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchNewsFragmentViewModel @Inject constructor(private val searchForNewsUseCase: SearchForNewsUseCase) :
    ViewModel() {

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)
    val articles = currentQuery
        .switchMap { query -> searchForNewsUseCase.searchForNews(query) }
        .cachedIn(viewModelScope)

    fun searchArticles(query: String) {
        currentQuery.value = query
    }
}