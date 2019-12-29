package com.tistory.comfy91.excuseme_android.feature.disabled

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.tistory.comfy91.excuseme_android.DetailCardActivity
import com.tistory.comfy91.excuseme_android.R
import com.tistory.comfy91.excuseme_android.setOnSingleClickListener


class CardAdapter(
//    private val arrData: ArrayList<ItemCard>,
//    private val listener: CardViewHolder.ItemClickListener
) :
    RecyclerView.Adapter<CardAdapter.CardViewHolder>(), Filterable {


    var data = arrayListOf<ItemCard>()
    var searchedList: ArrayList<ItemCard>? = null

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = CardViewHolder(parent)

    override fun getItemCount(): Int {
        return searchedList!!.size
    }

    override fun onBindViewHolder(holder: CardViewHolder, position: Int) {
//        holder.bind(data.get(position))
        holder.bind(searchedList!!.get(position))
    }


    // init

    init {
        this.searchedList = data
    }

    //for filter
    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val charString = charSequence.toString()
                if (charString.isEmpty()) {
                    searchedList = data
                } else {
                    val filteredList = ArrayList<ItemCard>()
                    //원하는 데이터를 검색
                    for (row in data) {

                        Log.d("zzzz", "search data :  " + row.title.toLowerCase())
                        Log.d("zzzz", "input data " + charString.toLowerCase())
                        if (row.title.toLowerCase().contains(charString.toLowerCase())) {
                            Log.d("zzzz", "addddd ")
                            filteredList.add(row)
                        }
                    }
                    searchedList = filteredList
                }
                val filterResults = FilterResults()
                filterResults.values = searchedList
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                Log.d("zzzz", "zzzz ")
                searchedList = filterResults.values as ArrayList<ItemCard>
                notifyDataSetChanged()
            }
        }
    }

    inner class CardViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_card, parent, false)
    ) {
        private val imgCard: ImageView = itemView.findViewById(R.id.imgCard)
        private val tvCardTitle: TextView = itemView.findViewById(R.id.tvCardTitle)

        init {
            itemView.setOnClickListener {
                //nullable이면 오류가 발생
//                listener.onItemClicked(searchedList!![adapterPosition])
            }
        }

        fun bind(data: ItemCard) {
            Glide.with(itemView).load(data.imageUrl).into(imgCard)
            tvCardTitle.text = data.title

            itemView.setOnSingleClickListener {
                val intent = Intent(itemView.context, DetailCardActivity::class.java)
                intent.putParcelableArrayListExtra("DATA_CARD", arrayListOf(data))
                itemView.context.startActivity(intent)
            }
        }
    }

    interface ItemClickListener {
        fun onItemClicked(itemCard: ItemCard)
    }

}