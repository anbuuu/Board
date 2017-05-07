package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import model.BoardContract;

/**
 * Created by anbu.ezhilan on 7/05/2017.
 */

public class BoardDbHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    static final String DATABASE_NAME = "agileboard.db";




    public BoardDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION );
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO ifix up for best practices
        //final String SQL_CREATE_BOARD_TABLE = "CREATE TABLE " +
        db.execSQL(BoardContract.BoardEntry.SQL_CREATE_TABLE_BOARD);
        db.execSQL(BoardContract.ColumnEntry.SQL_CREATE_TABLE_BOARD_COLUMNS);
        db.execSQL(BoardContract.CardEntry.SQL_CREATE_TABLE_BOARD_CARDS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(BoardContract.BoardEntry.SQL_DELETE_BOARD_ENTRIES);
        db.execSQL(BoardContract.ColumnEntry.SQL_DELETE_COLUMN_ENTRIES);
        db.execSQL(BoardContract.CardEntry.SQL_DELETE_CARD__ENTRIES);
        onCreate(db);
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
