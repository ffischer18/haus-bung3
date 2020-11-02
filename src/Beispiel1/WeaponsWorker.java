package Beispiel1;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import javax.crypto.spec.PSource;
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
import java.util.stream.Stream;

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
            line= br.readLine(); // erste Zeile skippen
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

    // sortieren mithilfe von lambdas
    public void sortA(List<Weapon> weapons) {
        weapons.sort((w1, w2) -> {return w1.getDamage() - w2.getDamage();});
    }

    public void sortB(List<Weapon> weapons) {
        weapons.sort((w1, w2) -> {
            // wenn w1 und w2 gleich returned compareTo 0 und so weiter
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
        sortA(weapons);
        Printable print = (weaponList) -> {
            for (Weapon w:weapons) {
                System.out.println(w.getName() + " " + w.getCombatType() + " " + w.getDamageType() + " " + w.getDamage() + " " + w.getSpeed() + " " + w.getStrength() + " " + w.getValue());
            }
        };
        print.print(weapons);
    }

    public void printTable() {
        sortB(weapons);
        Printable print = (weaponList) -> {
            // System.out.format: %formatierung der Werte zb: Name, CombatType -links +rechts 20groesse
            String format = "| %-20s | %-20s | %-20s | %-20s | %-20s | %-20s | %-20s| %n";
            // header
            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.format(format, "Name", "CombatType", "DamageType", "Damage", "Speed", "Strength", "Value");
            //  Tabelle ausgeben
            for (Weapon w:weapons) {
                System.out.println("-----------------------+----------------------+----------------------+----------------------+----------------------+----------------------+----------------------");
                System.out.format(format, w.getName(), w.getCombatType(), w.getDamageType(), w.getDamage(), w.getSpeed(), w.getStrength(), w.getValue());
            }

            System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------");
        };
        print.print(weapons);
    }
}
