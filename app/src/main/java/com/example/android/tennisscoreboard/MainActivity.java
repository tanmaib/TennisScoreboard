package com.example.android.tennisscoreboard;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;

public class MainActivity extends AppCompatActivity {

    int ace_Player1, ace_Player2, fault_Player1, fault_Player2, unforced_Player1, unforced_PLayer2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void increase_Player1(View view) {

    }

    public void decrease_Player1(View view) {

    }

    public void increase_Player2(View view) {

    }

    public void decrease_Player2(View view) {

    }

    public void ace(View view) {


        switch (view.getId()) {

            case R.id.Ace_Player1:
                ace_Player1 += 1;
                break;

            case R.id.Ace_Player2:
                ace_Player2 += 1;
                break;
        }
    }

    public void fault(View view) {

        switch (view.getId()) {

            case R.id.Fault_Player1:
                fault_Player1 += 1;
                break;

            case R.id.Fault_Player2:
                fault_Player2 += 1;
                break;
        }
    }

    public void unforced(View view) {

        switch (view.getId()) {

            case R.id.Unforced_Player1:
                unforced_Player1 += 1;
                break;

            case R.id.Unforced_Player2:
                unforced_PLayer2 += 1;
                break;
        }
    }
}
