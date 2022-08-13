package com.example.news.presentation.article

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.domain.model.Article
import com.example.news.domain.use_case.SaveArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleFragmentViewModel @Inject constructor(private val saveArticleUseCase: SaveArticleUseCase) :
    ViewModel() {

    fun save(article: Article) = viewModelScope.launch { saveArticleUseCase.saveArticle(article) }
}