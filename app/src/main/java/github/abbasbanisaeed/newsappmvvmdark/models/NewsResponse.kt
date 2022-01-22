package github.abbasbanisaeed.newsappmvvmdark.models

import github.abbasbanisaeed.newsappmvvmdark.models.Article

data class NewsResponse(
    val articles: MutableList<Article>,
    val status: String,
    val totalResults: Int
)