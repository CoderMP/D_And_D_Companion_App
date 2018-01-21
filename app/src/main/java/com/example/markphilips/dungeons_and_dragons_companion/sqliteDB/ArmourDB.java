package com.example.markphilips.dungeons_and_dragons_companion.sqliteDB;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mark on 1/9/2018.
 */

public class ArmourDB {
    private SQLiteDatabase database;
    private SQLiteOpenHelper openHelper;

    private static final String DB_NAME = "armour.db";
    private static final String ARMOUR_TABLE = "Armour";
    private static final int DB_VERSION = 1;


}
