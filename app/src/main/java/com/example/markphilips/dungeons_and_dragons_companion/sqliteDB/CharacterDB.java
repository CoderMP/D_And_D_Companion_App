package com.example.markphilips.dungeons_and_dragons_companion.sqliteDB;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.markphilips.dungeons_and_dragons_companion.model.Character;

import java.util.ArrayList;

public class CharacterDB {
    //region Private Field Variables
    private SQLiteDatabase database;
    private SQLiteOpenHelper openHelper;

    private static final String DB_NAME = "characters.db";
    private static final String CHARACTERS_TABLE = "Characters";
    private static final int DB_VERSION = 1;

    private static final String ID = "_id";
    private static final String LEVEL = "level";
    private static final String NAME = "name";
    private static final String RACE = "race";
    private static final String ALIGNMENT = "alignment";
    private static final String CLASS = "class";
    private static final String BACKGROUND = "background";
    private static final String HITDICE = "hitdice";
    private static final String ARMOURRATING = "ar";
    private static final String CURRHEALTH = "currhealth";
    private static final String MAXHEALTH = "maxhealth";
    private static final String XP = "xp";
    private static final String SPEED = "speed";
    private static final String INITIATIVE = "initiative";

    private static final String CREATE_CHARACTER_TABLE =
            "CREATE TABLE " + CHARACTERS_TABLE + " (" +
                ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + LEVEL + " INTEGER, " + NAME + " TEXT, " +
                RACE + " TEXT, " + ALIGNMENT + " TEXT, " + CLASS + " TEXT, " + BACKGROUND + " TEXT, " +
                HITDICE + " TEXT,  " + ARMOURRATING + " INTEGER, " + CURRHEALTH + " INTEGER, " +
                MAXHEALTH + " INTEGER, " + XP + " INTEGER, " + SPEED + " INTEGER, " + INITIATIVE + " INTEGER)";
    //endregion

    //region Constructor Method
    /**
     *
     * @param context
     */
    public CharacterDB(Context context){
        openHelper = new DBHelper(context, DB_NAME, DB_VERSION);
    }
    //endregion

    //region Helper Class
    /**
     * Private class that assists with Database management
     */
    private static class DBHelper extends SQLiteOpenHelper {
        /**
         * Constructor method for the DBHelper Class. Makes a call to the parent constructor.
         *
         * @param context The current context
         * @param name The name of the database
         * @param version The version number of the database
         */
        public DBHelper(Context context, String name, int version) {
            super(context, name, null, version);
        }


        /**
         * Method responsible for creating a table
         *
         * @param db The SQLiteDatabase object used to create the table
         */
        @Override
        public void onCreate(SQLiteDatabase db) { db.execSQL(CREATE_CHARACTER_TABLE); }


