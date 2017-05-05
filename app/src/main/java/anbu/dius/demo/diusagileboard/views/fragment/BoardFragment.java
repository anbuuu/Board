package anbu.dius.demo.diusagileboard.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import anbu.dius.demo.diusagileboard.R;

/**
 * Created by anbu.ezhilan on 2/05/2017.
 */

public class BoardFragment extends Fragment {
        //implements View.OnTouchListener, View.OnDragListener {

    private View rootView;

    private RecyclerView mBoardRecyclerView;
    private RecyclerView.LayoutManager mBoardLayoutManager;
    private BoardAdapter mBoardAdapter;
    private final String TAG = BoardFragment.class.getSimpleName();

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

        for ( int i=0;i<20;i++) { // TODO Default Column Size
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

}
