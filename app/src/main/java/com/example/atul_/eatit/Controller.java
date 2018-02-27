package com.example.atul_.eatit;

import android.app.Application;

import java.util.ArrayList;

/**
 * Created by atul_ on 27/02/2018.
 */

public class Controller extends Application {

    private ArrayList<ModalProducts> myproducts = new ArrayList<ModalProducts>();
    private ModelCart myCart = new ModelCart();
    public ModalProducts getProducts(int pPosition){
        return myproducts.get(pPosition);
    }
    public void  setProducts(ModalProducts products){
        myproducts.add(products);
    }
    public ModelCart getCart(){
        return myCart;
    }
    public int  getProductArraylistsize(){
        return myproducts.size();
    }
}

