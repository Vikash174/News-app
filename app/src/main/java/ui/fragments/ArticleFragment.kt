package ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

import com.example.newsapp.R
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_article.*
import ui.MainActivity
import ui.NewsViewModel

class ArticleFragment :Fragment (R.layout.fragment_article){

    private lateinit var viewModel: NewsViewModel
    private val args:ArticleFragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as MainActivity).viewModel
        articleProgressBar.visibility = View.VISIBLE

        val article = args.article

        webView.apply {
            webViewClient = WebViewClient()

            loadUrl(article.url)

            articleProgressBar.visibility = View.INVISIBLE

        }
  fab.setOnClickListener {
      viewModel.saveArticle(article)
      Snackbar.make(view,"Article saved successfully",Snackbar.LENGTH_SHORT).show()
  }

    }


}