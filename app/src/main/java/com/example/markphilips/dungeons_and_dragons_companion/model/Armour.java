package com.example.markphilips.dungeons_and_dragons_companion.model;

/**
 * A class that defines an Armour piece
 *
 * @author Mark Philips
 * @since 1/15/2018
 * @version 1
 */

public class Armour {
    //region Private Field Variables
    private long dbID;
    private String name;
    private String cost;
    private String armourClass;
    private int strength;
    private String stealth;
    private float weight;
    //endregion

    //region Constructor Methods
    /**
     * Private constructor method for the Armour class
     *
     * @param name The name of the armour
     * @param cost The cost of the armour (cp, sp, gp, pp)
     * @param armourClass The class of the armour (light, medium, heavy)
     * @param strength The strength/defense level of the armour
     * @param stealth The stealth assistance of the armour
     * @param weight The weight of the armour
     */
    private Armour(String name, String cost, String armourClass, int strength, String stealth, float weight){
        this.name = name;
        this.cost = cost;
        this.armourClass = armourClass;
        this.strength = strength;
        this.stealth = stealth;
        this.weight = weight;
    }


    /**
     *
     * @param dbID
     * @param name
     * @param cost
     * @param armourClass
     * @param strength
     * @param stealth
     * @param weight
     */
    public Armour(long dbID, String name, String cost, String armourClass, int strength, String stealth, float weight){
        this(name, cost, armourClass, strength, stealth, weight);
        this.dbID = dbID;
    }
    //endregion

    //region Setter Methods
    public void setDbID(long dbID){ this.dbID = dbID; }
    public void setName(String name){ this.name = name; }
    public void setCost(String cost){ this.cost = cost; }
    public void setArmourClass(String armourClass){ this.armourClass = armourClass; }
    public void setStrength(int strength){ this.strength = strength; }
    public void setStealth(String stealth){ this.stealth = stealth; }
    public void setWeight(float weight){ this.weight = weight;}
    //endregion

    //region Getter Methods
    public long getDbID(){ return this.dbID; }
    public String getName(){ return this.name; }
    public String getCost(){ return this.cost; }
    public String getArmourClass(){ return this.armourClass; }
    public int getStrength(){ return this.strength; }
    public String getStealth(){ return this.stealth; }
    public float getWeight(){ return this.weight; }
    //endregion

    @Override
    public String toString() { return super.toString(); }
}
