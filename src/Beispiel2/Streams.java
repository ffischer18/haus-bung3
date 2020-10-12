package Beispiel2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams {

    int[] randomInt = new int[(int)(Math.random() * 1001)];
    //String[] randomStr = new String[10]{"fuenf", "fuenf", "fuenf", "fuenf", "fuenf", "fuenf", "fuenf", "fuenf", "fuenf", "fuenf"};

    public double average(int[] numbers) {
        double mittel = 0 ;
        // Summe bilden
        for( int i = 0 ; i < numbers.length ; i++)
            mittel += numbers[i] ;

        mittel /= numbers.length ;
        return mittel;
    }

    public List<String> upperCase(String[] strings) {
        //noch mit streams
        List<String> list = new ArrayList<>();
        for (int i = 0; i < strings.length; i++) {
            list.add(strings[i].toUpperCase());
        }
        return list;
    }
/*
    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        //implement this
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        //implement this
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        //implement this
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        //implement this
    }

    public List<String> toNameList(List<Weapon> weapons) {
        //implement this
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        //implement this
    }

    public int sumUpValues(List<Weapon> weapons) {
        //implement this
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        //implement this
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        //implement this
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        //implement this
    }*/
}

