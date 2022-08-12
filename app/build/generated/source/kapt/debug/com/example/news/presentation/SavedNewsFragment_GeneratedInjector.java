package com.example.news.presentation;

import com.example.news.presentation.saved.SavedNewsFragment;

import dagger.hilt.InstallIn;
import dagger.hilt.android.components.FragmentComponent;
import dagger.hilt.codegen.OriginatingElement;
import dagger.hilt.internal.GeneratedEntryPoint;

@OriginatingElement(
    topLevelClass = SavedNewsFragment.class
)
@GeneratedEntryPoint
@InstallIn(FragmentComponent.class)
public interface SavedNewsFragment_GeneratedInjector {
  void injectSavedNewsFragment(SavedNewsFragment savedNewsFragment);
}
