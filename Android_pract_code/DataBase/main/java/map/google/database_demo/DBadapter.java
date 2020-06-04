package map.google.database_demo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class DBadapter extends SQLiteOpenHelper {
//A helper class to manage database creation and version management by  implementing the
// onCreate(SQLiteDatabase arg0) , onUpgrade(SQLiteDatabase arg0, int oldversion, int newversion)

    private static final String DATABASE_NAME = "StudentsDetail";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_CONTACTS="tablename";
    private Context context;
    private static final String KEY_ID = "id";
    private static final String KEY_NAME = "name";
    private static final String EMAIL_ID = "email_id";

    public DBadapter(Context context) {
        // TODO Auto-generated constructor stub
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
        this.context=context;

        //android.database.sqlite.SQLiteOpenHelper.SQLiteOpenHelper
        //(Context context, String name, CursorFactory factory, int version)


    }

    @Override
    public void onCreate(SQLiteDatabase arg0) {
        // TODO Auto-generated method stub
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_CONTACTS + "(" + KEY_ID + " INTEGER PRIMARY KEY," + KEY_NAME + " TEXT,"
            + EMAIL_ID + " TEXT" + ")";
        arg0.execSQL(CREATE_CONTACTS_TABLE);
}

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int oldversion, int newversion) {
        // TODO Auto-generated method stub
        arg0.execSQL("DROP TABLE IF EXISTS " + TABLE_CONTACTS);
        onCreate(arg0);

    }
    void insert(String name1,String emailId1)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        //The database is not actually created or opened until one of getWritableDatabase()
        //or getReadableDatabase() is called.

        ContentValues values=new ContentValues();
        values.put(KEY_NAME, name1);
        values.put(EMAIL_ID, emailId1);
        db.insert(TABLE_CONTACTS, null, values);
        db.close();


    }
    public Cursor getInsertedData()
    //Cursor This interface provides random read-write access
    //to the result set returned by a database query.
    {
        SQLiteDatabase db=this.getReadableDatabase();
        return db.query(TABLE_CONTACTS, new String[] {KEY_ID,KEY_NAME,EMAIL_ID},
                null, null, null, null, null);

        // Cursor android.database.sqlite.SQLiteDatabase.query(String table,
        // String[] columns,String selection, String[]
        //selectionArgs, String groupBy, String having, String orderBy)


    }


    public void clearData() {
        // TODO Auto-generated method stub
        context.deleteDatabase(DATABASE_NAME);
    }


}



