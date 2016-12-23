package com.kapss.akalkulator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by igor on 20.12.16.
 */

public class MathComplementaryLibrary {

    //Konstruktorek jak zwykle
    public MathComplementaryLibrary () {

    }

    //Funkcja określa, czy liczba w systemie uzupełnieniowym jest ujemna
    //Przyjmuje liczbę i podstawę w formacie "U" + baza
    //Zwraca true dla liczb ujemnych
    //Zwraca false dla liczb dodatnich
    public Boolean isComplementarySigned(String inputNumber, String complementaryBase){

        //Zbiera wartość bazy i zapisuje jako int
        Double baseValue = Double.valueOf(complementaryBase.substring(1));
        //Zbiera pierwszą cyfrę
        Integer firstDigit = inputNumber.charAt(0) - 48;
        //Oblicz wartość graniczną beta/2 - 1
        Double middlevalue = baseValue/2 - 1;

        //Zwraca porównanie pierwszej cyfry z wartością graniczną
        return (middlevalue < firstDigit);

    }

    //Funkcja oblicza odwrotność addytywną liczby w systemie uzupełniniowym
    //Przyjmuje liczbe w systemie uzupełninowym i podstawę w formacie "U" + baza
    //Zwraca string zawierający moduł liczby
    public String calculateAbsoluteValue(String inputNumber, String complementaryBase) {

        /* Algorym:
        1. Zaneguj wszystkie liczby, odejmując ich wartość od podstawy systemu pomniejszonej o 1
        2. Dodaj 1 do cyfry na najmłodszej pozycji
        3. Jeżeli cyfra na najmłodszej pozycji jest równa podstawie:
            4. Zmień wartość tej cyfry na zero
            5. Wykonaj punkt 2 dla cyfry na pozycji o 1 większej od aktualnej
         */


        Integer baseValue = Integer.valueOf(complementaryBase.substring(1));
        ArrayList <Integer> absoluteNumbers = new ArrayList<>();
        String finalValue = "";

        //Pętla wpisuje negacje kolejnych liczb do tablicy
        for(int i = 0; i < inputNumber.length(); i++) {
            Integer currentNumber = inputNumber.charAt(i) - 48;

            absoluteNumbers.add(i, baseValue - 1 - currentNumber);

        }

        //Pętla powiększa wartość o 1
        //Przechodzi do kolejnej wartości jeżeli poprzednia przekroczy zakres
        Boolean keepIncreasing = true;
        Integer indexToIncrease = absoluteNumbers.size() - 1;

        while (keepIncreasing) {
            if(absoluteNumbers.get(indexToIncrease) + 1 < baseValue) {
                Integer increasedNumber = absoluteNumbers.get(indexToIncrease) + 1;
                absoluteNumbers.set(indexToIncrease, increasedNumber);
                keepIncreasing = false;
            }

        }

        //Pętla zamienia tablicę na String
        for(int i = 0; i < absoluteNumbers.size(); i++) {
           finalValue = finalValue + absoluteNumbers.get(i);
        }

        return finalValue;
    }
}
