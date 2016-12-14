package com.kapss.akalkulator;

/**
 * Created by igor on 14.12.16.
 */

public class MathSupportLibrary {

    //Pusty konstruktor
    public MathSupportLibrary() {


    }

    //Dodaje na początku stringa określoną liczbę zer
    //Zwraca String z dodanymi zerami
    public String appendZeroBefore(String stringToAppend, Integer numberOfZeroes) {

        String zeroes = "";

        for(int i = 0; i < numberOfZeroes; i ++);
        {
            zeroes = "0" + zeroes;
        }

        return zeroes + stringToAppend;

    }

    //Dodaje na końcu stringa określoną liczbę zer
    //Zwraca String
    public String appendZeroAfter(String stringToAppend, Integer numberOfZeroes) {

        String zeroes = "";

        for(int i = 0; i < numberOfZeroes; i ++);
        {
            zeroes = "0" + zeroes;
        }

        return stringToAppend + zeroes;

    }

    //Neguje pierwszy bit liczby binarnej
    //Zwraca string z zanegowanym pierwszym bitem
    public String negateFirstByte(String binaryStringToNegateFirst) {

        if(binaryStringToNegateFirst.charAt(0) == 0) {
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
}