        /**
         * Method responsible for updating the table.
         *
         * @param db The SQLiteDatabase object used to drop then update the table
         * @param oldVersion The previous DB version number
         * @param newVersion The current/new DB version number
         */
        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
            db.execSQL("DROP TABLE IF EXISTS " + CHARACTERS_TABLE);
            onCreate(db);
        }
    }
    //endregion

    //region Database/Query Methods
    /**
     * Method that is responsible for saving a Character object to the CharacterDB
     *
     * @param character The character object that is to be saved
     * @return The Character object with a dbID
     */
    public Character saveCharacter(Character character){
        //Open a writable instance of the database
        database = openHelper.getWritableDatabase();

        //Declare & initialize a new ContentValues object to insert the information into the database
        ContentValues cv = new ContentValues();

        //Populate the ContentValues object
        cv.put(LEVEL, character.getLevel());
        cv.put(NAME, character.getName());
        cv.put(RACE, character.getRace());
        cv.put(ALIGNMENT, character.getAlignment());
        cv.put(CLASS, character.getpClass());
        cv.put(BACKGROUND, character.getBackground());
        cv.put(HITDICE, character.getHitDice());
        cv.put(ARMOURRATING, character.getArmourRating());
        cv.put(CURRHEALTH, character.getCurrHealth());
        cv.put(MAXHEALTH, character.getMaxHealth());
        cv.put(XP, character.getXp());
        cv.put(SPEED, character.getSpeed());
        cv.put(INITIATIVE, character.getInitiative());

        //Declare and initialize a dbID long for the character object
        long id = database.insert(CHARACTERS_TABLE, null, cv);

        //Set the character object's dbID
        character.setDbID(id);

        //Close the database
        database.close();

        //Return the character object that now has a dbID
        return character;
    }


    /**
     * Method that is responsible for retrieving all the character entries from the CharacterDB
     *
     * @return A populated ArrayList of Character Objects from the CharacterDB
     */
    public ArrayList<Character> getAllCharacters(){
        ArrayList<Character> characters = new ArrayList<>();

        database = openHelper.getReadableDatabase();

        Cursor cursor = database.query(CHARACTERS_TABLE, null, null,
                null, null, null, null);

        getCharactersFromCursor(characters, cursor);

        //Close the cursor and database
        cursor.close();
        database.close();

        //Return the populated ArrayList of characters
        return characters;
    }


    //TODO: REFACTOR THIS METHOD TO RETURN A CHARACTER OBJECT RATHER THAN AN ARRAYLIST<CHARACTER>
    /**
     * Method that is responsible for retrieving a Character from the CharacterDB by the ID
     *
     * @param id The dbID of the Character in the CharacterDB
     * @return An ArrayList that contains the found character
     */
    public ArrayList<Character> getCharacterByID(long id){
        ArrayList<Character> characters = new ArrayList<>();

        database = openHelper.getReadableDatabase();

        String selection = "_id=" + id;
        String[] selectionArgs = new String[] {selection};

        Cursor cursor = database.query(CHARACTERS_TABLE, null, selection, selectionArgs,
                null, null, null);

        //Call the helper method to retrieve the character from the DB
        getCharactersFromCursor(characters, cursor);

        //Close the cursor and database
        cursor.close();
        database.close();

        //Return the populated
        return characters;
    }
    //endregion

    //region Helper Methods
    /**
     * Private helper method that is responsible for populating a character object with information
     * from the CharacterDB and adding it to the passed ArrayList of Characters
     *
     * @param characters The ArrayList that is to be populated with Character objects from the DB
     * @param cursor The cursor object used to query the DB for all Character entries
     */
    private void getCharactersFromCursor(ArrayList<Character> characters, Cursor cursor) {
        while(cursor.moveToNext()){
            long id = cursor.getLong(cursor.getColumnIndex(ID));
            int level = cursor.getInt(cursor.getColumnIndex(LEVEL));
            String name = cursor.getString(cursor.getColumnIndex(NAME));
            String race = cursor.getString(cursor.getColumnIndex(RACE));
            String alignment = cursor.getString(cursor.getColumnIndex(ALIGNMENT));
            String charClass = cursor.getString(cursor.getColumnIndex(CLASS));
            String background = cursor.getString(cursor.getColumnIndex(BACKGROUND));
            String hitDice = cursor.getString(cursor.getColumnIndex(HITDICE));
            float armourRating = cursor.getFloat(cursor.getColumnIndex(ARMOURRATING));
            int currHealth = cursor.getInt(cursor.getColumnIndex(CURRHEALTH));
            int maxHealth = cursor.getInt(cursor.getColumnIndex(MAXHEALTH));
            int xp = cursor.getInt(cursor.getColumnIndex(XP));
            int speed = cursor.getInt(cursor.getColumnIndex(SPEED));
            int initiative = cursor.getInt(cursor.getColumnIndex(INITIATIVE));

            //Add a declared & initialized Character object
            characters.add(new Character(id, name, race, alignment, charClass, background,
                    hitDice, armourRating, currHealth, maxHealth, xp, level, speed, initiative));
        }
    }
    //endregion
}
