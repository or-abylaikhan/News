// Generated by Dagger (https://dagger.dev).
package com.example.news.presentation;

import com.example.news.domain.use_case.GetBreakingNewsUseCase;
import com.example.news.presentation.main.NewsFragmentViewModel;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NewsFragmentViewModel_Factory implements Factory<NewsFragmentViewModel> {
  private final Provider<GetBreakingNewsUseCase> getBreakingNewsUseCaseProvider;

  public NewsFragmentViewModel_Factory(
      Provider<GetBreakingNewsUseCase> getBreakingNewsUseCaseProvider) {
    this.getBreakingNewsUseCaseProvider = getBreakingNewsUseCaseProvider;
  }

  @Override
  public NewsFragmentViewModel get() {
    return newInstance(getBreakingNewsUseCaseProvider.get());
  }

  public static NewsFragmentViewModel_Factory create(
      Provider<GetBreakingNewsUseCase> getBreakingNewsUseCaseProvider) {
    return new NewsFragmentViewModel_Factory(getBreakingNewsUseCaseProvider);
  }

  public static NewsFragmentViewModel newInstance(GetBreakingNewsUseCase getBreakingNewsUseCase) {
    return new NewsFragmentViewModel(getBreakingNewsUseCase);
  }
}
