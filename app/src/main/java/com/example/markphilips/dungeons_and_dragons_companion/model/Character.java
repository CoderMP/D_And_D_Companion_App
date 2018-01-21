package com.example.markphilips.dungeons_and_dragons_companion.model;

/**
 * The Character Class. Defines a Character object that has a name, race,
 * alignment, background, hit dice, armour rating, health, level, speed,
 * initiative, and xp
 *
 * @author Mark Philips
 * @since 1/15/2018
 * @version 1
 */
public class Character {
    //region Private Field Variables

    //Define all required private field variable for the Character class
    private String name;
    private String race;
    private String alignment;
    private String pClass;
    private String background;
    private String hitDice;

    private float armourRating;
    private float currHealth;
    private float maxHealth;

    private int xp;
    private int level;
    private int speed;
    private int initiative;

    private long dbID;
    //endregion

    //region Constructor Methods
    /**
     * Private constructor method that defines a Character object without an ID in CharacterDB
     *
     * @param name The name of the character
     * @param race The race of the character
     * @param pClass The class of the character
     * @param bg The background of the character
     * @param alignment The alignment of the character
     * @param hitDice The Hit Die(ce) of the character
     * @param ar The Armour Rating of the character
     * @param currHealth The current health of the character
     * @param maxHealth The max health of the character
     * @param speed The movement distance of the character (in ft.)
     * @param initiative The initiative of the character
     * @param level The level of the character
     * @param xp The xp amount of the character
     */
    private Character(String name, String race, String pClass, String bg, String alignment,
                     String hitDice, float ar, float currHealth, float maxHealth, int speed,
                     int initiative, int level, int xp){
        this.name = name;
        this.race = race;
        this.pClass = pClass;
        this.background = bg;
        this.alignment = alignment;
        this.hitDice = hitDice;

        this.armourRating = ar;
        this.currHealth = currHealth;
        this.maxHealth = maxHealth;

        this.speed = speed;
        this.initiative = initiative;
        this.level = level;
        this.xp = xp;
    }


    /**
     * Constructor method fot the Character class. Responsible for defining a new Character object
     * @param name The character's name
     * @param race The character's race
     * @param pClass The character's class
     * @param bg The character's backgound
     * @param alignment The character's alignment
     * @param hitDice The character's hit dice
     * @param ar The character's armour rating
     * @param currHealth The character's current health
     * @param maxHealth The character's max health
     * @param speed The character's movement speed
     * @param initiative The character's turn initiative
     * @param level The character's level
     * @param xp The character's XP
     */
    public Character(long dbID, String name, String race, String pClass, String bg, String alignment,
                     String hitDice, float ar, float currHealth, float maxHealth, int speed,
                     int initiative, int level, int xp){
        this(name, race, pClass, bg, alignment, hitDice, ar, currHealth,
                maxHealth, speed, initiative, level, xp);
        this.dbID = dbID;
    }
    //endregion

    //region Setter Methods
    public void setDbID(long dbID){ this.dbID = dbID; }
    public void setName(String name){ this.name = name; }
    public void setRace(String race){ this.race = race; }
    public void setPClass(String pClass){ this.pClass = pClass; }
    public void setBackground(String background){ this.background = background; }
    public void setAlignment(String alignment){ this.alignment = alignment; }
    public void setHitDice(String hitDice){ this.hitDice = hitDice; }
    public void setArmourRating(float armourRating){ this.armourRating = armourRating; }
    public void setCurrHealth(float cHealth){ this.currHealth = cHealth; }
    public void setMaxHealth(float maxHealth){ this.maxHealth = maxHealth; }
    public void setSpeed(int speed){ this.speed = speed; }
    public void setInitiative(int initiative){ this.initiative = initiative; }
    public void setLevel(int level){ this.level = level; }
    public void setXp(int xp){ this.xp = xp; }
    //endregion

    //region Getter Methods
    public long getDbID(){ return this.dbID; }
    public String getName(){ return this.name; }
    public String getRace(){ return this.race; }
    public String getpClass(){ return this.pClass; }
    public String getBackground(){ return this.background; }
    public String getAlignment(){ return this.alignment; }
    public String getHitDice(){ return this.hitDice; }
    public float getArmourRating(){ return this.armourRating; }
    public float getCurrHealth(){ return this.currHealth; }
    public float getMaxHealth(){ return this.maxHealth; }
    public int getSpeed(){ return this.speed; }
    public int getInitiative(){ return this.initiative; }
    public int getLevel(){ return this.level; }
    public int getXp(){ return this.xp; }

    //TODO: Figure out if getcharacters getter method is necessary
    //endregion


    @Override
    public String toString() { return super.toString(); }
}