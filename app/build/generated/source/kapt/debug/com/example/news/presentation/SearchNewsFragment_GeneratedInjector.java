package com.example.news.presentation;

import com.example.news.presentation.search.SearchNewsFragment;

import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = SearchNewsFragment.class
)
@GeneratedEntryPoint
@InstallIn(FragmentComponent.class)
public interface SearchNewsFragment_GeneratedInjector {
  void injectSearchNewsFragment(SearchNewsFragment searchNewsFragment);
}
