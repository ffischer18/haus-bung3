package Beispiel1;

public class Weapons {
    private String name;
    private CombatType combatType;
    private DamageType damageType;
    private int damage;
    private int speed;
    private int strength;
    private int value;

    public Weapons() {
    }

    public Weapons(String name, CombatType combatType, DamageType damageType, int damage, int speed, int strength, int value) {
        this.name = name;
        this.combatType = combatType;
        this.damageType = damageType;
        this.damage = damage;
        this.speed = speed;
        this.strength = strength;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CombatType getCombatType() {
        return combatType;
    }

    public void setCombatType(CombatType combatType) {
        this.combatType = combatType;
    }

    public DamageType getDamgeType() {
        return damageType;
    }

    public void setDamgeType(DamageType damageType) {
        this.damageType = damageType;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.name + ";" + this.combatType + ";" + this.damageType + ";" + this.damage + ";" + this.speed + ";" + this.strength + ";" + this.value;
    }

    public static Weapons deserialize(String serialized) {
        if (serialized == null || serialized.isEmpty()) {
            return null;
        }
        String[] parts = serialized.split(";");
        if (parts.length != 7) {
            return null;
        }
        String name = parts[0];
        CombatType combatType = CombatType.valueOf(parts[1]);
        DamageType damageType = DamageType.valueOf(parts[2]);
        int damage = Integer.parseInt(parts[3]);
        int speed = Integer.parseInt(parts[4]);
        int strength = Integer.parseInt(parts[5]);
        int value = Integer.parseInt(parts[6]);
        Weapons p = new Weapons(name, combatType, damageType, damage, speed, strength, value);
        return p;
    }
}

