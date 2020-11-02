package Beispiel2;

import Beispiel1.CombatType;
import Beispiel1.DamageType;
import Beispiel1.Weapon;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Streams {
    private List<Weapon> weapons = new ArrayList<>();

    int[] randomInt = new int[(int)(Math.random() * 1001)];
    //String[] randomStr = new String[1]{(String)(Math.random() * 10) + 1};

    public double average(int[] numbers) {
        /*double mittel = 0 ;
        // Summe bilden
        for( int i = 0 ; i < numbers.length ; i++)
            mittel += numbers[i] ;
        mittel /= numbers.length ;
        return mittel;*/

        ArrayList<Double> ar = new ArrayList<>();
        for (double i: numbers) {
            ar.add(i);
        }
        return ar.stream().reduce(0.0, Double::sum)/ numbers.length;
    }

    public List<String> upperCase(String[] strings) {
        List<String> list = new ArrayList<>();
        return list.stream().map(String::toUpperCase).collect(Collectors.toList());
    }

    public void readCSV() throws IOException {
        // mit lambdas einlesen
        weapons = Files.lines(new File("weapons.csv").toPath())
                .skip(1)
                .map(s -> s.split(";"))
                .map(s -> new Weapon(
                        s[0],
                        CombatType.valueOf(s[1]),
                        DamageType.valueOf(s[2]),
                        Integer.parseInt(s[3]),
                        Integer.parseInt(s[4]),
                        Integer.parseInt(s[5]),
                        Integer.parseInt(s[6])
                ))
                .collect(Collectors.toList());
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream().min(Comparator.comparing((Weapon::getDamage))).get();
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream().max(Comparator.comparing((Weapon::getStrength))).get();
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(weapon -> weapons.equals(Beispiel2.DamageType.MISSILE)).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        Optional<Weapon> test=weapons.stream().max(Comparator.comparing(weapon -> weapon.getName().length()));
        if(test.isPresent()) {
            return test.get();
        }
        return null;
    }
/*
    public List<String> toNameList(List<Weapon> weapons) {
        weapons.stream().map(Weapon::getName)
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

