package com.example.mmase.todolist;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewItemFragment extends Fragment {

    private onNewItemAddedListener onNewItemAddedListener;

    public NewItemFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.new_item_fragment, container, false);

        final EditText myEditText = (EditText)view.findViewById(R.id.myEditText);
        myEditText.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int keyCode, KeyEvent event) {
                if (event.getAction() == KeyEvent.ACTION_DOWN ) {
                    if (keyCode == KeyEvent.KEYCODE_ENTER || keyCode == KeyEvent.KEYCODE_DPAD_CENTER) {
                        String newItem = myEditText.getText().toString();
                        onNewItemAddedListener.onNewItemAdded(newItem);
                        myEditText.setText("");
                        return true;
                    }
                }
                return false;
            }
        });
        return view;
    }

    public interface onNewItemAddedListener {
        public void onNewItemAdded(String newItem);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            assignNewItemAddedListner(activity);

        } catch (ClassCastException ex) {
                throw ex;
            }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            assignNewItemAddedListner(getActivity());
        } catch (ClassCastException ex) {
            throw ex;
        }
    }

    private void assignNewItemAddedListner(Activity activity) throws ClassCastException {
            onNewItemAddedListener = (onNewItemAddedListener) activity;
    }



}
