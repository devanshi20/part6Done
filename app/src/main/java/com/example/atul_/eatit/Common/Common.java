package com.example.atul_.eatit.Common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkInfo;

import com.example.atul_.eatit.model.User;

/**
 * Created by Admin on 13-Jan-18.
 */

public class Common {
    public static User currentUser;

    public static final String USER_KEY="User";
    public static final String PWD="Password";

    public static String codeConversion(String status) {
        {
            if (status.equals("0"))
                return "Placed";
            else if(status.equals("1"))
                return "On The Way";
            else
                return "Shipped";
        }
    }
}
