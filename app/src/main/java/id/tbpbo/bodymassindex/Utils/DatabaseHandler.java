package id.tbpbo.bodymassindex.Utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

import id.tbpbo.bodymassindex.Constanta.Constant;
import id.tbpbo.bodymassindex.Model.Walktrough.WalkthroughModel;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DatabaseHandler(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version, @Nullable DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    public DatabaseHandler(@Nullable Context context, @Nullable String name, int version, @NonNull SQLiteDatabase.OpenParams openParams) {
        super(context, name, version, openParams);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

//    static final String DB_NAME = "tubes_bmi";
//    static final int DB_VERSION = 1;
//
//    private static final String CREATE_TABLE = "create table " + Constant.table_bmi + "(" + Constant.ID
//            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + Constant.NAMA_BMI + " TEXT NOT NULL, " + Constant.TB_BMI + " TEXT," +
//            ""+Constant.BB_BMI + " TEXT,"+Constant.GENDER_BMI+");";
//
//    @Override
//    public void onCreate(SQLiteDatabase sqLiteDatabase) {
//
//    }
//
//    @Override
//    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//
//    }
}