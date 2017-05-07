package anbu.dius.demo.diusagileboard.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import anbu.dius.demo.diusagileboard.R;

/**
 * Created by anbu.ezhilan on 2/05/2017.
 */

public class BoardFragment extends Fragment implements ClassDialogFragment.DialogClickListener {
        //implements View.OnTouchListener, View.OnDragListener {

    private View rootView;

    private RecyclerView mBoardRecyclerView;
    private RecyclerView.LayoutManager mBoardLayoutManager;
    private BoardAdapter mBoardAdapter;
    private final String TAG = BoardFragment.class.getSimpleName();
    private FloatingActionButton mAddCard;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        rootView = inflater.inflate(R.layout.fragment_board, container, false);

        mAddCard = (FloatingActionButton) rootView.findViewById(R.id.addCard);
        mAddCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Snackbar.make(rootView, "Add Card Clicked", Snackbar.LENGTH_LONG).setAction("Action", null).show();
                // Call the dialog Fragment here
                // TODO Best Practices
                FragmentManager fm = getActivity().getSupportFragmentManager();

                ClassDialogFragment cardDialogFragment = new ClassDialogFragment();
                cardDialogFragment.setTargetFragment(BoardFragment.this, 0);
                //cardDialogFragment.setRetainInstance(true);
                cardDialogFragment.show(fm, "cardFragment");

            }
        });

        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
     /*   getActivity().findViewById(R.id.card_view_col1).setOnTouchListener(this);
        getActivity().findViewById(R.id.green_ball).setOnTouchListener(this);
        getActivity().findViewById(R.id.blue_ball).setOnTouchListener(this);*/

        /*
        getActivity().findViewById(R.id.card_view).setOnTouchListener(this);
        getActivity().findViewById(R.id.top_container).setOnDragListener(this);
        getActivity().findViewById(R.id.bottom_container).setOnDragListener(this);
        getActivity().findViewById(R.id.bottom_container_2).setOnDragListener(this);
        */



        super.onViewCreated(view, savedInstanceState);

        mBoardRecyclerView = (RecyclerView) rootView.findViewById(R.id.rv_board_view);
        mBoardLayoutManager = new LinearLayoutManager(getContext(),
                                                        LinearLayoutManager.HORIZONTAL,
                                                        false);

        mBoardRecyclerView.setLayoutManager(mBoardLayoutManager);



        List<Integer> columnSize = new ArrayList<>();


        for ( int i=0;i<10;i++) { // TODO Default Column Size
            columnSize.add(i);
        }

        Log.d(TAG, "The ColumnSize is " + columnSize.size());

        mBoardAdapter = new BoardAdapter(columnSize);

        // Set the Adapter
        mBoardRecyclerView.setAdapter(mBoardAdapter);

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }



   /* @Override
    public boolean onTouch(View v, MotionEvent e) {
        if (e.getAction() == MotionEvent.ACTION_DOWN) {
            View.DragShadowBuilder shadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(null, shadowBuilder, v, 0);
            v.setVisibility(View.INVISIBLE);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean onDrag(View v, DragEvent e) {
        if (e.getAction()==DragEvent.ACTION_DROP) {
            View view = (View) e.getLocalState();
            ViewGroup from = (ViewGroup) view.getParent();
            from.removeView(view);
            LinearLayout to = (LinearLayout) v;
            to.addView(view);
            view.setVisibility(View.VISIBLE);
        }
        return true;
    }*/

    public void onAddCardView(String title) {
        Log.d(TAG, "Entering onAddCardView with Title " + title);

    }

    @Override
    public void onYesClick(DialogFragment dialogFragment) {
        EditText title = (EditText) dialogFragment.getDialog().findViewById(R.id.title);
        String strTitle = title.getText().toString();
        Log.d(TAG, "Retrieved Title is " + strTitle);
        Toast.makeText(getActivity(), strTitle, Toast.LENGTH_SHORT).show();
    }
}
