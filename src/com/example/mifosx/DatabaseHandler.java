package com.example.mifosx;

import com.example.POJO.Client;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHandler extends SQLiteOpenHelper {
	 
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 3;
 
    // Database Name
    private static final String DATABASE_NAME = "clientsManager";
 
    // Contacts table name
    private static final String TABLE_CLIENT = "client";
 
    // Contacts Table Columns names
    private static final String KEY_OFFICE = "office";
    private static final String KEY_FNAME = "firstname";
    private static final String KEY_LNAME = "lastname";
    private static final String KEY_CBNAME = "clientbusiness";
    private static final String KEY_EXTERNAL = "externalid";
    private static final String KEY_JOINING = "joiningdate";
 
    
    static final String CREATE_CLIENT_TABLE = "CREATE TABLE " + TABLE_CLIENT + "("
            + KEY_OFFICE + " TEXT," + KEY_FNAME + " TEXT,"+ KEY_LNAME + " TEXT," + KEY_CBNAME + " TEXT,"+ KEY_EXTERNAL + " TEXT,"
            + KEY_JOINING + " TEXT" + ")";
    
    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        
    }
 
    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {
       
        db.execSQL(CREATE_CLIENT_TABLE);
    }
 
    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_CLIENT);
 
        // Create tables again
        onCreate(db);
    }
    
	
	    // Adding new contact
	public void addClient(Client client) {
	    SQLiteDatabase db = this.getWritableDatabase();
	 
	    ContentValues values = new ContentValues();
	    values.put(KEY_OFFICE, client.getOffice()); 
	    values.put(KEY_FNAME, client.getFirstName()); 
	    values.put(KEY_LNAME, client.getLastName());
	    values.put(KEY_CBNAME, client.getCbName());
	    values.put(KEY_EXTERNAL, client.getExternalId());
	    values.put(KEY_JOINING, client.getJoiningDate());
	 
	    // Inserting Row
	    db.insert(TABLE_CLIENT, null, values);
	    db.close(); // Closing database connection
	}
}