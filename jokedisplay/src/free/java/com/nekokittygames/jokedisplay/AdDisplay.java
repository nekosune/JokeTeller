package com.nekokittygames.jokedisplay;

import android.content.Context;
import android.view.View;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

/**
 * Created by katsw on 07/03/2016.
 */
public class AdDisplay {

    public static  void DisplayAd(Context context,View root)
    {
        AdView mAdView = (AdView) root.findViewById(R.id.jokeAdView);
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(context.getString(R.string.AdMobDeviceID))
                .build();
       mAdView.loadAd(adRequest);
    }
}
