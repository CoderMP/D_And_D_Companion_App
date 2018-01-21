package com.example.markphilips.dungeons_and_dragons_companion.model;

/**
 * Class that defines a Weapon object
 *
 * @author Mark Philips
 * @since 01/15/2018
 * @version 1
 */
public class Weapon {
    //region Private Field Variables
    private long dbID;

    private String name;
    private String damage;
    private String damageType;
    private float weight;
    private String cost;
    private int weaponType;
    //endregion

    //region Constructor Methods
    /**
     * Private constructor method for the Weapon Class. Defines a Weapon that has no dbID.
     *
     * @param name The weapon's name
     * @param damage The Weapon's damage value
     * @param damageType The weapon's damage type
     * @param weight The weapon's weight
     * @param cost The weapon's cost (cp, sp, gp, or pp)
     * @param weaponType The Weapon's type (Simple or Martial)
     */
    private Weapon(String name, String damage, String damageType, float weight, String cost, int weaponType){
        this.name = name;
        this.damage = damage;
        this.damageType = damageType;
        this.weight = weight;
        this.cost = cost;
        this.weaponType = weaponType;
    }


    /**
     * Constructor method for the Weapon Class. Defines a Weapon with a dbID.
     *
     * @param dbID The weapon's ID in the WeaponDB
     * @param name The name of the weapon
     * @param damage The damage value of the weapon
     * @param damageType The damage type of the weapon
     * @param weight The weight of the weapon (in lbs.)
     * @param cost The cost of the weapon (cp, sp, gp, pp)
     * @param weaponType The type of the weapon (Simple or Martial)
     */
    public Weapon(long dbID, String name, String damage, String damageType, float weight, String cost, int weaponType){
        //Call the private constructor to set all values except the dbID
        this(name, damage, damageType, weight, cost, weaponType);

        //Set the dbID
        this.dbID = dbID;
    }
    //endregion

    //region Setter Methods
    public void setDbID(long dbID){ this.dbID = dbID; }
    public void setName(String name){ this.name = name; }
    public void setDamage(String damage){ this.damage = damage; }
    public void setDamageType(String damageType){ this.damageType = damageType; }
    public void setWeight(float weight){ this.weight = weight;}
    public void setCost(String cost){ this.cost = cost; }
    public void setWeaponType(int weaponType){ this.weaponType = weaponType; }
    //endregion

    //region Getter Methods
    public long getDbID(){ return this.dbID; }
    public String getName(){ return this.name; }
    public String getDamage(){ return this.damage; }
    public String getDamageType(){ return this.damageType; }
    public float getWeight(){ return this.weight; }
    public String getCost(){ return this.cost; }
    public int getWeaponType(){ return this.weaponType; }
    //endregion

    @Override
    public String toString() { return super.toString(); }
}
