package com.example.news.presentation.saved

import androidx.lifecycle.ViewModel
import com.example.news.domain.use_case.GetSavedArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SaveNewsFragmentViewModel @Inject constructor(private val getSavedArticlesUseCase: GetSavedArticlesUseCase) :
    ViewModel() {

    fun getSavedArticles() = getSavedArticlesUseCase.getSavedArticles()

}