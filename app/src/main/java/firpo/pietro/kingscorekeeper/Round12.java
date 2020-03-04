package firpo.pietro.kingscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class Round12 extends AppCompatActivity {

    private static TextView[] PlayerNamesList;
    private static TextView[] PlayerTokens;
    private static TextView[] RankingPlayerNames;
    private static TextView[] RankingPlayerPoints;

    private static SeekBar[] PlayerBars;

    private Button BackButton;
    private Button ForwardButton;

    private static boolean[] isPlayerinRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round1);

        TextView Round = (TextView) findViewById(R.id.Round);
        Round.setText("Dodicesima mano");
        TextView WhatToTake = (TextView) findViewById(R.id.WhatToTake);
        WhatToTake.setText("Dichiarazione di " + PlayerNames.getPlayers()[3] + "\nPiù 1 punto per ogni presa");

        int idsPlayerNames[] = new int[] {R.id.Player1Label, R.id.Player2Label,
                R.id.Player3Label, R.id.Player4Label};
        int idsTokens[] = new int[] {R.id.Player1Num, R.id.Player2Num,
                R.id.Player3Num, R.id.Player4Num};
        int idsBars[] = new int[] {R.id.Player1SeekBar, R.id.Player2SeekBar,
                R.id.Player3SeekBar, R.id.Player4SeekBar};
        int idsNamesForRanking[] = new int[] {R.id.FirstPlayerName, R.id.SecondPlayerName,
                R.id.ThirdPlayerName, R.id.FourthPlayerName};
        int idsPointsForRanking[] = new int[] {R.id.FirstPlayerPoints, R.id.SecondPlayerPoints,
                R.id.ThirdPlayerPoints, R.id.FourthPlayerPoints};

        PlayerNamesList = new TextView[4];
        PlayerTokens = new TextView[4];
        PlayerBars = new SeekBar[4];
        RankingPlayerNames = new TextView[4];
        RankingPlayerPoints = new TextView[4];
        isPlayerinRanking = new boolean[4];

        for (int i = 0; i < 4; i++){
            isPlayerinRanking[i] = false;
            PlayerNamesList[i] = (TextView) findViewById(idsPlayerNames[i]);
            PlayerNamesList[i].setText(PlayerNames.getPlayers()[i]);
            PlayerTokens[i] = (TextView) findViewById(idsTokens[i]);
            RankingPlayerNames[i] = (TextView) findViewById(idsNamesForRanking[i]);
            RankingPlayerPoints[i] = (TextView) findViewById(idsPointsForRanking[i]);
            PlayerBars[i] = (SeekBar) findViewById(idsBars[i]);
            PlayerBars[i].setMax(13);
        }

        ForwardButton = (Button) findViewById(R.id.ForwardButton);
        BackButton = (Button) findViewById(R.id.BackButton);

        ArrayList<int[]> PointsAndPlayers = new ArrayList<int[]>();
        ArrayList<int[]> Ranking = new ArrayList<int[]>();

        for (int i = 0; i < 4; i++){
            int[] temp = new int[]{i, PlayerNames.getTotalPoints()[i]};
            PointsAndPlayers.add(i, temp);
        }

        for (int i = 0; i < 4; i++){
            int localMax = -200;
            int indexMax = -1;
            for(int j = 0; j < PointsAndPlayers.size(); j++){
                if (PointsAndPlayers.get(j)[1] > localMax) {
                    localMax = PointsAndPlayers.get(j)[1];
                    indexMax = j;
                }
            }
            Ranking.add(PointsAndPlayers.get(indexMax));
            PointsAndPlayers.remove(indexMax);
        }

        for (int i = 0; i < 4; i++){
            RankingPlayerNames[i].setText(PlayerNames.getPlayers()[Ranking.get(i)[0]]);
            RankingPlayerPoints[i].setText(String.valueOf(Ranking.get(i)[1]));
        }

        PlayerBars[0].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                PlayerTokens[0].setText(String.valueOf(progress));
                if(isSum(13)) ForwardButton.setEnabled(true);
                else ForwardButton.setEnabled(false);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        PlayerBars[1].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                PlayerTokens[1].setText(String.valueOf(progress));
                if(isSum(13)) ForwardButton.setEnabled(true);
                else ForwardButton.setEnabled(false);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        PlayerBars[2].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                PlayerTokens[2].setText(String.valueOf(progress));
                if(isSum(13)) ForwardButton.setEnabled(true);
                else ForwardButton.setEnabled(false);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        PlayerBars[3].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                PlayerTokens[3].setText(String.valueOf(progress));
                if(isSum(13)) ForwardButton.setEnabled(true);
                else ForwardButton.setEnabled(false);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pointsForToken = Settings.getRound12Points();
                PlayerNames.setRoundPoints(12, PlayerBars[0].getProgress() * pointsForToken,
                        PlayerBars[1].getProgress() * pointsForToken,
                        PlayerBars[2].getProgress() * pointsForToken,
                        PlayerBars[3].getProgress() * pointsForToken);

                Intent OpenNextRound = new Intent(Round12.this, Round13.class);
                startActivity(OpenNextRound);
            }
        });

    }

    private static boolean isSum(int valueToCheck){
        int sum = 0;
        for (int i = 0; i < 4; i++){
            sum += PlayerBars[i].getProgress();
        }
        if (sum == valueToCheck) return true;
        else return false;
    }
}