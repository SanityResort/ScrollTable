package org.butterbrot.heve.scrolltable

import android.content.res.TypedArray
import android.graphics.Color

class ScrollTableProperties(typedArray: TypedArray) {
    var northRows: Int = 0
    var southRows: Int = 0
    var westColumns: Int = 0
    var eastColumns: Int = 0
    var northRowsGap: Int = 0
    var southRowsGap: Int = 0
    var westColumnsGap: Int = 0
    var eastColumnsGap: Int = 0
    var borderColor: Int = 0
    var northCellBorder: Int = 0
    var southCellBorder: Int = 0
    var westCellBorder: Int = 0
    var eastCellBorder: Int = 0
    var shrinkNorth: Boolean = false
    var shrinkSouth: Boolean = false
    var shrinkWest: Boolean = false
    var shrinkEast: Boolean = false
    var background: Int = 0

    init {
        northRows = typedArray.getInt(R.styleable.ScrollTable_scrollTable_northRows, 0)
        southRows = typedArray.getInt(R.styleable.ScrollTable_scrollTable_southRows, 0)
        westColumns = typedArray.getInt(R.styleable.ScrollTable_scrollTable_westColumns, 0)
        eastColumns = typedArray.getInt(R.styleable.ScrollTable_scrollTable_eastColumns, 0)

        val shrinkMask = typedArray.getInt(R.styleable.ScrollTable_scrollTable_shrink, 0)
        shrinkNorth = ScrollTable.SHRINK_NORTH and shrinkMask != 0
        shrinkSouth = ScrollTable.SHRINK_SOUTH and shrinkMask != 0
        shrinkWest = ScrollTable.SHRINK_WEST and shrinkMask != 0
        shrinkEast = ScrollTable.SHRINK_EAST and shrinkMask != 0

        northCellBorder = typedArray.getInt(R.styleable.ScrollTable_scrollTable_northCellBorder, 0)
        southCellBorder = typedArray.getInt(R.styleable.ScrollTable_scrollTable_southCellBorder, 0)
        westCellBorder = typedArray.getInt(R.styleable.ScrollTable_scrollTable_westCellBorder, 0)
        eastCellBorder = typedArray.getInt(R.styleable.ScrollTable_scrollTable_eastCellBorder, 0)

        borderColor = typedArray.getColor(R.styleable.ScrollTable_scrollTable_borderColor, Color.TRANSPARENT)

        northRowsGap = typedArray.getInt(R.styleable.ScrollTable_scrollTable_northRowsGap, 0)
        southRowsGap = typedArray.getInt(R.styleable.ScrollTable_scrollTable_southRowsGap, 0)
        westColumnsGap = typedArray.getInt(R.styleable.ScrollTable_scrollTable_westColumnsGap, 0)
        eastColumnsGap = typedArray.getInt(R.styleable.ScrollTable_scrollTable_eastColumnsGap, 0)

        background = typedArray.getColor(R.styleable.ScrollTable_scrollTable_gapColor, Color.TRANSPARENT)
    }
}