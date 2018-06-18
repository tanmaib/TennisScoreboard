package com.example.android.tennisscoreboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class StatsActivity extends AppCompatActivity {

    protected TextView Name_Act2_p1, Name_Act2_p2, Ace_Act2_p1, Ace_Act2_p2, Set_Act2_p1, Set_Act2_p2, Unf_Act2_p1, Unf_Act2_p2,
            Fault_Act2_p1, Fault_Act2_p2, Game_Act2_p1, Game_Act2_p2;
    int Ace1, Ace2, Set1, Set2, Unf1, Unf2, Fault1, Fault2, Game1, Game2;
    String Name1, Name2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Intent intent = getIntent();
        Name1 = intent.getStringExtra(MainActivity.key5);
        Name2 = intent.getStringExtra(MainActivity.key11);
        Ace1 = intent.getIntExtra(MainActivity.key6, 0);
        Ace2 = intent.getIntExtra(MainActivity.key12, 0);
        Set1 = intent.getIntExtra(MainActivity.key7, 0);
        Set2 = intent.getIntExtra(MainActivity.key13, 0);
        Unf1 = intent.getIntExtra(MainActivity.key8, 0);
        Unf2 = intent.getIntExtra(MainActivity.key14, 0);
        Fault1 = intent.getIntExtra(MainActivity.key9, 0);
        Fault2 = intent.getIntExtra(MainActivity.key15, 0);
        Game1 = intent.getIntExtra(MainActivity.key10, 0);
        Game2 = intent.getIntExtra(MainActivity.key16, 0);


        Name_Act2_p1 = (TextView) findViewById(R.id.TextView1_p1);
        Name_Act2_p2 = (TextView) findViewById(R.id.TextView1_p2);
        Ace_Act2_p1 = (TextView) findViewById(R.id.TextView2_p1);
        Ace_Act2_p2 = (TextView) findViewById(R.id.TextView2_p2);
        Set_Act2_p1 = (TextView) findViewById(R.id.TextView3_p1);
        Set_Act2_p2 = (TextView) findViewById(R.id.TextView3_p2);
        Unf_Act2_p1 = (TextView) findViewById(R.id.TextView4_p1);
        Unf_Act2_p2 = (TextView) findViewById(R.id.TextView4_p2);
        Fault_Act2_p1 = (TextView) findViewById(R.id.TextView5_p1);
        Fault_Act2_p2 = (TextView) findViewById(R.id.TextView5_p2);
        Game_Act2_p1 = (TextView) findViewById(R.id.TextView6_p1);
        Game_Act2_p2 = (TextView) findViewById(R.id.TextView6_p2);

        Name_Act2_p1.setText(Name1);
        Name_Act2_p2.setText(Name2);
        Ace_Act2_p1.setText("" + Ace1);
        Ace_Act2_p2.setText("" + Ace2);
        Set_Act2_p1.setText("" + Set1);
        Set_Act2_p2.setText("" + Set2);
        Unf_Act2_p1.setText("" + Unf1);
        Unf_Act2_p2.setText("" + Unf2);
        Fault_Act2_p1.setText("" + Fault1);
        Fault_Act2_p2.setText("" + Fault2);
        Game_Act2_p1.setText("" + Game1);
        Game_Act2_p2.setText("" + Game2);
    }
}
