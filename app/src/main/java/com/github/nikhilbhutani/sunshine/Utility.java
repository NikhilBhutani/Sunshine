package com.github.nikhilbhutani.sunshine;

import android.content.Context;
import android.content.SharedPreferences;
import android.icu.text.DateFormat;
import android.os.Build;
import android.preference.PreferenceManager;

import java.util.Date;

/**
 * Created by Nikhil Bhutani on 8/9/2016.
 */
public class Utility {

    public static String getPreferredLocation(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(context.getString(R.string.pref_location_key),
                context.getString(R.string.pref_location_default));
    }

    public static boolean isMetric(Context context) {
       /*
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);
        return prefs.getString(context.getString(R.string.pref_units_key),
                context.getString(R.string.pref_units_key_metric))
                .equals(context.getString(R.string.pref_units_key_metric));
                */
        return true;
    }


    static String formatTemperature(double temperature, boolean isMetric) {
        double temp;
        if ( !isMetric ) {
            temp = 9*temperature/5+32;
        } else {
            temp = temperature;
        }
        return String.format("%.0f", temp);
    }

    static String formatDate(long dateInMillis) {
        Date date = new Date(dateInMillis);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return DateFormat.getDateInstance().format(date);
        }
        return DateFormat.getDateInstance().format(date);
    }
}
