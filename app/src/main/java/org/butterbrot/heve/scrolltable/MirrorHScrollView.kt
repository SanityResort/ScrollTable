package org.butterbrot.heve.scrolltable

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.HorizontalScrollView


class MirrorHScrollView @JvmOverloads
    constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) :
        HorizontalScrollView(context, attributeSet, defStyleAttr, defStyleRes) {

    private lateinit var mirrors: List<HorizontalScrollView>
    private var mirrorIds: List<Int>

    init {
        val typedArray: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MirrorHScrollView, 0, 0)

        mirrorIds = typedArray.getString(R.styleable.MirrorHScrollView_mirror_horizontal).split(",").map {
            resources.getIdentifier(it.trim(), "id", context.packageName)
        }

        typedArray.recycle()
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        mirrors.forEach{it.scrollTo(l, 0)}
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mirrors = mirrorIds.map {  rootView.findViewById<HorizontalScrollView>(it)}

    }
}