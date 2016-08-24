package com.frap.goohara

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View

fun RecyclerView.setOnItemClickListener(recyclerView: RecyclerView,
                                        init: GooRecyclerItemClickListener.() -> Unit) {
    addOnItemTouchListener(RecyclerItemClickListener(
            context, recyclerView, GooRecyclerItemClickListener().apply(init)))
}

class GooRecyclerItemClickListener : RecyclerItemClickListener.OnItemClickListener {
    private var mClickListener: ((View, Int) -> Unit)? = null
    private var mLongClickListener: ((View, Int) -> Unit)? = null

    override fun onItemClick(view: View, position: Int) {
        mClickListener?.invoke(view, position)
    }

    override fun onItemLongClick(view: View, position: Int) {
        mLongClickListener?.invoke(view, position)
    }

    fun onItemClick(listener: (View, Int) -> Unit) {
        mClickListener = listener
    }

    fun onItemLongClick(listener: (View, Int) -> Unit) {
        mLongClickListener = listener
    }
}

private class RecyclerItemClickListener(
        context: Context, recyclerView: RecyclerView, private val mListener: OnItemClickListener?) :
        RecyclerView.OnItemTouchListener {
    interface OnItemClickListener {
        fun onItemClick(view: View, position: Int)
        fun onItemLongClick(view: View, position: Int)
    }

    private val mGestureDetector: GestureDetector

    init {
        mGestureDetector = GestureDetector(context, object : GestureDetector.SimpleOnGestureListener() {
            override fun onSingleTapUp(e: MotionEvent): Boolean {
                return true
            }

            override fun onLongPress(e: MotionEvent) {
                val childView = recyclerView.findChildViewUnder(e.x, e.y)

                if (childView != null && mListener != null) {
                    mListener.onItemLongClick(childView, recyclerView.getChildAdapterPosition(childView))
                }
            }
        })
    }

    override fun onInterceptTouchEvent(view: RecyclerView, e: MotionEvent): Boolean {
        val childView = view.findChildViewUnder(e.x, e.y)

        if (childView != null && mListener != null && mGestureDetector.onTouchEvent(e)) {
            mListener.onItemClick(childView, view.getChildAdapterPosition(childView))
        }

        return false
    }

    override fun onTouchEvent(view: RecyclerView, motionEvent: MotionEvent) {
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
    }
}