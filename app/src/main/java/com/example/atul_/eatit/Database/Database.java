package com.example.atul_.eatit.Database;


import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.os.Bundle;

import com.example.atul_.eatit.model.Order;
import com.google.firebase.database.ValueEventListener;
import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;


import java.util.ArrayList;
import java.util.List;

import static android.R.attr.name;

/**
 * Created by atul_ on 31/01/2018.
 */




public class Database {


    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME ="EatIt.db";
    static SQLiteDatabase db;



     public static void createTable(SQLiteDatabase d)
     {
         db=d;
         db.execSQL("CREATE TABLE IF NOT EXISTS OrderDetail(`ProductId`\tINTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE,\n" +
                 "\t`ProductName`\tTEXT,\n" +
                 "\t`Price`\tINTEGER,\n" +
                 "\t`Quantity`\tINTEGER,\n" +
                 "\t`Discount`\tINTEGER);");
     }
    //Create Table Query










    public List<Order>getCarts()
    {


        try{
            db=SQLiteDatabase.openDatabase("EatIt.db",null,Context.MODE_PRIVATE);
          // String path ="D:\EatIt.db" + DATABASE_NAME;
          //  SQLiteDatabase checkDB = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READONLY);
            //System.out.println(checkDB);
        } catch(SQLiteException e){
            System.out.println("Exception");
        }


            //SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder qb = new SQLiteQueryBuilder();

        String[] sqlSelect={"ProductID,ProductNAME,Quantity,Price,Discount"};
        String sqlTable="OrderDetail";

        qb.setTables(sqlTable);

        Cursor c = qb.query(db,sqlSelect,null,null,null,null,null);
        final List<Order>result = new ArrayList<>();
        if(c.moveToFirst())
        {
            do{
                result.add(new Order(c.getString(c.getColumnIndex("ProductID")),
                c.getString(c.getColumnIndex("ProductNAME")),
                c.getString(c.getColumnIndex("Quantity")),
                c.getString(c.getColumnIndex("Price")),
                c.getString(c.getColumnIndex("Discount"))
                        ));

            }while(c.moveToNext());
        }
        return result;
    }




    public void addToCart(Order order1) {
        //SQLiteDatabase db = getWritableDatabase();
        String query = String.format("INSERT INTO OrderDetail(ProductID,ProductNAME,Price,Quantity,Discount) VALUES('%s','%s','%s','%s','%s');",



                order1.getProductID(),
                order1.getProductNAME(),
                order1.getQuantity(),
                order1.getPrice(),
                order1.getDiscount());
        db.execSQL(query);

    }

    public void cleanCart() {
        SQLiteDatabase db = getReadableDatabase();
        String query = String.format("DELETE FROM OrderDetail");


        db.execSQL(query);

    }






}
