package com.example.android.tennisscoreboard;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected static final String key5 = "name_p1", key6 = "aces_p1", key7 = "sets_won_p1", key8 = "U_errors_p1", key9 = "faults_p1", key10 = "games_won_p1",
            key11 = "name_p2", key12 = "aces_p2", key13 = "sets_won_p2", key14 = "U_errors_p2", key15 = "faults_p2", key16 = "games_won_p2";
    private static final String key1_P1 = "point_p1", key2_P1 = "game_p1", key3_P1 = "set_p1", key4_P1 = "set_p1_int", key5_P1 = "ace_p1", key6_P1 = "fault_p1", key7_P1 = "unforced_p1",
            key1_P2 = "point_p2", key2_P2 = "game_p2", key3_P2 = "set_p2", key4_P2 = "set_p2_int", key5_P2 = "ace_p2", key6_P2 = "fault_p2", key7_P2 = "unforced_p2",
            key1 = "setno", key2 = "Sets", key3 = "P1", key4 = "P2";
    protected int ace_Player1, ace_Player2, fault_Player1, fault_Player2, unforced_Player1, unforced_PLayer2;
    protected int point_Player1, point_Player2, game_Player1, game_Player2, set_Player1, set_Player2, setNo, sets = 4,
            player1, player2, total_Games_P1 = 0, total_Games_P2 = 0;
    protected Boolean whoWon;
    protected TextView inputDisplay1, inputDisplay2, display1, display2;
    protected String dInput1, dInput2;
    private TextView point_Player1_view, point_Player2_view, game_Player1_view, game_Player2_view;
    private TextView[] set_Player1_view = new TextView[sets],
            set_Player2_view = new TextView[sets];
    private int[] set_player1_int = new int[]{0, 0, 0, 0, 0},
            set_player2_int = new int[]{0, 0, 0, 0, 0};
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
        inputDisplay1 = (TextView) findViewById(R.id.edit_View1);
        inputDisplay2 = (TextView) findViewById(R.id.edit_View2);
        display1 = (TextView) findViewById(R.id.name_Player1);
        display2 = (TextView) findViewById(R.id.name_Player2);
        btn = (Button) findViewById(R.id.button_Point1);
        btn1 = (Button) findViewById(R.id.button_Point2);
        btn2 = (Button) findViewById(R.id.Ace_Player1);
        btn3 = (Button) findViewById(R.id.Ace_Player2);
        btn4 = (Button) findViewById(R.id.Fault_Player1);
        btn5 = (Button) findViewById(R.id.Fault_Player2);
        btn6 = (Button) findViewById(R.id.Unforced_Player1);
        btn7 = (Button) findViewById(R.id.Unforced_Player2);

        disable_Buttons();

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
                    display_Text(point_Player2_view, "Deuce");
                    display_Text(point_Player1_view, "Deuce");
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
                    display_Text(point_Player2_view, "Deuce");
                    display_Text(point_Player1_view, "Deuce");
                    break;
                }
        }
    }

    private void manipulatePLayerGame(TextView view) {

        switch (view.getId()) {

            case R.id.game_Player1:
                game_Player1 += 1;
                total_Games_P1 += 1;
                if (game_Player1 < 6) {

                    display(view, game_Player1);
                    break;
                } else if (game_Player1 == 6 && game_Player2 <= 4) {

                    set_Player1 = game_Player1;
                    set_Player2 = game_Player2;
                    displaySet(set_Player1, set_Player2);
                    if (setNo == 5) {

                        display(view, game_Player1);
                        display(game_Player2_view, game_Player2);
                        return;
                    }
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
                    if (setNo == 5) {

                        display(view, game_Player1);
                        display(game_Player2_view, game_Player2);
                        return;
                    }
                    game_Player1 = 0;
                    game_Player2 = 0;
                    display(view, game_Player1);
                    display(game_Player2_view, game_Player2);
                    break;
                }

            case R.id.game_Player2:
                game_Player2 += 1;
                total_Games_P2 += 1;
                if (game_Player2 < 6) {

                    display(view, game_Player2);
                    break;
                } else if (game_Player2 == 6 && game_Player1 <= 4) {

                    set_Player1 = game_Player1;
                    set_Player2 = game_Player2;
                    displaySet(set_Player1, set_Player2);
                    if (setNo == 5) {

                        display(view, game_Player2);
                        display(game_Player1_view, game_Player1);
                        return;
                    }
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
                    if (setNo == 5) {

                        display(view, game_Player2);
                        display(game_Player1_view, game_Player1);
                        return;
                    }
                    game_Player1 = 0;
                    game_Player2 = 0;
                    display(view, game_Player2);
                    display(game_Player1_view, game_Player1);
                    break;
                }
        }
    }

    private void displaySet(int setP1, int setP2) {

        if (setP1 > setP2) {
            player1 += 1;
        } else if (setP1 < setP2) {
            player2 += 1;
        }

        set_player1_int[setNo] = setP1;
        set_player2_int[setNo] = setP2;

        if (setNo == 4) {
            if (player1 > player2) {
                whoWon = true;
            } else if (player2 > player1) {
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

    private void enable_Buttons() {

        btn.setEnabled(true);
        btn1.setEnabled(true);
        btn2.setEnabled(true);
        btn3.setEnabled(true);
        btn4.setEnabled(true);
        btn5.setEnabled(true);
        btn6.setEnabled(true);
        btn7.setEnabled(true);
    }

    private void disable_Buttons() {

        btn.setEnabled(false);
        btn1.setEnabled(false);
        btn2.setEnabled(false);
        btn3.setEnabled(false);
        btn4.setEnabled(false);
        btn5.setEnabled(false);
        btn6.setEnabled(false);
        btn7.setEnabled(false);
    }

    public void new_game(View view) {

        CustomDialog dialog = new CustomDialog();
        dialog.show(getFragmentManager(), "CustomDialog");
        enable_Buttons();
        reset();
    }

    public void openActivity2(View view) {

        Intent intent = new Intent(this, StatsActivity.class);
        intent.putExtra(key5, dInput1);
        intent.putExtra(key6, ace_Player1);
        intent.putExtra(key7, player1);
        intent.putExtra(key8, unforced_Player1);
        intent.putExtra(key9, fault_Player1);
        intent.putExtra(key10, total_Games_P1);
        intent.putExtra(key11, dInput2);
        intent.putExtra(key12, ace_Player2);
        intent.putExtra(key13, player2);
        intent.putExtra(key14, unforced_PLayer2);
        intent.putExtra(key15, fault_Player2);
        intent.putExtra(key16, total_Games_P2);

        startActivity(intent);
    }

    private void end_Game() {

        String summary;
        if (whoWon) {

            summary = dInput1 + " Won this Match.";
            customDialog("Congratulation ", summary);
//            Context context = getApplicationContext();
//            Toast toast = Toast.makeText(context, R.string.p1_won, Toast.LENGTH_LONG);
//            toast.setGravity(Gravity.CENTER, 0, 0);
//            toast.show();

        } else {

            summary = dInput2 + " Won this Match.";
            customDialog("Congratulation ", summary);

        }

        disable_Buttons();
    }

    private void reset() {

        point_Player1 = 0;
        point_Player2 = 0;
        game_Player1 = 0;
        game_Player2 = 0;
        set_Player1 = 0;
        set_Player2 = 0;
        total_Games_P1 = 0;
        total_Games_P2 = 0;

        for (int k = 0; k <= 4; k++) {

            set_player1_int[k] = 0;
            set_player2_int[k] = 0;
            if (k < 4) {
                set_Player1_view[k].setText("-");
                set_Player2_view[k].setText("-");
            }
        }
        ace_Player1 = 0;
        ace_Player2 = 0;
        fault_Player1 = 0;
        fault_Player2 = 0;
        unforced_Player1 = 0;
        unforced_PLayer2 = 0;
        setNo = 0;
        sets = 0;
        player1 = 0;
        player2 = 0;
        dInput1 = "";
        dInput2 = "";

        point_Player1_view.setText("" + point_Player1);
        point_Player2_view.setText("" + point_Player2);
        game_Player1_view.setText("" + game_Player1);
        game_Player2_view.setText("" + game_Player2);

    }

    /**
     * This method is right before we change orientation, to preserve values
     */
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putInt(key1, setNo);
        outState.putInt(key2, sets);
        outState.putInt(key3, player1);
        outState.putInt(key4, player2);
        outState.putString(key5, dInput1);
        outState.putString(key11, dInput2);

        outState.putInt(key1_P1, point_Player1);
        outState.putInt(key2_P1, game_Player1);
        outState.putInt(key3_P1, set_Player1);
        outState.putIntArray(key4_P1, set_player1_int);
        outState.putInt(key5_P1, ace_Player1);
        outState.putInt(key6_P1, fault_Player1);
        outState.putInt(key7_P1, unforced_Player1);

        outState.putInt(key1_P2, point_Player2);
        outState.putInt(key2_P2, game_Player2);
        outState.putInt(key3_P2, set_Player2);
        outState.putSerializable(key4_P2, set_player2_int);
        outState.putInt(key5_P2, ace_Player2);
        outState.putInt(key6_P2, fault_Player2);
        outState.putInt(key7_P2, unforced_PLayer2);


    }

    /**
     * This method is called to display values in the UI which were saved
     */
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {

        super.onRestoreInstanceState(savedInstanceState);

        setNo = savedInstanceState.getInt(key1);
        sets = savedInstanceState.getInt(key2);
        player1 = savedInstanceState.getInt(key3);
        player2 = savedInstanceState.getInt(key4);
        dInput1 = savedInstanceState.getString(key5);
        dInput2 = savedInstanceState.getString(key11);

        point_Player1 = savedInstanceState.getInt(key1_P1);
        point_Player2 = savedInstanceState.getInt(key1_P2);
        game_Player1 = savedInstanceState.getInt(key2_P1);
        game_Player2 = savedInstanceState.getInt(key2_P2);
        set_Player1 = savedInstanceState.getInt(key3_P1);
        set_Player2 = savedInstanceState.getInt(key3_P2);
        set_player1_int = savedInstanceState.getIntArray(key4_P1);
        set_player1_int = savedInstanceState.getIntArray(key4_P2);
        ace_Player1 = savedInstanceState.getInt(key5_P1);
        ace_Player2 = savedInstanceState.getInt(key5_P2);
        fault_Player1 = savedInstanceState.getInt(key6_P1);
        fault_Player2 = savedInstanceState.getInt(key6_P2);
        unforced_Player1 = savedInstanceState.getInt(key7_P1);
        unforced_PLayer2 = savedInstanceState.getInt(key7_P2);

        point_Player1_view.setText("" + point_Player1);
        point_Player2_view.setText("" + point_Player2);
        game_Player1_view.setText("" + game_Player1);
        game_Player2_view.setText("" + game_Player2);
        for (int k = 0; k < 4; k++) {

            set_Player1_view[k].setText("" + set_player1_int[k]);
            set_Player2_view[k].setText("" + set_player2_int[k]);

        }

    }

    /**
     * This method is called when Ok is clicked on dialog
     */
    private void okMethod() {

        toastMessage("Click on New Game.");
    }

    /**
     * This method is used to create custom dialog
     */
    public void customDialog(String title, String message) {
        final android.support.v7.app.AlertDialog.Builder builderSingle = new android.support.v7.app.AlertDialog.Builder(this);
        builderSingle.setIcon(R.drawable.party_icon);
        this.setTheme(R.style.DontCopyMyStyle);
        builderSingle.setTitle(title);
        builderSingle.setMessage(message);

        builderSingle.setPositiveButton(
                "OK",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        okMethod();
                    }
                });


        builderSingle.show();
    }

    /**
     * This method is used to create toast
     */
    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

}

