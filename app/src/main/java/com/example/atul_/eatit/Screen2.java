package com.example.atul_.eatit;

import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by atul_ on 27/02/2018.
 */

public class Screen2  {

    protected void onCreate(Bundle savedInstanceState) {
// TODO Auto-generated method stub
    ;
        TextView showCartContent = TextView)findViewById(R.id.showcart);
        final Controller ct = (Controller)getApplicationContext();
        final int CartSize = ct.getCart().getCartsize();
        String show = "";
        for(int i=0;i<CartSize;i++){
            String pName = ct.getCart().getProducts(i).getProductName();
            int pPrice = ct.getCart().getProducts(i).getProductPrice();
            String pDisc = ct.getCart().getProducts(i).getProductDesc();
            show += "Product Name:"+pName+" "+"Price : "+pPrice+""+"Discription : "+pDisc+""+    "-----------------------------------";
        }
        showCartContent.setText(show);
    }



}

