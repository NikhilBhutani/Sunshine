package com.github.nikhilbhutani.sunshine.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.github.nikhilbhutani.sunshine.R;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Nikhil Bhutani on 8/1/2016.
 */
public class ForecastFragment extends Fragment {

    public ForecastFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_main, container, false);

        String[] forecaseArray = {

                "Today - Sunny - 88/63",
                "Tomorrow - Foggy - 70/40",
                "Weds - Sunny - 72/63",
                "Thurs - Asteroids - 75/65",
                "Fri - Heavy Rain - 75/56",
                "Sat - HELP TRAPED IN WEATHER STATION - 60/51",
                "Sun - Sunny - 80/68"

        };

        ArrayList<String> myweekForecase = new ArrayList<String>(
                Arrays.asList(forecaseArray));


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.list_item_forecast, R.id.list_item_forecast_textview, myweekForecase);

        ListView listView = (ListView) view.findViewById(R.id.listview_forecast);

        listView.setAdapter(arrayAdapter);




        return view;

    }
}
