package com.tistory.comfy91.excuseme_android.feature.helper_sort

import android.content.Context
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView


/**
 * Using in HelperSortActivity
 * For Drag & Drop
 */
class DragManageAdapter (adapter: RvHelperSortAdapter, context: Context, dragDirs: Int, swipeDirs: Int)
    : ItemTouchHelper.Callback(){

    var cardAdapter = adapter

    override fun onMove(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder,
        target: RecyclerView.ViewHolder
    ): Boolean {
        cardAdapter.swapItems(viewHolder.adapterPosition, target.adapterPosition)
        return true
    } // end onMove()

    override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
        // 사용안함
    }

    override fun getMovementFlags(
        recyclerView: RecyclerView,
        viewHolder: RecyclerView.ViewHolder
    ): Int {
        val dragFlags: Int = ((ItemTouchHelper.UP.or(ItemTouchHelper.DOWN)).or(ItemTouchHelper.LEFT)).or(ItemTouchHelper.RIGHT)
        val swipeFlags = 0
        return makeMovementFlags(dragFlags,swipeFlags)
    }
} // end class