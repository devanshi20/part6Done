package com.example.atul_.eatit;

import java.util.ArrayList;

/**
 * Created by atul_ on 27/02/2018.
 */

public class ModelCart {
    private ArrayList<ModalProducts> cartItems = new ArrayList<ModalProducts>();
    public ModalProducts getProducts(int position){
        return cartItems.get(position);
    }
    public void setProducts(ModalProducts Products){
        cartItems.add(Products);
    }
    public int getCartsize(){

        return cartItems.size();
    }
    public boolean CheckProductInCart(ModalProducts aproduct){
        return cartItems.contains(aproduct);
    }
}

