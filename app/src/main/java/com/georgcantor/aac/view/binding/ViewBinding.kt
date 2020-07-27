package com.georgcantor.aac.view.binding

import android.graphics.Color
import android.transition.TransitionManager
import android.view.View
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.appcompat.widget.AppCompatImageView
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.databinding.BindingAdapter
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.georgcantor.aac.R
import com.georgcantor.aac.view.utils.gone
import com.georgcantor.aac.view.utils.visible
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.transition.platform.MaterialArcMotion
import com.google.android.material.transition.platform.MaterialContainerTransform
import com.skydoves.androidbottombar.AndroidBottomBarView
import com.skydoves.androidbottombar.BottomMenuItem
import kotlin.math.abs

@BindingAdapter("loadImage")
fun bindLoadImage(view: AppCompatImageView, url: String) {
    Glide.with(view.context)
            .load(url)
            .into(view)
}

@BindingAdapter("pagerAdapter")
fun bindPagerAdapter(view: ViewPager, adapter: PagerAdapter) {
    view.adapter = adapter
    view.offscreenPageLimit = 3
}

@BindingAdapter("gone")
fun bindGone(view: View, shouldBeGone: Boolean) {
    view.gone(shouldBeGone)
}

@BindingAdapter("bindNavigation")
fun bindNavigation(view: ViewPager, navigationView: AndroidBottomBarView) {
    navigationView.addBottomMenuItems(mutableListOf(
            BottomMenuItem(view.context)
                    .setTitle("Finance")
                    .setIcon(R.drawable.ic_finance)
                    .build(),

            BottomMenuItem(view.context)
                    .setTitle("Business")
                    .setIcon(R.drawable.ic_business)
                    .build(),

            BottomMenuItem(view.context)
                    .setTitle("Sport")
                    .setIcon(R.drawable.ic_sports)
                    .build()))

    navigationView.setOnMenuItemSelectedListener { index, _, _ ->
        navigationView.dismissBadge(index)
        view.currentItem = index
    }

    navigationView.setOnBottomMenuInitializedListener {
        navigationView.bindViewPager(view)
    }
}

@BindingAdapter("bindFab")
fun bindAppBarLayoutWithFab(appBarLayout: AppBarLayout, fab: FloatingActionButton) {
    appBarLayout.addOnOffsetChangedListener(OnOffsetChangedListener { barLayout: AppBarLayout, offset: Int ->
        val offsetPercentage = abs(offset).toFloat() / barLayout.totalScrollRange.toFloat()
        if (offsetPercentage > 0.4f && fab.isOrWillBeShown) {
            fab.hide()
        } else if (offsetPercentage <= 0.4f && fab.isOrWillBeHidden && fab.tag != GONE) {
            fab.show()
        }
    })
}

@BindingAdapter("transformFab", "transformContainer")
fun bindTransformFab(view: View, fab: FloatingActionButton, container: CoordinatorLayout) {
    fab.setOnClickListener {
        fab.tag = GONE
        TransitionManager.beginDelayedTransition(container, getTransform(fab, view))
        fab.gone(true)
        view.visible()
    }

    view.setOnClickListener {
        fab.tag = VISIBLE
        TransitionManager.beginDelayedTransition(container, getTransform(view, fab))
        fab.visible()
        view.gone(true)
    }
}

internal fun getTransform(mStartView: View, mEndView: View): MaterialContainerTransform {
    return MaterialContainerTransform().apply {
        startView = mStartView
        endView = mEndView
        addTarget(mEndView)
        pathMotion = MaterialArcMotion()
        duration = 650
        scrimColor = Color.TRANSPARENT
    }
}
