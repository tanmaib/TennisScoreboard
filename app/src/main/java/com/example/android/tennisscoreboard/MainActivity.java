package com.example.android.tennisscoreboard;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected int ace_Player1, ace_Player2, fault_Player1, fault_Player2, unforced_Player1, unforced_PLayer2;
    private TextView point_Player1_view, point_Player2_view, game_Player1_view, game_Player2_view;
    protected int point_Player1, point_Player2, game_Player1, game_Player2, set_Player1, set_Player2, setNo, sets = 4, player1, player2;
    private TextView[] set_Player1_view = new TextView[sets];
    private TextView[] set_Player2_view = new TextView[sets];
    protected Boolean whoWon;
    private Button btn, btn1, btn2, btn3, btn4, btn5, btn6, btn7;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        point_Player1_view = (TextView) findViewById(R.id.point_Player1);
        point_Player2_view = (TextView) findViewById(R.id.point_Player2);
        game_Player1_view = (TextView) findViewById(R.id.game_Player1);
        game_Player2_view = (TextView) findViewById(R.id.game_Player2);
        set_Player1_view[0] = (TextView) findViewById(R.id.set1_Player1);
        set_Player1_view[1] = (TextView) findViewById(R.id.set2_Player1);
        set_Player1_view[2] = (TextView) findViewById(R.id.set3_Player1);
        set_Player1_view[3] = (TextView) findViewById(R.id.set4_Player1);
        set_Player2_view[0] = (TextView) findViewById(R.id.set1_Player2);
        set_Player2_view[1] = (TextView) findViewById(R.id.set2_Player2);
        set_Player2_view[2] = (TextView) findViewById(R.id.set3_Player2);
        set_Player2_view[3] = (TextView) findViewById(R.id.set4_Player2);
        btn = (Button) findViewById(R.id.button_Point1);
        btn1 = (Button) findViewById(R.id.button_Point2);
        btn2= (Button) findViewById(R.id.Ace_Player1);
        btn3 = (Button) findViewById(R.id.Ace_Player2);
        btn4 = (Button) findViewById(R.id.Fault_Player1);
        btn5 = (Button) findViewById(R.id.Fault_Player2);
        btn6 = (Button) findViewById(R.id.Unforced_Player1);
        btn7 = (Button) findViewById(R.id.Unforced_Player2);

        disable_Buttons();

        Toast toast = Toast.makeText(this, R.string.new_game, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void increase_Player1(View view) {


        if (point_Player1 < 30) {

            point_Player1 += 15;
            display(point_Player1_view, point_Player1);
        } else if (point_Player1 >= 30) {

            point_Player1 += 10;
            if (point_Player1 > 40 || (point_Player1 == 40 && point_Player2 == 40)) {
                manipulatePlayerPoints(point_Player1_view);
                return;
            }
            display(point_Player1_view, point_Player1);
        }
    }

    public void increase_Player2(View view) {

        if (point_Player2 < 30) {

            point_Player2 += 15;
            display(point_Player2_view, point_Player2);
        } else if (point_Player2 >= 30) {


            point_Player2 += 10;
            if (point_Player2 > 40 || (point_Player1 == 40 && point_Player2 == 40)) {
                manipulatePlayerPoints(point_Player2_view);
                return;
            }
            display(point_Player2_view, point_Player2);
        }

    }

    private void manipulatePlayerPoints(TextView view) {

        switch (view.getId()) {

            case R.id.point_Player2:
                if (point_Player1 < 40 && point_Player2 > 40) {

                    manipulatePLayerGame(game_Player2_view);
                    point_Player2 = 0;
                    point_Player1 = 0;
                    display(point_Player2_view, point_Player2);
                    display(point_Player1_view, point_Player1);
                    break;
                } else if (point_Player1 == 40 && point_Player2 == 40) {

                    display_Text(point_Player1_view, "Deuce");
                    display_Text(point_Player2_view, "Deuce");
                    break;
                } else if (point_Player2 <= 50 && point_Player2 > 40 && point_Player1 == 40) {

                    display_Text(point_Player2_view, "ADV");
                    display_Text(point_Player1_view, "-");
                    break;
                } else if (point_Player2 > 50 && point_Player1 == 40) {

                    manipulatePLayerGame(game_Player2_view);
                    point_Player2 = 0;
                    point_Player1 = 0;
                    display(point_Player2_view, point_Player2);
                    display(point_Player1_view, point_Player1);
                    break;
                } else if (point_Player2 > 40 && point_Player1 == 50) {

                    point_Player2 = 40;
                    point_Player1 = 40;
                    display(point_Player2_view, point_Player2);
                    display(point_Player1_view, point_Player1);
                    break;
                }

            case R.id.point_Player1:
                if (point_Player1 > 40 && point_Player2 < 40) {

                    manipulatePLayerGame(game_Player1_view);
                    point_Player2 = 0;
                    point_Player1 = 0;
                    display(point_Player2_view, point_Player2);
                    display(point_Player1_view, point_Player1);
                    break;
                } else if (point_Player1 == 40 && point_Player2 == 40) {

                    display_Text(point_Player1_view, "Deuce");
                    display_Text(point_Player2_view, "Deuce");
                    break;
                } else if (point_Player1 <= 50 && point_Player1 > 40 && point_Player2 == 40) {

                    display_Text(point_Player1_view, "ADV");
                    display_Text(point_Player2_view, "-");
                    break;
                } else if (point_Player1 > 50 && point_Player2 == 40) {

                    manipulatePLayerGame(game_Player1_view);
                    point_Player2 = 0;
                    point_Player1 = 0;
                    display(point_Player2_view, point_Player2);
                    display(point_Player1_view, point_Player1);
                    break;
                } else if (point_Player1 > 40 && point_Player2 == 50) {

                    point_Player2 = 40;
                    point_Player1 = 40;
                    display(point_Player2_view, point_Player2);
                    display(point_Player1_view, point_Player1);
                    break;
                }
        }
    }

    private void manipulatePLayerGame(TextView view) {

        switch (view.getId()) {

            case R.id.game_Player1:
                game_Player1 += 1;
                if (game_Player1 < 6) {

                    display(view, game_Player1);
                    break;
                } else if (game_Player1 == 6 && game_Player2 <= 4) {

                    set_Player1 = game_Player1;
                    set_Player2 = game_Player2;
                    displaySet(set_Player1, set_Player2);
                    if(setNo == 5){

                        display(view, game_Player1);
                        display(game_Player2_view, game_Player2);
                        return;}
                    game_Player1 = 0;
                    game_Player2 = 0;
                    display(view, game_Player1);
                    display(game_Player2_view, game_Player2);
                    break;
                } else if (game_Player1 == 6 && game_Player2 > 4) {

                    display(view, game_Player1);
                    break;
                } else if (game_Player1 == 7 && game_Player2 > 4) {

                    set_Player1 = game_Player1;
                    set_Player2 = game_Player2;
                    displaySet(set_Player1, set_Player2);
                    if(setNo == 5){

                        display(view, game_Player1);
                        display(game_Player2_view, game_Player2);
                        return;}
                    game_Player1 = 0;
                    game_Player2 = 0;
                    display(view, game_Player1);
                    display(game_Player2_view, game_Player2);
                    break;
                }

            case R.id.game_Player2:
                game_Player2 += 1;
                if (game_Player2 < 6) {

                    display(view, game_Player2);
                    break;
                } else if (game_Player2 == 6 && game_Player1 <= 4) {

                    set_Player1 = game_Player1;
                    set_Player2 = game_Player2;
                    displaySet(set_Player1, set_Player2);
                    if(setNo == 5){

                        display(view, game_Player2);
                        display(game_Player1_view, game_Player1);
                        return;}
                    game_Player1 = 0;
                    game_Player2 = 0;
                    display(view, game_Player2);
                    display(game_Player1_view, game_Player1);
                    break;
                } else if (game_Player2 == 6 && game_Player1 > 4) {

                    display(view, game_Player2);
                    break;
                } else if (game_Player2 == 7 && game_Player1 > 4) {

                    set_Player1 = game_Player1;
                    set_Player2 = game_Player2;
                    displaySet(set_Player1, set_Player2);
                    if(setNo == 5){

                        display(view, game_Player2);
                        display(game_Player1_view, game_Player1);
                        return;}
                    game_Player1 = 0;
                    game_Player2 = 0;
                    display(view, game_Player2);
                    display(game_Player1_view, game_Player1);
                    break;
                }
        }
    }

    private void displaySet(int setP1, int setP2) {

        if(setP1 > setP2){
            player1 += 1;
        }else if(setP1 < setP2){
            player2 += 1;
        }

        if(setNo == 4){
            if(player1 > player2){
                whoWon = true;
            }else if(player2 > player1){
                whoWon = false;
            }
            end_Game();
            setNo += 1;
            return;
        }

        set_Player1_view[setNo].setText("" + setP1);
        set_Player2_view[setNo].setText("" + setP2);
        setNo += 1;
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

    private void display(TextView view, int number) {

        view.setText("" + number);
    }

    private void display_Text(TextView view, String text) {

        view.setText(text);
    }

    private void display_Name() {

        EditText text1 = (EditText) findViewById(R.id.edit_View1),
                text2 = (EditText) findViewById(R.id.edit_View2);

        String name1 = text1.getText().toString(),
                name2 = text2.getText().toString();

        TextView display1 = (TextView) findViewById(R.id.name_Player1),
                display2 = (TextView) findViewById(R.id.name_Player2);

        display1.setText(name1);
        display2.setText(name2);
    }

    private void enable_Buttons(){

        btn.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
    }

    private void disable_Buttons(){

        btn.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
    }

    public void new_game(View view){

        enable_Buttons();
        reset();
        display_Name();
    }

    private void end_Game(){

        if(whoWon){

            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.p1_won, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        }else if(!whoWon){

            Context context = getApplicationContext();
            Toast toast = Toast.makeText(context, R.string.p2_won, Toast.LENGTH_LONG);
            toast.setGravity(Gravity.CENTER, 0, 0);
            toast.show();

        }

        disable_Buttons();
    }

    private void reset(){

        point_Player1 = 0;
        point_Player2 = 0;
        game_Player1 = 0;
        game_Player2 = 0;
        set_Player1 = 0;
        set_Player2 = 0;
        ace_Player1 = 0;
        ace_Player2 = 0;
        fault_Player1 = 0;
        fault_Player2 = 0;
        unforced_Player1 = 0;
        unforced_PLayer2 = 0;
        setNo = 0;
        sets = 0;
        player1 = 0;
        player2 =0;

        point_Player1_view.setText("" + point_Player1);
        point_Player2_view.setText("" + point_Player2);
        game_Player1_view.setText("" + game_Player1);
        game_Player2_view.setText("" + game_Player2);
        set_Player1_view[0].setText("-");
        set_Player1_view[1].setText("-");
        set_Player1_view[2].setText("-");
        set_Player1_view[3].setText("-");
        set_Player2_view[0].setText("-");
        set_Player2_view[1].setText("-");
        set_Player2_view[2].setText("-");
        set_Player2_view[3].setText("-");

    }

}

//    public void decrease_Player2(View view) {
//
//        if(point_Player2 <= 60 && point_Player2 > 0) {
//
//            point_Player2 -= 15;
//            display(point_Player2_view, point_Player2);
//        }else if(point_Player2 <= 0){
//
//            CharSequence text = "Points cannot be less than 0.";
//            int duration = Toast.LENGTH_SHORT;
//            Toast.makeText(this, text, duration).show();
//        }
//
//    }


