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
import com.georgcantor.aac.view.model.Poster
import org.koin.android.viewmodel.ext.android.getViewModel

class PosterDetailActivity : DatabindingActivity() {

    private val binding: ActivityPosterDetailBinding by binding(R.layout.activity_poster_detail)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val poster = getViewModel<PosterDetailViewModel>().getPoster(intent.getLongExtra(posterKey, 0))
        applyMaterialTransform(poster.name)
        binding.apply {
            this.poster = poster
            activity = this@PosterDetailActivity
            container = detailContainer
            fab = fabMore
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) onBackPressed()

        return super.onOptionsItemSelected(item)
    }

    companion object {
        private const val posterKey = "posterKey"

        fun startActivityModel(context: Context?, startView: View, poster: Poster) {
            if (context is Activity) {
                Intent(context, PosterDetailActivity::class.java).apply {
                    putExtra(posterKey, poster.id)
                    context.startActivity(this, makeSceneTransitionAnimation(context, startView, poster.name).toBundle())
                }
            }
        }
    }
}
