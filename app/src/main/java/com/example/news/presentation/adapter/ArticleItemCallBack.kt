package com.example.news.presentation.adapter

import androidx.recyclerview.widget.DiffUtil
import com.example.news.domain.model.Article

object ArticleItemCallBack : DiffUtil.ItemCallback<Article>() {
    override fun areItemsTheSame(old: Article, new: Article) = old.url == new.url
    override fun areContentsTheSame(oldItem: Article, newItem: Article) = oldItem == newItem
}