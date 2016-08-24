package com.frap.goohara

import android.support.v4.view.ViewPager

fun ViewPager.addPagerWatcher(init: GooPagerWatcher.() -> Unit) {
    addOnPageChangeListener(GooPagerWatcher().apply(init))
}

class GooPagerWatcher : ViewPager.OnPageChangeListener {
    private var mScrollChangedListener: ((Int) -> Unit)? = null
    private var mScrolledListener: ((Int, Float, Int) -> Unit)? = null
    private var mSelectedListener: ((Int) -> Unit)? = null

    override fun onPageScrollStateChanged(state: Int) {
        mScrollChangedListener?.invoke(state)
    }

    override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
        mScrolledListener?.invoke(position, positionOffset, positionOffsetPixels)
    }

    override fun onPageSelected(position: Int) {
        mSelectedListener?.invoke(position)
    }

    fun onPageScrollStateChanged(listener: (Int) -> Unit) {
        mScrollChangedListener = listener
    }

    fun onPageScrolled(listener: (Int, Float, Int) -> Unit) {
        mScrolledListener = listener
    }

    fun onPageSelected(listener: (Int) -> Unit) {
        mSelectedListener = listener
    }
}
