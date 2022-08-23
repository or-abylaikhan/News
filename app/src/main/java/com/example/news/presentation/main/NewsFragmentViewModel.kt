package com.example.news.presentation.main

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.example.news.domain.use_case.GetBreakingNewsUseCase
import com.example.news.util.Constants.DEFAULT_COUNTRY_CODE
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class NewsFragmentViewModel @Inject constructor(private val getBreakingNewsUseCase: GetBreakingNewsUseCase) :
    ViewModel() {

    private val currentCountryCode = MutableLiveData(DEFAULT_COUNTRY_CODE)
    val breakingNews = currentCountryCode
        .switchMap { code -> getBreakingNewsUseCase.getBreakingNews(code) }
        .cachedIn(viewModelScope)

    fun changeCountry(countryCode: String) {
        currentCountryCode.value = countryCode
    }
}