package com.kapss.akalkulator;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


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

        //Konfiguracja rozwijanych list
        fillSystemList(view);

        return view;
    }

    //Funkcja wrzuca dane z array'a przez arrayadapter
    //do spinnera który zawiera listę systemów liczbowych
    public void fillSystemList(View view) {

        String[] ITEMS = {"System Naturalny", "System Uzupełnieniowy", "Kod z Obciążeniem"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        MaterialBetterSpinner systemSelectorForInput = (MaterialBetterSpinner) view.findViewById(R.id.systemSelectorForInput);
        systemSelectorForInput.setAdapter(adapter);
        MaterialBetterSpinner systemSelectorForOutput = (MaterialBetterSpinner) view.findViewById(R.id.systemSelectorForOutput);
        systemSelectorForOutput.setAdapter(adapter);

    }

}
