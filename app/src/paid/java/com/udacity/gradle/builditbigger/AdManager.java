package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.view.View;


import com.udacity.gradle.builditbigger.MainActivity;

/**
 * Created by katsw on 07/03/2016.
 */
public class AdManager {

    public static void LoadBanner(Context  context,View root)
    {
    }
    public static void InitInterstatialAd(final MainActivity context,final View button)
    {
    }

    public static Object NewInterstatial(final MainActivity context, final View button)
    {
        return null;
    }

    public static boolean isPaid()
    {
        return true;
    }
    public static void showInterstitial(MainActivity context) {
        MainActivity.MakeJoke(context);
    }
    public static void loadInterstitial(MainActivity context) {

    }
}
