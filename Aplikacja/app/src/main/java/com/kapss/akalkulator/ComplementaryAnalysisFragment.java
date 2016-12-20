package com.kapss.akalkulator;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


public class ComplementaryAnalysisFragment extends Fragment {

    private MathConvertLibrary mathConvertLibrary;
    private MathSupportLibrary mathSupportLibrary;
    private MaterialBetterSpinner systemSelectorForInput;
    public MaterialEditText inputNumber;

    public ComplementaryAnalysisFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Załaduj MathConvertLibrary i MathSupportLibrary
        mathConvertLibrary = new MathConvertLibrary();
        mathSupportLibrary = new MathSupportLibrary();


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_complementary_analysis, container, false);

        fillSystemList(view);


        return view;
    }

    private void fillSystemList(View view) {

        String[] ITEMS = {"U2", "U8", "U16"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        systemSelectorForInput = (MaterialBetterSpinner) view.findViewById(R.id.systemSelectorForInput);
        systemSelectorForInput.setAdapter(adapter);

    }

}
