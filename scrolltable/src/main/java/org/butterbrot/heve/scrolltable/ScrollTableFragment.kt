package org.butterbrot.heve.scrolltable

import android.content.Context
import android.content.res.TypedArray
import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class ScrollTableFragment : Fragment() {
    private lateinit var scrollTable: ScrollTable
    private var typedArray: TypedArray? = null
    private var autoPopulate: Boolean = true

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        scrollTable = inflater?.inflate(R.layout.scrolltable, container, false) as ScrollTable
        if (typedArray != null) {
            autoPopulate = typedArray!!.getBoolean(R.styleable.ScrollTable_scrollTable_autoPopulate, true)
            scrollTable.properties = ScrollTableProperties(typedArray!!)
            typedArray?.recycle()
        }
        return scrollTable
    }

    override fun onInflate(context: Context?, attrs: AttributeSet?, savedInstanceState: Bundle?) {
        super.onInflate(context, attrs, savedInstanceState)
        if (context != null) {
            typedArray = context.obtainStyledAttributes(attrs, R.styleable.ScrollTable, 0, 0)
        }
    }

    override fun onResume() {
        super.onResume()
        if (autoPopulate) {
            scrollTable.removeAllViews()
            scrollTable.populate()
        }
    }
}