package com.psrapps.www.press_ldemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by poornashekarreddy.p on 10-09-2017.
 */

public class Holderc extends RecyclerView.ViewHolder {
    private TextView category;
    private TextView quotes;
    public Holderc(View itemView) {
        super(itemView);
        this.category=(TextView)itemView.findViewById(R.id.cat);
        this.quotes=(TextView)itemView.findViewById(R.id.quote);
    }
    public void UpdateUI(Modelc quote)
    {
        category.setText(quote.getCategory());
        quotes.setText(quote.getQuote());
    }
}
