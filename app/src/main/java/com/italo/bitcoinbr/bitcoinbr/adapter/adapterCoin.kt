package com.italo.bitcoinbr.bitcoinbr.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.os.Parcel
import android.os.Parcelable
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import butterknife.Bind
import com.italo.bitcoinbr.bitcoinbr.R
import com.italo.bitcoinbr.bitcoinbr.models.Coins
import kotlinx.android.synthetic.main.item_coin.view.*

@SuppressLint("ParcelCreator")
abstract
/**
 * Created by italo.josep on 10/04/2018.
 */

class adapterCoin(listCoin: List<Coins>,
                  context : Context) : RecyclerView.Adapter<adapterCoin.ViewHolder>(), Parcelable {

    private var listCoin = listCoin
    private val context = context

    override fun getItemCount(): Int {
        return listCoin.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

     fun getItem(position: Int): Coins {
        return listCoin[position]
    }

    fun setListCoin(listCoin : List<Coins>){
        this.listCoin = listCoin
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        val inflate = LayoutInflater.from(context).inflate(R.layout.item_coin, parent, false)
        return ViewHolder(inflate)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {

        val coin = listCoin[position]

        if (holder != null) {
            holder.nameCoin.text = coin.name
            holder.position.text = coin.rank
        }

    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val position = itemView.position_coin
        val nameCoin = itemView.name_coin

    }




}