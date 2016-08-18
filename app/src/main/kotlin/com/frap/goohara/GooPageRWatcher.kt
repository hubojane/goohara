package com.frap.goohara

import android.support.v4.view.ViewPager

fun ViewPager.addPageChangListener(init: GooPagerWatcher.() -> Unit) {
    addOnPageChangeListener(GooPagerWatcher().apply(init))
}

class GooPagerWatcher: ViewPager.OnPageChangeListener {
    private var mScrollChangedAction: (() -> Unit)? = null
    private var mScrolledAction: (() -> Unit)? = null
    private var mSelectedAction: (() -> Unit)? = null

    var scrollChanged: ScrollChanged = ScrollChanged(0)
    var scrolled: Scrolled = Scrolled(0, 0.toFloat(), 0)
    var selected: Selected = Selected(0)

    override fun onPageScrollStateChanged(_state: Int) {
        scrollChanged.state = _state
        mScrollChangedAction?.invoke()
    }

    override fun onPageScrolled(_position: Int, _positionOffset: Float, _positionOffsetPixels: Int) {
        scrolled.run {
            position = _position
            positionOffset = _positionOffset
            positionOffsetPixels = _positionOffsetPixels
        }
        mScrolledAction?.invoke()
    }

    override fun onPageSelected(_position: Int) {
        selected.position = _position
        mSelectedAction?.invoke()
    }

    fun onPageScrollStateChanged(action: () -> Unit) {
        mScrollChangedAction = action
    }

    fun onPageScrolled(action: () -> Unit) {
        mScrolledAction = action
    }

    fun onPageSelected(action: () -> Unit) {
        mSelectedAction = action
    }

    inner class ScrollChanged(var state: Int)
    inner class Scrolled(var position: Int, var positionOffset: Float, var positionOffsetPixels: Int)
    inner class Selected(var position: Int)
}