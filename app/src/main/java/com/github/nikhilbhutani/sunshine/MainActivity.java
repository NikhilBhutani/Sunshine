package com.github.nikhilbhutani.sunshine;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            getSupportFragmentManager()
                    .beginTransaction()
                    .add(R.id.container, new PlaceHolderFragemnt())
                    .commit();
        }

    }

    public static class PlaceHolderFragemnt extends Fragment{

        public PlaceHolderFragemnt(){

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
                    Arrays.asList(forecaseArray)            );


            ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(),
                    R.layout.list_item_forecast,R.id.list_item_forecast_textview,myweekForecase);

            ListView listView = (ListView)view.findViewById(R.id.listview_forecast);

            listView.setAdapter(arrayAdapter);

            return view;
        }

    }
}
