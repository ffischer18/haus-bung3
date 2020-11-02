package Beispiel1;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class WeaponsWorkerTest {

    @Test
    public void sortA() {
        WeaponsWorker ww = new WeaponsWorker();

        List<Weapon> weapons = new ArrayList<>();
        Weapon w1 = new Weapon("Daystar",
                CombatType.MELEE,
                DamageType.SLASHING,
                12,
                3,
                6,
                10000);
        Weapon w2 =new Weapon("Varscona",
                CombatType.MELEE,
                DamageType.SLASHING,
                11,
                3,
                5,
                4250);
        Weapon w3 = new Weapon("Kundane",
                CombatType.MELEE,
                DamageType.SLASHING,
                8,
                0,
                5,
                4000);
        Weapon w4 = new Weapon("Broken Weapon",
                CombatType.NONE,
                DamageType.NONE,
                0,
                0,
                0,
                0);
        weapons.add(w1);
        weapons.add(w2);
        weapons.add(w3);
        weapons.add(w4);
        ww.sortA(weapons);

        List<Weapon> sorted = new ArrayList<>();
        sorted.add(w4);
        sorted.add(w3);
        sorted.add(w2);
        sorted.add(w1);

        Assert.assertEquals(sorted, weapons);
    }

    @Test
    public void sortB() {
        WeaponsWorker ww = new WeaponsWorker();

        List<Weapon> weapons = new ArrayList<>();
        Weapon w1 = new Weapon("Daystar",
                CombatType.MELEE,
                DamageType.SLASHING,
                12,
                3,
                6,
                10000);
        Weapon w2 =new Weapon("Varscona",
                CombatType.MELEE,
                DamageType.SLASHING,
                11,
                3,
                5,
                4250);
        Weapon w3 = new Weapon("Kundane",
                CombatType.MELEE,
                DamageType.SLASHING,
                8,
                0,
                5,
                4000);
        Weapon w4 = new Weapon("Broken Weapon",
                CombatType.NONE,
                DamageType.NONE,
                0,
                0,
                0,
                0);
        weapons.add(w1);
        weapons.add(w2);
        weapons.add(w3);
        weapons.add(w4);
        ww.sortB(weapons);

        List<Weapon> sorted = new ArrayList<>();
        sorted.add(w4);
        sorted.add(w1);
        sorted.add(w3);
        sorted.add(w2);

        Assert.assertEquals(sorted, weapons);
    }
}