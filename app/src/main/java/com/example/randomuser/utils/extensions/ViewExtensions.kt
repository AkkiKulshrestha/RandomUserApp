package com.example.randomuser.utils.extensions

import android.transition.Fade
import android.transition.TransitionManager
import android.transition.TransitionSet
import android.view.View
import android.view.ViewGroup
import com.example.randomuser.utils.transition.Scale

fun View.visible() {
    if (!isVisible()) visibility = View.VISIBLE
}

fun View.invisible() {
    if (!isInvisible()) visibility = View.INVISIBLE
}

fun View.gone() {
    if (!isGone()) visibility = View.GONE
}

fun View.isVisible(): Boolean {
    return visibility == View.VISIBLE
}

fun View.isInvisible(): Boolean {
    return visibility == View.INVISIBLE
}

fun View.isGone(): Boolean {
    return visibility == View.GONE
}

fun View.visibleWithScaleFade(
    parent: ViewGroup,
    duration: Long = 300,
    minScale: Float = 0.8F,
    direction: Scale.Direction? = null,
    pivotX: Float = 0F,
    pivotY: Float = 0F
) {
    val transitionSet = TransitionSet().apply {
        addTransition(
            Scale(
                minScale = minScale,
                direction = direction,
                pivotX = pivotX,
                pivotY = pivotY
            )
        )
        addTransition(Fade())
        this.duration = duration
        addTarget(this@visibleWithScaleFade)
    }
    TransitionManager.beginDelayedTransition(parent, transitionSet)
    visible()
}

fun View.goneWithScaleFade(
    parent: ViewGroup,
    duration: Long = 300,
    minScale: Float = 0.8F,
    direction: Scale.Direction? = null,
    pivotX: Float = 0F,
    pivotY: Float = 0F
) {
    val transitionSet = TransitionSet().apply {
        addTransition(
            Scale(
                minScale = minScale,
                direction = direction,
                pivotX = pivotX,
                pivotY = pivotY
            )
        )
        addTransition(Fade())
        this.duration = duration
        addTarget(this@goneWithScaleFade)
    }
    TransitionManager.beginDelayedTransition(parent, transitionSet)
    gone()
}