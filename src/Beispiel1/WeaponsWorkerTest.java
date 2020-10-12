package Beispiel1;

import Beispiel1.CombatType;
import Beispiel1.DamageType;
import Beispiel1.Weapon;
import Beispiel1.WeaponsWorker;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;

public class WeaponsWorkerTest {

    @Test
    void sortA() {
        WeaponsWorker weaponsWorker = new WeaponsWorker();
        List<Weapon> list = new ArrayList<>();
        list.add(new Weapon("Varscona", CombatType.MELEE, DamageType.SLASHING, 11, 3, 5, 4250));
        list.add(new Weapon("Tuigan Bow", CombatType.RANGED, DamageType.MISSILE, 1,5,6,3500));
        //weaponsWorker.sortA(list);

        String l1 = "Varscona; MELEE; SLASHING; 11, 3, 5, 4250";
        String l2 = "Tuigan Bow; RANGED; MISSILE; 1, 5, 6, 3500";
        List<String> explist = new ArrayList<>();
        explist.add(l1);
        explist.add(l2);

        assertEquals(list, explist);
    }

    @Test
    void sortB() {
        WeaponsWorker weaponsWorker = new WeaponsWorker();
        List<Weapon> list = new ArrayList<>();
        list.add(new Weapon("Varscona", CombatType.MELEE, DamageType.SLASHING, 11, 3, 5, 4250));
        list.add(new Weapon("Tuigan Bow", CombatType.RANGED, DamageType.MISSILE, 1,5,6,3500));
        //weaponsWorker.sortA(list);

        String l1 = "Tuigan Bow; RANGED; MISSILE; 1, 5, 6, 3500";
        String l2 = "Varscona; MELEE; SLASHING; 11, 3, 5, 4250";
        List<String> explist = new ArrayList<>();
        explist.add(l1);
        explist.add(l2);

        assertEquals(list, explist);
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}