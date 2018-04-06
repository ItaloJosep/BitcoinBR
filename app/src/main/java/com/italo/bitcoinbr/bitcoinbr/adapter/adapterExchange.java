package com.italo.bitcoinbr.bitcoinbr.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.italo.bitcoinbr.bitcoinbr.R;
import com.italo.bitcoinbr.bitcoinbr.models.ItemTickerList;
import com.italo.bitcoinbr.bitcoinbr.models.Value;
import com.italo.bitcoinbr.bitcoinbr.uteis.Uteis;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by italo.josep on 06/04/2018.
 */

public class adapterExchange extends RecyclerView.Adapter<adapterExchange.ViewHolder> {

    private Context context;
    private List<ItemTickerList> listExchange;

    public adapterExchange(Context context, List<ItemTickerList> listExchange){
        this.context = context;
        this.listExchange = listExchange;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemCount() {
        return listExchange.size();
    }

    public ItemTickerList getItem(int position){
        return listExchange.get(position);
    }

    public void setListExchange(List<ItemTickerList> itemTickerLists){
        listExchange = itemTickerLists;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_exchange, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ItemTickerList item= listExchange.get(position);
        holder.name.setText(item.getExchange());
        holder.valueHigh.setText(Uteis.FormatMoney(item.getHigh()));
        holder.valueLow.setText(Uteis.FormatMoney(item.getLow()));
        holder.valueLast.setText(Uteis.FormatMoney(item.getLast()));
        holder.valueVol.setText(Uteis.FormatVol(item.getVol()));
        holder.valueTrade.setText(item.getTrades());
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

       @Bind(R.id.name_exchange) TextView name;
       @Bind(R.id.value_last) TextView valueLast;
       @Bind(R.id.value_max) TextView valueHigh;
       @Bind(R.id.value_min) TextView valueLow;
       @Bind(R.id.value_vol) TextView valueVol;
       @Bind(R.id.value_trade) TextView valueTrade;

        public ViewHolder(View v) {
            super(v);
            ButterKnife.bind(this, v);
        }

    }

}
