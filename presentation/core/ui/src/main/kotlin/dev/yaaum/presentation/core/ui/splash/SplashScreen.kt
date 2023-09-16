package dev.yaaum.presentation.core.ui.splash

import android.animation.Animator
import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.content.Context
import android.view.View
import android.view.ViewAnimationUtils
import android.view.animation.DecelerateInterpolator
import androidx.core.animation.doOnEnd
import androidx.core.splashscreen.SplashScreenViewProvider

/**
 * Specify exit animation for Splash API screen.
 *
 * @receiver Context
 * @receiver SplashScreenViewProvider
 *
 * @param animationDuration exit animation duration
 * @param alphaStart start alpha value for logo
 * @param alphaEnd end alpha value for logo
 */
context(Context)
fun SplashScreenViewProvider.exitAnimation(
    animationDuration: Long = 500L,
    alphaStart: Float = 1f,
    alphaEnd: Float = 0f,
) {
    //region Animate alpha
    val alphaAnimation = ObjectAnimator.ofFloat(
        iconView,
        View.ALPHA,
        alphaStart,
        alphaEnd,
    ).apply {
        interpolator = DecelerateInterpolator()
        duration = animationDuration
    }
    //endregion Animate alpha
    //region Circular reveal
    val centerX = this@exitAnimation.view.width / 2
    val centerY = this@exitAnimation.view.height / 2
    val startRadius = if (view.height > view.width) {
        view.height.toFloat()
    } else {
        view.width.toFloat()
    }
    val circularReveal: Animator =
        ViewAnimationUtils.createCircularReveal(view, centerX, centerY, startRadius, 0f).apply {
            interpolator = DecelerateInterpolator()
            duration = animationDuration
        }
    //endregion Circular reveal
    AnimatorSet().apply {
        playTogether(
            alphaAnimation,
            circularReveal,
        )
        doOnEnd { remove() }
    }.start()
}
