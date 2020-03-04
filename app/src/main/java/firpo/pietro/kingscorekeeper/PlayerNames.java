package firpo.pietro.kingscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PlayerNames extends AppCompatActivity {

    private static EditText Player1Name;
    private static EditText Player2Name;
    private static EditText Player3Name;
    private static EditText Player4Name;

    private static String players[] = new String[4];

    private static  int[][] points;
    private static  int[] totalPoints;

    private static Button ForwardButton;
    private static Button BackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_player_names);

        Player1Name = (EditText) findViewById(R.id.Player1Textb);
        Player2Name = (EditText) findViewById(R.id.Player2Textb);
        Player3Name = (EditText) findViewById(R.id.Player3Textb);
        Player4Name = (EditText) findViewById(R.id.Player4Textb);

        Button BackButton = (Button) findViewById(R.id.BackButton);
        ForwardButton = (Button) findViewById(R.id.ForwardButton);

        ForwardButton.setEnabled(false);

        Player1Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ForwardButton.setEnabled(checkFull());
            }
        });
        Player2Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ForwardButton.setEnabled(checkFull());
            }
        });
        Player3Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ForwardButton.setEnabled(checkFull());
            }
        });
        Player4Name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                ForwardButton.setEnabled(checkFull());
            }
        });

        ForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                players[0] = Player1Name.getText().toString();
                players[1] = Player2Name.getText().toString();
                players[2] = Player3Name.getText().toString();
                players[3] = Player4Name.getText().toString();

                points = new int[4][13];
                totalPoints = new int[4];

                for (int i = 0; i < 4; i++){
                    totalPoints[i] = 0;
                    for (int j = 0; j < 13; j++) points[i][j] = 0;
                }

                Intent OpenRound1 = new Intent(PlayerNames.this, Round1.class);
                startActivity(OpenRound1);
            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OpenMainMenu = new Intent(PlayerNames.this, MainMenu.class);
                startActivity(OpenMainMenu);
            }
        });
    }

    private boolean checkFull(){

        if (Player1Name.getText().toString().equals("") ||
                Player2Name.getText().toString().equals("") ||
                Player3Name.getText().toString().equals("") ||
                Player4Name.getText().toString().equals("")){
            return false;
        }
        else return true;
    }

    public static String[] getPlayers(){
        return players;
    }

    public static int getRoundPoints(int round, int player){
        return points[player][round-1];
    }

    public static void setRoundPoints(int round, int player1, int player2, int player3, int player4){
        round -= 1;
        points[0][round] = player1;
        points[1][round] = player2;
        points[2][round] = player3;
        points[3][round] = player4;

        for (int i = 0; i < 4; i++){
            totalPoints[i] = 0;
        }
        for (int i = 0; i < 4; i++){
            for (int j = 0; j < 13; j++) totalPoints[i] += points[i][j];
        }

    }

    public static int[] getTotalPoints(){
        return totalPoints;
    }

}
