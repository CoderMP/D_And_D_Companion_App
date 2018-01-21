package com.example.markphilips.dungeons_and_dragons_companion.model;

/**
 * Class that defines a Spell
 *
 * @author Mark Philips
 * @since 1/15/2018
 * @version 1
 */
public class Spell {
    //region Private Field Variables
    private long dbID;
    private String name;
    private String school;
    private int level;
    private String range;
    private String effect;
    private String description;
    //endregion

    //region Constructor methods
    /**
     * Private constructor method for the Spell class. Defines a Spell that has no dbID
     *
     * @param name The name of the Spell
     * @param school The arcane school of the Spell
     * @param level The level of the Spell
     * @param range The range of the Spell
     * @param effect The effect of the Spell
     * @param description The description of the Spell
     */
    private Spell(String name, String school, int level, String range, String effect, String description){
        this.name = name;
        this.school = school;
        this.level = level;
        this.range = range;
        this.effect = effect;
        this.description = description;
    }


    /**
     * Constructor method for the Spell class. Defines a Spell that has an ID in SpellDB.
     *
     * @param dbID The dbID of the Spell
     * @param name The name of the Spell
     * @param school The arcane school of the Spell
     * @param level The level of the Spell
     * @param range The range of the Spell
     * @param effect The effect of the Spell
     * @param description The description of the Spell
     */
    public Spell(long dbID, String name, String school, int level, String range, String effect, String description){
        this(name, school, level, range, effect, description);
        this.dbID = dbID;
    }
    //endregion

    //region Setter methods
    public void setDbID(long dbID){ this.dbID = dbID; }
    public void setName(String name){ this.name = name; }
    public void setSchool(String school){ this.school = school; }
    public void setLevel(int level){ this.level = level; }
    public void setRange(String range){ this.range = range; }
    public void setEffect(String effect){ this.effect = effect; }
    public void setDescription(String description){ this.description = description; }
    //endregion

    //region Getter Methods
    public long getDbID(){ return this.dbID; }
    public String getName(){ return this.name; }
    public String getSchool(){ return this.school; }
    public int getLevel(){ return this.level; }
    public String getRange(){ return this.range; }
    public String getEffect(){ return this.effect; }
    public String getDescription(){ return this.description; }
    //endregion

    @Override
    public String toString() { return super.toString(); }
}