package com.example.news.presentation.saved

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.news.domain.model.Article
import com.example.news.domain.use_case.DeleteArticleUseCase
import com.example.news.domain.use_case.GetSavedArticlesUseCase
import com.example.news.domain.use_case.SaveArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SaveNewsFragmentViewModel @Inject constructor(
    private val getSavedArticlesUseCase: GetSavedArticlesUseCase,
    private val deleteArticleUseCase: DeleteArticleUseCase,
    private val saveArticleUseCase: SaveArticleUseCase
) : ViewModel() {

    fun getSavedArticles() = getSavedArticlesUseCase.getSavedArticles()

    fun delete(article: Article) =
        viewModelScope.launch { deleteArticleUseCase.deleteArticle(article) }

    fun save(article: Article) = viewModelScope.launch { saveArticleUseCase.saveArticle(article) }
}