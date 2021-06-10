package com.example.mvp.data;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDataBase extends SQLiteOpenHelper {

    private static final String DB_NAME="clicksite";
    private static final int DB_VERSION  = 133;
    private static final String TABLE_NAME  = "news";
    private static final String COL_ID  = "id";
    private static final String COL_TITLE = "title";
    private static final String COL_DES = "description";
    private static final String COL_DATA = "data";

    public static final String QUERY="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+"("+
            COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COL_TITLE+" TEXT,"+
            COL_DES+" TEXT,"+
            COL_DATA+" TEXT);";

    Context context;

    public MyDataBase(@Nullable Context context) {
        super(context, name, factory, version);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try {
            db.execSQL(QUERY);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public Cursor addInfo(){
        String qurey="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        return sqLiteDatabase.rawQuery(qurey,null);
    }

    public Cursor getSomeData(){
        String name="mahla";
        String qurey="SELECT * FROM "+TABLE_NAME+" WHERE "+COL_ID+" = ?";
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        return sqLiteDatabase.rawQuery(qurey,new String[]{String.valueOf(name)});
    }

    public Cursor getInfos(){
        String qurey="SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        return sqLiteDatabase.rawQuery(qurey,null);

    }

}
