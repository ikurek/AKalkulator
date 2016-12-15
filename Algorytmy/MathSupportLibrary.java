package com.kapss.akalkulator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by igor on 14.12.16.
 */

public class MathSupportLibrary {

    //Pusty konstruktor
    public MathSupportLibrary() {


    }

    //Funkcja analizuje wprowadzoy string pod kątem nieprawidłowych znaków
    //Zwraca true, jeżeli znaki nienależące do ststemu liczbowego znalazły się w stringu
    //Zwraca false, jeżeli string jest prawidłową liczbą w podanym systemie liczbowym
    public boolean containsIllegalCharactersInSelectedBase(String stringToAnalyze, String selectedBase) {
        Boolean containsIllegalCharacters = false;
        Boolean containsNAN = false;
        Boolean containsIllegalNumbers = false;

        //Sprawdź pod kątem nieprawidłowych znaków
        Pattern pattern = Pattern.compile("[~#@/*+%{}<>\\[\\]|\"_^]");
        Matcher matcher = pattern.matcher(stringToAnalyze);
        containsNAN = matcher.find();
        System.out.println(containsNAN);

        //Sprawdź pod kątem liczb przekraczających zakres systemu liczbowego
        for (int i = 0; i < stringToAnalyze.length(); i++) {

            if (Integer.valueOf(stringToAnalyze.charAt(i)) - 48 >= Integer.valueOf(selectedBase)) {
                containsIllegalNumbers = true;
                System.out.println(Integer.valueOf(stringToAnalyze.charAt(i)) + " - " + Integer.valueOf(selectedBase));
            }
        }

        System.out.println(containsIllegalNumbers);

        if (containsNAN || containsIllegalNumbers) containsIllegalCharacters = true;

        System.out.println(containsIllegalCharacters);

        return containsIllegalCharacters;
    }

    //Dodaje na początku stringa określoną liczbę zer
    //Zwraca String z dodanymi zerami
    public String appendZeroBefore(String stringToAppend, Integer numberOfZeroes) {

        String zeroes = "";

        for (int i = 0; i < numberOfZeroes; i++) ;
        {
            zeroes = "0" + zeroes;
        }

        return zeroes + stringToAppend;

    }

    //Dodaje na końcu stringa określoną liczbę zer
    //Zwraca String
    public String appendZeroAfter(String stringToAppend, Integer numberOfZeroes) {

        String zeroes = "";

        for (int i = 0; i < numberOfZeroes; i++) ;
        {
            zeroes = "0" + zeroes;
        }

        return stringToAppend + zeroes;

    }

    //Neguje pierwszy bit liczby binarnej
    //Zwraca string z zanegowanym pierwszym bitem
    public String negateFirstByte(String binaryStringToNegateFirst) {

        if (binaryStringToNegateFirst.charAt(0) == 0) {
            return "0" + binaryStringToNegateFirst.substring(1);
        } else {
            return "1" + binaryStringToNegateFirst.substring(1);
        }

    }

    //Neguje wszystkie bity w stringu
    //Zwraca string z zanegowanymi wszystkimi bitami
    public String negateAllBytes(String binaryStringToNegate) {

        String tempString = binaryStringToNegate.replaceAll("0", "2");
        tempString = tempString.replaceAll("1", "0");
        tempString = tempString.replaceAll("2", "1");

        return tempString;

    }

    //Oblicz odwrotność addytywną dla liczby uzupełniniowej
    //Zwraca string będący odwrotonością addytywną
    public String complementaryReverse(String complementaryStringToReverse, String complementaryBase) {
        Integer BaseValue = Integer.valueOf(complementaryBase);
        Integer MaxNmberInGivenBase = BaseValue - 1;
        String reversedComplementaryString = "";

        for(int i = 0; i < complementaryStringToReverse.length(); i++) {




        }

        return reversedComplementaryString;
    }
}
