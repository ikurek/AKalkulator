package com.kapss.akalkulator;

/**
 * Created by igor on 12.12.16.
 */

public class MathConvertLibrary {

    //Pusty konstruktor
    public MathConvertLibrary () {

    }

    //Funkcja dokonuje konwersji z systemu naturalnego o dowolnej podstawie na inny system naturalny
    public String ConvertFromNaturalToNatural(String inputNumber, String inputBase, String outputBase) {

        /*
        Algorytm:
        1. Wczytaj liczbę wejściową, bazę wejściową i bazę wyjściową
        2. Zamień liczbę wejściową na Int w systemie dziesiętnym
        3. Zamień otrzymany int na string wykorzystując bazę wyjściową
         */
        Integer inputBaseValue = Integer.valueOf(inputBase);
        Integer inputNumberValue = Integer.parseInt(inputNumber, inputBaseValue);
        Integer outputBaseValue = Integer.valueOf(outputBase);
        String outputNumber = Integer.toString(inputNumberValue, outputBaseValue);

        return outputNumber;

    }
}
