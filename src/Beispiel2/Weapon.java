package Beispiel2;

import java.util.Objects;

public class Weapon {

    private final String name;
    private final CombatType combatType;
    private final DamageType damageType;
    private final int damage;
    private final int speed;
    private final int minStrength;
    private int value;

    public Weapon(String name, CombatType combatType, DamageType damageType, int damage, int speed, int minStrength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.minStrength = minStrength;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public CombatType getCombatType() {
        return combatType;
    }

    public DamageType getDamageType() {
        return damageType;
    }

    public int getDamage() {
        return damage;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMinStrength() {
        return minStrength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weapon weapon = (Weapon) o;
        return damage == weapon.damage &&
                speed == weapon.speed &&
                minStrength == weapon.minStrength &&
                value == weapon.value &&
                Objects.equals(name, weapon.name) &&
                combatType == weapon.combatType &&
                damageType == weapon.damageType;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.name);
        hash = 11 * hash + Objects.hashCode(this.combatType);
        hash = 11 * hash + Objects.hashCode(this.damageType);
        hash = 11 * hash + this.damage;
        hash = 11 * hash + this.speed;
        hash = 11 * hash + this.minStrength;
        hash = 11 * hash + this.value;
        return hash;
    }

    @Override
    public String toString() {
        return "Weapon{" + "name=" + name + ", combatType=" + combatType + ", damageType=" + damageType + ", damage=" + damage + ", speed=" + speed + ", minStrength=" + minStrength + ", value=" + value + '}';
    }

}
