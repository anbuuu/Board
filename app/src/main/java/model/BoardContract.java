package model;

import android.provider.BaseColumns;

/**
 * Created by anbu.ezhilan on 7/05/2017.
 */

public final class BoardContract {

    public static final String _ID = "_id";
    public static final String TABLE_NAME_BOARD = "board";
    public static final String TABLE_NAME_BOARD_COLUMNS = "board_columns";
    public static final String TABLE_NAME_BOARD_CARDS = "board_cards";

    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private BoardContract() {}

    /* Inner class that defines the table contents */
    public static class BoardEntry implements BaseColumns {
        public static final String COLUMN_NAME_BOARD_NAME = "boardname";
        public static final String COLUMN_NAME_BOARD_ID = "boardid";
        public static final String COLUMN_NAME_NO_OF_COLUMNS = "noofcolumns";

        public static final String SQL_CREATE_TABLE_BOARD =
                "CREATE TABLE " + TABLE_NAME_BOARD + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_NAME_BOARD_NAME + " TEXT," +
                        COLUMN_NAME_NO_OF_COLUMNS + " INTEGER, " +
                        COLUMN_NAME_BOARD_ID + " INTEGER)";

        public static final String SQL_DELETE_BOARD_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME_BOARD;

    }

    public static class ColumnEntry implements BaseColumns {
        public static final String COLUMN_NAME_COLUMN_ID = "columnid";
        public static final String COLUMN_NAME_BOARD_COLUMNS_NAME = "columnname";
        public static final String COLUMN_NAME_BOARD_COLUMNS_BOARD_ID = "columnboardid";
        public static final String COLUMN_NAME_BOARD_COLUMNS_WIP_POINTS = "points";

        public static final String SQL_CREATE_TABLE_BOARD_COLUMNS =
                "CREATE TABLE " + TABLE_NAME_BOARD_COLUMNS + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_NAME_BOARD_COLUMNS_NAME + " TEXT," +
                        COLUMN_NAME_BOARD_COLUMNS_BOARD_ID + " INTEGER, " +
                        COLUMN_NAME_BOARD_COLUMNS_WIP_POINTS + " INTEGER, " +
                        COLUMN_NAME_COLUMN_ID + " INTEGER)";

        public static final String SQL_DELETE_COLUMN_ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME_BOARD;
    }

    public static class CardEntry implements BaseColumns {
        public static final String _ID = "_id";
        public static final String COLUMN_NAME_CARD_ID = "cardid";
        public static final String COLUMN_NAME_CARD_TITLE = "title";
        public static final String COLUMN_NAME_CARD_DESCRIPTION = "description";
        public static final String COLUMN_NAME_CARD_COLUMN_ID = "cardcolumnid";
        public static final String COLUMN_NAME_CARD_BOARD_ID = "cardboardid";
        public static final String COLUMN_NAME_CARD_POINTS = "cardpoints";

        public static final String SQL_CREATE_TABLE_BOARD_CARDS =
                "CREATE TABLE " + TABLE_NAME_BOARD_CARDS + " (" +
                        _ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                        COLUMN_NAME_CARD_TITLE + " TEXT," +
                        COLUMN_NAME_CARD_DESCRIPTION + " TEXT," +
                        COLUMN_NAME_CARD_COLUMN_ID + " INTEGER, " +
                        COLUMN_NAME_CARD_BOARD_ID + " INTEGER, " +
                        COLUMN_NAME_CARD_POINTS + " INTEGER, " +
                        COLUMN_NAME_CARD_ID + " INTEGER)";

        public static final String SQL_DELETE_CARD__ENTRIES =
                "DROP TABLE IF EXISTS " + TABLE_NAME_BOARD;

    }

}
