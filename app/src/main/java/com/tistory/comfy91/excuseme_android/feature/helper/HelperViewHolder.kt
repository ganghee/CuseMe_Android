package com.tistory.comfy91.excuseme_android.feature.helper

import android.os.Handler
import android.util.Log
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
//import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tistory.comfy91.excuseme_android.R
import com.tistory.comfy91.excuseme_android.data.CardBean
import com.tistory.comfy91.excuseme_android.data.DataHelperCard
import com.tistory.comfy91.excuseme_android.feature.disabled.CardAdapter

class HelperViewHolder(itemView: View, private val onClicked: (Boolean, String) -> Unit): RecyclerView.ViewHolder(itemView){
    private val panel: ConstraintLayout = itemView.findViewById(com.tistory.comfy91.excuseme_android.R.id.panel)
    private val imgCard: ImageView = itemView.findViewById(R.id.imgHelperCard)
    private val tvCard: TextView = itemView.findViewById(R.id.tvHelperCard)

    lateinit var dataVisibilityChange: ()-> Unit

    fun bind(data: CardBean, listenerFlag: Int){
        Glide.with(itemView).load(data.imageUrl).into(imgCard)
        tvCard.text = data.title
        itemView.setOnClickListener {
            while (it.isSelected){
                it.isSelected = false
            }
            //panel.isSelected = !panel.isSelected
            //panel.isSelected = false
            tvCard.text = data.title
            it.isSelected = !it.isSelected
            onClicked(it.isSelected, data.desc)
        }

       /* itemView.setOnCardSingleClickListener {
            panel.isSelected = !panel.isSelected
            Handler().postDelayed(Runnable {
                panel.isSelected = false
            }, CardAdapter.CARD_DELAY_CLICK_TIME)
        }*/


       /* when(listenerFlag){
            HELPER_SORT_ACTIVITY -> itemView.setOnSingleClickListener{clicked()}
            SELECT_SORT_FRAGMENT -> {
                //ctvCheck.setOnSingleClickListener{clicked()}
                itemView.setOnSingleClickListener{itemView.context.newStartActivity(
                    DetailCardActivity::class.java)}
            }
        }*/
    }

    private fun clicked(){
        dataVisibilityChange() // 데이터 변경
        //onClicked(data.desc)
    }

    fun View.setOnCardSingleClickListener(debounceTime: Long = CardAdapter.CARD_DELAY_CLICK_TIME, action: ()->Unit){
        this.setOnClickListener (object: View.OnClickListener{

            override fun onClick(p0: View?) {
                if((System.currentTimeMillis() - CardAdapter.CARD_LAST_CLICK_TIME) < debounceTime){
                    Log.d("Single Click", "연속 클릭 발생")
                }else {
                    Log.d("Single Click", "action()")
                    action()
                    CardAdapter.CARD_LAST_CLICK_TIME = System.currentTimeMillis()
                }
            }
        })
    }

    companion object{
        const val HELPER_SORT_ACTIVITY = 1
        const val SELECT_SORT_FRAGMENT = 2
    }
}