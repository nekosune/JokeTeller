package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

import java.lang.Object;

/**
 * Created by katsw on 07/03/2016.
 */
public class AdManager {

    public static InterstitialAd mInterstatialAd;
    public static void LoadBanner(Context context,View root)
    {
        AdView mAdView = (AdView) root.findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(context.getString(R.string.AdMobDeviceID))
                .build();
        mAdView.loadAd(adRequest);
    }
    public static void InitInterstatialAd(final MainActivity context,final View button)
    {
        mInterstatialAd= (InterstitialAd) NewInterstatial(context,button);
    }

    public static boolean isPaid()
    {
        return false;
    }
    public static Object NewInterstatial(final MainActivity context, final View button)
    {
        InterstitialAd interstitialAd = new InterstitialAd(context);
        interstitialAd.setAdUnitId(context.getString(R.string.interstatial_ad_unit_id));
        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                button.setEnabled(true);
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                button.setEnabled(true);
            }

            @Override
            public void onAdClosed() {
                MainActivity.MakeJoke(context);
            }
        });
        return interstitialAd;
    }

    public static void showInterstitial(MainActivity context) {
        // Show the ad if it's ready. Otherwise toast and reload the ad.
        if (mInterstatialAd != null && mInterstatialAd.isLoaded()) {
            mInterstatialAd.show();
        } else {
            Toast.makeText(context, "Ad did not load", Toast.LENGTH_SHORT).show();
        }
    }
    public static void loadInterstitial(MainActivity context) {

        AdRequest adRequest = new AdRequest.Builder()
                .setRequestAgent("android_studio:ad_template").addTestDevice(context.getString(R.string.AdMobDeviceID)).build();
        mInterstatialAd.loadAd(adRequest);
    }
}
