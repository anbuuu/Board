package anbu.dius.demo.diusagileboard.views.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import anbu.dius.demo.diusagileboard.R;

/**
 * Created by anbu.ezhilan on 6/05/2017.
 */

public class ClassDialogFragment extends DialogFragment {


    private ClassDialogFragmentListener classDialogListener;
    private DialogClickListener callback;

    private final String TAG = ClassDialogFragment.class.getSimpleName();
    private Button btnCreateCard;
    private Button cancelCard;

    public ClassDialogFragment() {
        // Empty Constructor required for dialog Fragment
    }

    public interface DialogClickListener {
        void onYesClick(DialogFragment dialogFragment);
        //public void onNoClick();
    }

    public interface ClassDialogFragmentListener {
        void onClassAdded(DialogFragment dialogFragment);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try {
            callback = (DialogClickListener) getTargetFragment();

        } catch (ClassCastException ex) {
            throw new ClassCastException("calling Fragment must implement DialogclickListener");
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.new_iteration_card_layout, container);

        getDialog().requestWindowFeature(STYLE_NO_TITLE);
        btnCreateCard = (Button) view.findViewById(R.id.createCard);
        btnCreateCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(TAG, "Entering OnClick Listener for Positive Click");
                //classDialogListener.onClassAdded(ClassDialogFragment.this);
                callback.onYesClick(ClassDialogFragment.this);
            }
        });

        cancelCard = (Button) view.findViewById(R.id.cancel);
        cancelCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDialog().dismiss();
            }
        });
        return view;

    }

    /*@NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder cardBuilder = new AlertDialog.Builder(getActivity());
        LayoutInflater layoutInflater = getActivity().getLayoutInflater();

        cardBuilder.setView(layoutInflater.inflate(R.layout.new_iteration_card_layout, null))
                .setPositiveButton("Create Card", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Log.d(TAG, "Entering OnClick Listener for Positive Click");
                        //classDialogListener.onClassAdded(ClassDialogFragment.this);
                        callback.onYesClick(ClassDialogFragment.this);
                    }
                })
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        ClassDialogFragment.this.getDialog().cancel();
                        //TODO -- Check with Android site for best practices
                    }
                });
        return cardBuilder.create();


    }*/

    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);

        try {
            callback = (DialogClickListener) context;
        } catch ( ClassCastException ex) {
            throw new ClassCastException(context.toString() + " must implement listener ");
        }
    }*/


}
