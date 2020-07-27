package com.georgcantor.aac.view.view.details

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import androidx.core.app.ActivityOptionsCompat.makeSceneTransitionAnimation
import com.georgcantor.aac.R
import com.georgcantor.aac.databinding.ActivityPosterDetailBinding
import com.georgcantor.aac.view.base.DatabindingActivity
import com.georgcantor.aac.view.extensions.applyMaterialTransform
import com.georgcantor.aac.view.model.Article

class DetailActivity : DatabindingActivity() {

    companion object {
        private const val ARTICLE_KEY = "article_key"

        fun startActivityModel(context: Context?, startView: View, poster: Article) {
            if (context is Activity) {
                Intent(context, DetailActivity::class.java).apply {
                    putExtra(ARTICLE_KEY, poster)
                    context.startActivity(this, makeSceneTransitionAnimation(context, startView, poster.title).toBundle())
                }
            }
        }
    }

    private val binding: ActivityPosterDetailBinding by binding(R.layout.activity_poster_detail)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val poster = intent.getParcelableExtra<Article>(ARTICLE_KEY)
        applyMaterialTransform(poster?.title ?: "")
        binding.apply {
            this.poster = poster
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
