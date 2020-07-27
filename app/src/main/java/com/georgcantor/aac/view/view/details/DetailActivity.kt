package com.georgcantor.aac.view.view.details

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.app.ActivityOptionsCompat.makeSceneTransitionAnimation
import com.georgcantor.aac.R
import com.georgcantor.aac.databinding.ActivityDetailBinding
import com.georgcantor.aac.view.base.DatabindingActivity
import com.georgcantor.aac.view.model.Article
import com.georgcantor.aac.view.utils.applyMaterialTransform

class DetailActivity : DatabindingActivity() {

    companion object {
        private const val ARTICLE_KEY = "article_key"

        fun startActivityModel(context: Context?, startView: View, article: Article) {
            if (context is Activity) {
                Intent(context, DetailActivity::class.java).apply {
                    putExtra(ARTICLE_KEY, article)
                    context.startActivity(this, makeSceneTransitionAnimation(context, startView, article.title).toBundle())
                }
            }
        }
    }

    private val binding: ActivityDetailBinding by binding(R.layout.activity_detail)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val article = intent.getParcelableExtra<Article>(ARTICLE_KEY)
        applyMaterialTransform(article?.title ?: "")
        binding.apply {
            this.article = article
            activity = this@DetailActivity
            container = detailContainer
            fab = fabMore
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()

        return super.onOptionsItemSelected(item)
    }
}
