package com.kapss.akalkulator;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.roughike.swipeselector.SwipeItem;
import com.roughike.swipeselector.SwipeSelector;


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

        //Konfiguracja selectora dla systemu wejściowego
        //FIXME: To można na pewno napisac ładniej. Napisz to ładniej.
        SwipeSelector swipeSelectorForInput = (SwipeSelector) view.findViewById(R.id.systemSelectorForInput);
        SwipeSelector swipeSelectorForOutput = (SwipeSelector) view.findViewById(R.id.systemSelectorForOutput);
        swipeSelectorForInput.setItems(
                new SwipeItem(0, "System naturalny", "System liczbowy, w którym podstawa jest liczbą całkowitą"),
                new SwipeItem(1, "System uzupełnieniowy", "System liczbowy posiadający nieskonczone rozszerzeie lewostronne"));

        swipeSelectorForOutput.setItems(
                new SwipeItem(0, "System naturalny", "System liczbowy, w którym podstawa jest liczbą całkowitą"),
                new SwipeItem(1, "System uzupełnieniowy", "System liczbowy posiadający nieskonczone rozszerzeie lewostronne"));

        return view;
    }

}
