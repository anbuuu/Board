package anbu.dius.demo.diusagileboard.views.view.activity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import anbu.dius.demo.diusagileboard.R;
import anbu.dius.demo.diusagileboard.views.fragment.BoardFragment;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import database.BoardDbHelper;
import model.BoardContract;

import static model.BoardContract.TABLE_NAME_BOARD;
import static model.BoardContract.TABLE_NAME_BOARD_COLUMNS;

public class MainActivity extends AppCompatActivity  {

    @BindView(R.id.createBoard)
    Button createBoard;

    @BindView(R.id.boardName)
    EditText boardName;

    @BindView(R.id.spinner)
    Spinner columnSpinner;

    private static final String TAG = MainActivity.class.getSimpleName();
    private static final Integer defaultColumns = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        ButterKnife.bind(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.createBoard)
    public void onCreateBoard() {
        Log.d(TAG, "on Create Board");
        // Re-direct to Board Fragment

        // Add to Database
        //boardName
        BoardDbHelper mDbHelper = new BoardDbHelper(this);
        SQLiteDatabase db = mDbHelper.getWritableDatabase();

        // Create a new map of values, where column names are the keys
        ContentValues values = new ContentValues();
        values.put(BoardContract.BoardEntry.COLUMN_NAME_BOARD_NAME, boardName.getText().toString());
        // Start with 2
        Log.d(TAG, "The No of Columns is " + defaultColumns);
        values.put(BoardContract.BoardEntry.COLUMN_NAME_NO_OF_COLUMNS, defaultColumns);

        //TODO check for Null -- I dont think I need to put columns in here .. will add in the board fragment itself
        // Insert the new row, returning the primary key value of the new row
        long newRowId = db.insert(BoardContract.TABLE_NAME_BOARD, null, values);
        // TODO Add separate log class
        Log.d(TAG, "Added to Table -  " + TABLE_NAME_BOARD + " with ID " + newRowId);

        // Add Column Details as well , Default are Starting and Done the 2 Columns
        values = new ContentValues();
        values.put(BoardContract.ColumnEntry.COLUMN_NAME_BOARD_COLUMNS_NAME, "Starting" );
        values.put(BoardContract.ColumnEntry.COLUMN_NAME_BOARD_COLUMNS_WIP_POINTS, Integer.valueOf("0") );
        newRowId = db.insert(TABLE_NAME_BOARD_COLUMNS, null, values);
        Log.d(TAG, "Added to Table -  " + TABLE_NAME_BOARD_COLUMNS + " with ID " + newRowId);

        values = new ContentValues();
        values.put(BoardContract.ColumnEntry.COLUMN_NAME_BOARD_COLUMNS_NAME, "Done" );
        values.put(BoardContract.ColumnEntry.COLUMN_NAME_BOARD_COLUMNS_WIP_POINTS, Integer.valueOf("10") );
        newRowId = db.insert(TABLE_NAME_BOARD_COLUMNS, null, values);
        Log.d(TAG, "Added to Table -  " + TABLE_NAME_BOARD_COLUMNS + " with ID " + newRowId);


        // Add to
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        BoardFragment fragment = new BoardFragment();
        transaction.add(R.id.maincontainer, fragment);
        transaction.replace(R.id.maincontainer, fragment, "Create Board");
        transaction.addToBackStack("main");
        transaction.commit();

         //.setCustomAnimations(R.anim.fragment_enter, R.anim.fragment_exit, R.anim.fragment_pop_enter, R.anim.fragment_pop_exit)
    }

    /*@Override
    public void onClassAdded(DialogFragment dialogFragment) {
        EditText title = (EditText) dialogFragment.getDialog().findViewById(R.id.title);
        String strTitle = title.getText().toString();
        Log.d(TAG, "Retrieved Title is " + strTitle);
        Toast.makeText(this, strTitle, Toast.LENGTH_SHORT).show();
        //onAddCardView
    }*/

}
