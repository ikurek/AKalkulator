package com.kapss.akalkulator;

/**
 * Created by igor on 12.12.16.
 */

public class MathConvertLibrary {

    //Pusty konstruktor
    public MathConvertLibrary() {

    }


    //Funkcja dokonuje konwersji z systemu naturalnego o dowolnej podstawie na inny system naturalny
    public String ConvertFromNaturalToNatural(String inputNumberFull, String inputNumberFractal, String inputBase, String outputBase) {

        /*
        Algorytm:
        1. Wczytaj liczbę wejściową, bazę wejściową i bazę wyjściową
        2. Zamień część całkowitą liczby wejściowej na Int w systemie dziesiętnym
        3. Zamień część ułamkową liczby wajściowej na Int w systemie dziesiętnym
        3. Zamień otrzymane Int'y na string wykorzystując bazę wyjściową
         */
        Integer inputBaseValue = Integer.valueOf(inputBase);
        Integer outputBaseValue = Integer.valueOf(outputBase);
        Integer inputNumberValue = Integer.parseInt(inputNumberFull, inputBaseValue);
        String fractalValue;
        Double tempFractalValue = 0.0;
        Integer fractalValueAsFullIntNumber;

        //Zamiana standardowym algorytmem
        for (int i = 0; i < inputNumberFractal.length(); i++) {

            Integer currentNumber = Integer.valueOf(inputNumberFractal.charAt(i)) - 48;
            Double currentValue = Math.pow(inputBaseValue, i + 1);
            tempFractalValue = tempFractalValue + currentNumber / currentValue;
            System.out.println(currentNumber + " - " + currentValue + " - " + tempFractalValue);

        }

        //Ucina znaki "0."
        fractalValue = tempFractalValue.toString().substring(2,8);
        fractalValueAsFullIntNumber = Integer.valueOf(fractalValue);


        //TODO: Ucina 0, jeżeli ułamek zaczyna się od 0, np 0,00625
        //FIXME: Popraw to

        String outputNumber = Integer.toString(inputNumberValue, outputBaseValue) + "," + Integer.toString(fractalValueAsFullIntNumber, outputBaseValue);
        return outputNumber;

    }
}
