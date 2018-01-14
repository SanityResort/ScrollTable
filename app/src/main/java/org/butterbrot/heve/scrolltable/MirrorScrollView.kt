package org.butterbrot.heve.scrolltable

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.widget.ScrollView

class MirrorScrollView @JvmOverloads
    constructor(context: Context, attributeSet: AttributeSet? = null, defStyleAttr: Int = 0, defStyleRes: Int = 0) :
        ScrollView(context, attributeSet, defStyleAttr, defStyleRes) {

    private lateinit var mirrors: List<ScrollView>
    private var mirrorIds: List<Int>

    init {
        val typedArray: TypedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MirrorScrollView, 0, 0)

        mirrorIds = typedArray.getString(R.styleable.MirrorScrollView_mirror_vertical).split(",").map {
            resources.getIdentifier(it.trim(), "id", context.packageName)
        }

        typedArray.recycle()
    }

    override fun onScrollChanged(l: Int, t: Int, oldl: Int, oldt: Int) {
        mirrors.forEach{it.scrollTo(0, t)}
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        mirrors = mirrorIds.map {  rootView.findViewById<ScrollView>(it)}
    }


}