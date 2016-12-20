package com.kapss.akalkulator;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;


public class ComplementaryAnalysisFragment extends Fragment {

    private MathConvertLibrary mathConvertLibrary;
    private MathSupportLibrary mathSupportLibrary;
    private MathComplementaryLibrary mathComplementaryLibrary;
    private MaterialBetterSpinner systemSelectorForInput;
    public MaterialEditText inputNumberEditText;
    public TextView textViewSign;
    public Button analyzeButton;

    public ComplementaryAnalysisFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Załaduj MathConvertLibrary i MathSupportLibrary
        mathConvertLibrary = new MathConvertLibrary();
        mathSupportLibrary = new MathSupportLibrary();
        mathComplementaryLibrary = new MathComplementaryLibrary();


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_complementary_analysis, container, false);
        fillSystemList(view);
        assignUIElements(view);


        analyzeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String inputNumber = inputNumberEditText.getText().toString();
                String complementaryBase = systemSelectorForInput.getText().toString();

                textViewSign.setText(getSign(inputNumber, complementaryBase));
            }
        });


        return view;
    }

    private void fillSystemList(View view) {

        String[] ITEMS = {"U2", "U8", "U16"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        systemSelectorForInput = (MaterialBetterSpinner) view.findViewById(R.id.systemSelectorForInput);
        systemSelectorForInput.setAdapter(adapter);

    }

    private void assignUIElements(View view) {

        analyzeButton = (Button) view.findViewById(R.id.analyzeButton);
        inputNumberEditText = (MaterialEditText) view.findViewById(R.id.inputNumber);
        systemSelectorForInput = (MaterialBetterSpinner) view.findViewById(R.id.systemSelectorForInput);
        textViewSign = (TextView) view.findViewById(R.id.textViewForSign);


    }

    private String getSign(String inputNumber, String complementaryBase) {

        if(mathComplementaryLibrary.isComplementarySigned(inputNumber, complementaryBase)) return "-";
        else return "+";

    }

}
