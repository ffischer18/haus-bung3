package Beispiel1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class WeaponsWorker {

    private List<Weapon> weapons = new ArrayList<>();

    public List getWeapons() {
        return weapons;
    }

    public void readCSVFile() throws IOException {
        // "weapons.csv" einlesen und in ArrayList speichern
        /*
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("weapons.csv")));) {
            String line;
            while ((line = br.readLine()) != null) {
                Weapon w = Weapon.deserialize(line);
                if (line != null) {
                    weapons.add(w);
                }
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(WeaponsWorker.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(WeaponsWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
        */

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

    // sortieren mithilfe von lambdas
    public void sortA() {
        weapons.sort((w1, w2) -> w1.getDamage() - w2.getDamage());
    }

    public void sortB() {
        weapons.sort((w1, w2) -> {
            if (0 != w1.getCombatType().compareTo(w2.getCombatType())) {
                return w1.getCombatType().compareTo(w2.getCombatType());
            }
            if (0 != w1.getDamageType().compareTo(w2.getDamageType())) {
                return w1.getDamageType().compareTo(w2.getDamageType());
            }
            return w1.getName().compareTo(w2.getName());
        });
    }

    public void printWeapons() {
        sortA();
        Printable print = (weaponList) -> {
            for (Weapon weapon : weapons) {
                System.out.println(weapon);
            }
        };
    }

    public void printTable() {
        sortB();
        Printable print = (weaponList) -> {
            for (Weapon weapon : weapons) {
                System.out.print("-");
                System.out.println("|" + weapon + "|");
                System.out.print("+");
            }
        };
    }
}
