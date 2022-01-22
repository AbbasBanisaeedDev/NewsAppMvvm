package github.abbasbanisaeed.newsappmvvmdark.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.google.android.material.bottomnavigation.BottomNavigationView
import github.abbasbanisaeed.newsappmvvmdark.db.ArticleDatabase
import github.abbasbanisaeed.newsappmvvmdark.util.PrefHelper
import github.abbasbanisaeed.newsappmvvmdark.R
import github.abbasbanisaeed.newsappmvvmdark.repository.NewsRepository

class NewsActivity : AppCompatActivity() {
    lateinit var viewModel: NewsViewModel
    lateinit var bottomNavigationView: BottomNavigationView
    private val pref by lazy {
        PrefHelper(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news)
        val newsRepository = NewsRepository(ArticleDatabase(this))
        val viewModelProviderFactory = NewsViewModelProviderFactory(application, newsRepository)
        viewModel = ViewModelProvider(this, viewModelProviderFactory)[NewsViewModel::class.java]
        var newsNavHostFragment =
            supportFragmentManager.findFragmentById(R.id.newsNavHostFragment) as NavHostFragment?
        bottomNavigationView = findViewById(R.id.bottomNavigationView)
        NavigationUI.setupWithNavController(
            bottomNavigationView,
            newsNavHostFragment!!.navController
        )
        when (pref.getBoolean("pref_is_dark_mode")) {
            true -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)

            }
            false -> {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }


        }


    }


}