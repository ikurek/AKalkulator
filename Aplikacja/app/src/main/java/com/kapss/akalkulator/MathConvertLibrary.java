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
        String fractalValue = "";
        Integer currentFractalValue = 0;

        for (int i = 0; i < inputNumberFractal.length(); i++) {

            currentFractalValue = Integer.valueOf(inputNumberFractal.charAt(i)) / (inputBaseValue) ^ (i + 1);
            fractalValue = fractalValue + currentFractalValue.toString();

        }


        String outputNumber = Integer.toString(inputNumberValue, outputBaseValue) + "," + Integer.toString(currentFractalValue, outputBaseValue);
        return outputNumber;

    }
}
