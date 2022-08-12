package com.example.news.presentation;

import com.example.news.presentation.article.ArticleFragment;

import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = ArticleFragment.class
)
@GeneratedEntryPoint
@InstallIn(FragmentComponent.class)
public interface ArticleFragment_GeneratedInjector {
  void injectArticleFragment(ArticleFragment articleFragment);
}
