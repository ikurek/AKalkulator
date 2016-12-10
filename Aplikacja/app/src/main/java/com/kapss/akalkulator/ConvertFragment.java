package com.kapss.akalkulator;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public class ConvertFragment extends Fragment {


    //Pusty konstruktor
    public ConvertFragment() {

    }


    //Metoda newInstance tworzy nowy fragment
    public static ConvertFragment newInstance() {
        ConvertFragment fragment = new ConvertFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_convert, container, false);
        return view;
    }

}
