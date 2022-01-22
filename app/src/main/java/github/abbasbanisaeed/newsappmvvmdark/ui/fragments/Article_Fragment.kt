package github.abbasbanisaeed.newsappmvvmdark.ui.fragments

import android.os.Bundle

import android.view.View
import android.webkit.WebViewClient
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.varunest.sparkbutton.SparkEventListener
import github.abbasbanisaeed.newsappmvvmdark.R
import github.abbasbanisaeed.newsappmvvmdark.ui.NewsActivity
import github.abbasbanisaeed.newsappmvvmdark.ui.NewsViewModel
import kotlinx.android.synthetic.main.fragment_article_.*


class Article_Fragment : Fragment(R.layout.fragment_article_) {


    lateinit var viewModel: NewsViewModel
    val args: Article_FragmentArgs by navArgs()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = (activity as NewsActivity).viewModel
        val article = args.article
        webView.apply {
            webViewClient = WebViewClient()
            loadUrl(article.url)
        }


        fab.setEventListener(object : SparkEventListener {
            override fun onEvent(button: ImageView?, buttonState: Boolean) {
                viewModel.saveArticle(article)
                Snackbar.make(view, "Article saved successfully", Snackbar.LENGTH_SHORT).show()
            }

            override fun onEventAnimationEnd(button: ImageView?, buttonState: Boolean) {

            }

            override fun onEventAnimationStart(button: ImageView?, buttonState: Boolean) {

            }
        })


    }


}