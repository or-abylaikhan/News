package com.example.news.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.example.news.databinding.NewsItemBinding
import com.example.news.domain.model.Article
import com.example.news.util.publishedAtSimple

class NewsAdapter(private val OnItemClickListener: (Article) -> Unit) :
    ListAdapter<Article, NewsAdapter.NewsViewHolder>(
        object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(old: Article, new: Article) = old.url == new.url
            override fun areContentsTheSame(oldItem: Article, newItem: Article) = oldItem == newItem
        }
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder =
        NewsViewHolder(NewsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class NewsViewHolder(private val binding: NewsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(article: Article) {
            with(binding) {
                Glide.with(root).load(article.urlToImage).centerCrop()
                    .transition(DrawableTransitionOptions.withCrossFade()).into(ivArticleImage)
                tvArticleSource.text = article.source.name
                tvArticleTitle.text = article.title
                tvArticleDescription.text = article.description
                tvArticleAuthor.text = article.author
                tvArticlePublishedAt.text = article.publishedAtSimple()
                root.setOnClickListener { OnItemClickListener.invoke(article) }
            }
        }
    }
}