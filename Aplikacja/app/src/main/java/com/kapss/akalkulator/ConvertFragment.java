package com.kapss.akalkulator;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

import java.util.regex.Pattern;


public class ConvertFragment extends Fragment {

    public MathConvertLibrary mathConvertLibrary;
    public MathSupportLibrary mathSupportLibrary;
    public MaterialBetterSpinner systemSelectorForInput;
    public MaterialBetterSpinner systemSelectorForOutput;
    public MaterialEditText inputNumberEditText;
    public MaterialEditText outputNumberEditText;
    public MaterialEditText inputBaseEditText;
    public MaterialEditText outputBaseEditText;
    public Button convertButton;
    public String inputNumber;
    public String inputNumberFullPart;
    public String inputNumberFractalPart;
    public String inputBase;
    public String outputBase;
    public String finalValue;


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

        //Załaduj MathConvertLibrary i MathSupportLibrary
        mathConvertLibrary = new MathConvertLibrary();
        mathSupportLibrary = new MathSupportLibrary();


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_convert, container, false);

        //Konfiguracja rozwijanych list
        fillSystemList(view);

        //Przypisanie elementow UI do zmiennych
        assignUIElements(view);

        //Konfiguracja przycisku
        //Kliknięcie pobiera wartość podanej liczby, startuje parser, a następnie konwersję
        //Zawiera onclick listener, który w zalezności od wyboru uzytkownika wybiera poprawny algorytm konwersji
        //Znaczy, nie wiem czy wybiera, ale powinien
        convertButton = (Button) view.findViewById(R.id.convertButton);
        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Wczytaj dane podane przez użytkownika w interfejsie
                String selectedInputSystem = systemSelectorForInput.getText().toString();
                String selectedOutputSystem = systemSelectorForOutput.getText().toString();
                inputBase = inputBaseEditText.getText().toString();
                outputBase = outputBaseEditText.getText().toString();
                inputNumber = inputNumberEditText.getText().toString();

                //Jeżeli liczba jest poprawna wystartuj parser, konwersję itd
                //Na końcu przypisz wartość finalną do elementu UI
                if(mathSupportLibrary.containsIllegalCharactersInSelectedBase(inputNumber, inputBase)) {
                    inputNumberEditText.setError("Błąd");
                } else {
                    parseInputNumber(inputNumber);
                    finalValue = selectConversion(selectedInputSystem, selectedOutputSystem);
                    outputNumberEditText.setText(finalValue);
                }



            }
        });


        return view;
    }

    //Funkcja wrzuca dane z array'a przez arrayadapter
    //do spinnera który zawiera listę systemów liczbowych
    public void fillSystemList(View view) {

        String[] ITEMS = {"System Naturalny", "System Uzupełnieniowy"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, ITEMS);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        systemSelectorForInput = (MaterialBetterSpinner) view.findViewById(R.id.systemSelectorForInput);
        systemSelectorForInput.setAdapter(adapter);
        systemSelectorForOutput = (MaterialBetterSpinner) view.findViewById(R.id.systemSelectorForOutput);
        systemSelectorForOutput.setAdapter(adapter);

    }

    public void assignUIElements(View view) {

        inputNumberEditText = (MaterialEditText) view.findViewById(R.id.inputNumber);
        outputNumberEditText = (MaterialEditText) view.findViewById(R.id.outputNumber);
        systemSelectorForInput = (MaterialBetterSpinner) view.findViewById(R.id.systemSelectorForInput);
        systemSelectorForOutput = (MaterialBetterSpinner) view.findViewById(R.id.systemSelectorForOutput);
        inputBaseEditText = (MaterialEditText) view.findViewById(R.id.inputBase);
        outputBaseEditText = (MaterialEditText) view.findViewById(R.id.outputBase);


    }


    //Sprawdza czy liczba ma część ułamkową
    //Jeżeli nie przypisuje jej część ułamkową jako 0
    //Jeżeli tak to rozbija ją na dwa stringi
    public void parseInputNumber(String inputNumber) {
        if (inputNumber.contains(".")) {

            String[] splitter = inputNumber.split(Pattern.quote("."));
            inputNumberFullPart = splitter[0];
            inputNumberFractalPart = splitter[1];

        } else if (inputNumber.contains(",")) {

            String[] splitter = inputNumber.split(Pattern.quote(","));
            inputNumberFullPart = splitter[0];
            inputNumberFractalPart = splitter[1];

        } else {
            inputNumberFractalPart = "0";
            inputNumberFullPart = inputNumber;
        }


    }


    //Funkcja wywołuje odpowiedni algorytm konwersji, zależnie od wybranych systemów
    //Zwraca końcową wartość liczby
    public String selectConversion(String selectedInputSystem, String selectedOutputSystem) {

        if (selectedInputSystem.equals("System Naturalny") && selectedOutputSystem.equals("System Naturalny")) {
            finalValue = mathConvertLibrary.ConvertFromNaturalToNatural(inputNumberFullPart, inputNumberFractalPart, inputBase,
                    outputBase);
        }


        return finalValue;

    }


}
