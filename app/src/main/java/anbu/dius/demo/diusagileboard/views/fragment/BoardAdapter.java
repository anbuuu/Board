package anbu.dius.demo.diusagileboard.views.fragment;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import anbu.dius.demo.diusagileboard.R;

/**
 * Created by anbu.ezhilan on 5/05/2017.
 */

class BoardAdapter extends RecyclerView.Adapter<BoardAdapter.BoardViewHolder> {

    private List<Integer> mDataSet;
    private final String TAG = BoardAdapter.class.getSimpleName();

    public BoardAdapter(List<Integer>columnList) {
        mDataSet = columnList;
    }

    @Override
    public BoardViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.column_list_item, parent, false);
        BoardViewHolder vh = new BoardViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(BoardViewHolder holder, int position) {
        Integer testInteger = mDataSet.get(position);
        Log.d(TAG, "The DataSet Position is " + testInteger);
    }

    @Override
    public int getItemCount() {
        return mDataSet.size();
    }

    public class BoardViewHolder extends RecyclerView.ViewHolder {

        private TextView mBoardTitleView;

        public BoardViewHolder(View v) {
            super(v);

        }

    }
}
