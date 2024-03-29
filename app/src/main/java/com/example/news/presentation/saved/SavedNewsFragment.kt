package com.example.news.presentation.saved

import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.annotation.RequiresApi
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.news.R
import com.example.news.databinding.FragmentSavedNewsBinding
import com.example.news.presentation.adapter.ArticleAdapter
import com.example.news.util.Constants
import com.example.news.util.binding.BindingFragment
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedNewsFragment :
    BindingFragment<FragmentSavedNewsBinding>(FragmentSavedNewsBinding::inflate) {

    private val viewModel: SaveNewsFragmentViewModel by viewModels()
    private lateinit var adapter: ArticleAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = ArticleAdapter(
            OnItemClickListener = {
                val bundle = bundleOf(Constants.ARTICLE to it)
                findNavController()
                    .navigate(R.id.action_savedNewsFragment_to_articleFragment, bundle)
            }
        )
        iniViews()
        setupListeners()
        setupObservers()
    }

    private fun iniViews() = with(binding) { rvNews.adapter = adapter }


    private fun setupListeners() {
        ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(
                0, ItemTouchHelper.START or ItemTouchHelper.END
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ) = true

            @RequiresApi(Build.VERSION_CODES.M)
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val article = adapter.currentList[viewHolder.absoluteAdapterPosition]
                viewModel.delete(article)
                Snackbar.make(requireView(), "Article was deleted", Snackbar.LENGTH_LONG)
                    .apply {
                        setTextColor(context.getColor(R.color.red))
                        setBackgroundTint(context.getColor(R.color.dark_grey))
                        setActionTextColor(context.getColor(R.color.red))
                        setAction("Undo") { viewModel.save(article) }
                    }.show()
            }
        }).attachToRecyclerView(binding.rvNews)
    }

    private fun setupObservers() =
        viewModel.getSavedArticles().observe(viewLifecycleOwner) { adapter.submitList(it) }
}