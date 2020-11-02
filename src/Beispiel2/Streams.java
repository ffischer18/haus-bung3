package Beispiel2;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.stream.Collectors;

public class Streams {
    private List<Weapon> weapons = new ArrayList<>();

    public static int[] randomInt = new int[(int) (Math.random() * 1001)];

    public double average(int[] numbers) {
        // Ohne Streams |
        //              v
        /*double mittel = 0 ;
        // Summe bilden
        for( int i = 0 ; i < numbers.length ; i++)
            mittel += numbers[i] ;
        mittel /= numbers.length ;
        return mittel;*/

        // Streams |
        //         v
        ArrayList<Double> list = new ArrayList<>();
        for (double i : numbers) {
            list.add(i);
        }
        return list.stream().reduce(0.0, Double::sum) / numbers.length;
    }

    public static String[] randomString() {
        String[] randomStr = new String[10]; // String-Array erstellen *
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray(); // char-Array mit Buchstaben für Zufallsgenerator erstellen *
        for (int i = 0; i < randomStr.length; i++) { // chars durchgehen bis Array mit 10 Strings befüllt ist -
            char[] currentString = new char[10]; // zusätzliches char-Array das für jeden String length = 10 ist *
            for(int j = 0; j < currentString.length; j++) { // currentString durchgehen bis jeder einzelne Wert des Arrays mit 10 Buchstaben befüllt ist -
                currentString[j] = chars[(int) (Math.random() * chars.length)]; // zusätzliches char-Array mit Buchstaben aus dem "chars" array befüllen +
            }
            randomStr[i] = new String(currentString); // char Array zu String
        }
        return randomStr;
    }

    public List<String> upperCase(String[] strings) {
        return Arrays.stream(strings).map(String::toUpperCase).collect(Collectors.toList());
    }

    public void readCSV() throws IOException {
        // mit lambdas einlesen
        weapons = Files.lines(new File("weapons.csv").toPath())
                //erste zeile überspringen
                .skip(1)
                //trennt bei ";" und speichert die Weapon werte
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
                // gespeicherten Werte in List umwandeln
                .collect(Collectors.toList());
    }

    public Weapon findWeaponWithLowestDamage(List<Weapon> weapons) {
        return weapons.stream().reduce((i, j) -> (i.getDamage() > j.getDamage())?j:i).orElse(null);
    }

    public Weapon findWeaponWithHighestStrength(List<Weapon> weapons) {
        return weapons.stream().reduce((i, j) -> (i.getMinStrength() < j.getMinStrength())?j:i).orElse(null);
    }

    public List<Weapon> collectMissileWeapons(List<Weapon> weapons) {
        return weapons.stream().filter(i -> i.getDamageType().equals(DamageType.MISSILE)).collect(Collectors.toList());
    }

    public Weapon findWeaponWithLongestName(List<Weapon> weapons) {
        Optional<Weapon> test = weapons.stream().max(Comparator.comparing(weapon -> weapon.getName().length()));
        if (test.isPresent()) {
            return test.get();
        }
        return null;
    }

    public List<String> toNameList(List<Weapon> weapons) {
        return weapons.stream().map(Weapon::getName).collect(Collectors.toList());
    }

    public int[] toSpeedArray(List<Weapon> weapons) {
        return weapons.stream().mapToInt(Weapon::getSpeed).toArray();
    }

    public int sumUpValues(List<Weapon> weapons) {
        return weapons.stream().mapToInt(Weapon::getValue).reduce((x,y) -> x + y).orElse(0);
    }

    public long sumUpHashCodes(List<Weapon> weapons) {
        return (int) weapons.stream().mapToLong(Weapon::hashCode).reduce((x,y) -> x + y).orElse(0);
    }

    public List<Weapon> removeDuplicates(List<Weapon> weapons) {
        return weapons.stream().distinct().collect(Collectors.toList());
    }

    public void increaseValuesByTenPercent(List<Weapon> weapons) {
        weapons.forEach(i -> i.setValue((int)(i.getValue() * 1.1)));
    }
}

