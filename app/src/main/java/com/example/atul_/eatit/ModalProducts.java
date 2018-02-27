package com.example.atul_.eatit;

/**
 * Created by atul_ on 27/02/2018.
 */

public class ModalProducts {

    private String productName;
    private String productDesc;
    private int productPrice;
    public ModalProducts(String productName,String productDesc,int productPrice){
        this.productName = productName;
        this.productDesc = productDesc;
        this.productPrice = productPrice;
    }

    public String getProductName(){
        return productName;
    }

    public String getProductDesc(){
        return productDesc;
    }

    public int getProductPrice(){
        return productPrice;
    }
}
