package com.example.android.tennisscoreboard;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;


public class CustomDialog extends DialogFragment {

    private EditText mInput1, mInput2;
    private TextView mActionOk;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.dialog_custom, container, false);
        mActionOk = view.findViewById(R.id.action_ok);
        mInput1 = view.findViewById(R.id.input1);
        mInput2 = view.findViewById(R.id.input2);

        mActionOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String input1 = mInput1.getText().toString(),
                        input2 = mInput2.getText().toString();
                if (!input1.equals("") && !input2.equals("")) {

                    //Easiest way: just set the value
                    ((MainActivity) getActivity()).inputDisplay1.setText(input1);
                    ((MainActivity) getActivity()).display1.setText(input1);
                    ((MainActivity) getActivity()).dInput1 = input1;

                    ((MainActivity) getActivity()).inputDisplay2.setText(input2);
                    ((MainActivity) getActivity()).display2.setText(input2);
                    ((MainActivity) getActivity()).dInput2 = input2;

                } else {
                    ((MainActivity) getActivity()).inputDisplay1.setText("Player 1");
                    ((MainActivity) getActivity()).display1.setText("Player 1");
                    ((MainActivity) getActivity()).dInput1 = "Player 1";

                    ((MainActivity) getActivity()).inputDisplay2.setText("Player 2");
                    ((MainActivity) getActivity()).display2.setText("Player2");
                    ((MainActivity) getActivity()).dInput2 = "Player 2";
                }

                getDialog().dismiss();
            }
        });

        return view;
    }
}