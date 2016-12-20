package com.kapss.akalkulator;

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
        Integer baseValue = Integer.valueOf(complementaryBase.substring(1));
        Integer firstDigit = Integer.valueOf(inputNumber.charAt(0));

        return (baseValue/2 - 1 >= firstDigit);

    }
}
