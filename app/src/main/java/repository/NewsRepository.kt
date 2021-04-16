package repository

import api.RetrofitInstance
import db.ArticleDatabase
import models.Article

class NewsRepository(
    val db:ArticleDatabase
) {

    suspend fun getBreakingNews(countryCode : String, pageNumber: Int)=
        RetrofitInstance.api.getBreakingNews(countryCode,pageNumber)


    suspend fun searchNews(searchQuery: String,pageNumber: Int) =
        RetrofitInstance.api.searchForNews(searchQuery,pageNumber)

    suspend fun upsert(article: Article)= db.getArticle().upsert(article)

    fun getSavedNews() = db.getArticle().getAllArticle()

     suspend fun deleteArticle(article: Article) = db.getArticle().deleteArticle(article)


}