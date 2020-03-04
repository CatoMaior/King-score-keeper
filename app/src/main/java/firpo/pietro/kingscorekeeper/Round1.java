package firpo.pietro.kingscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class Round1 extends AppCompatActivity {

    private static TextView[] PlayerNamesList;
    private static TextView[] PlayerTokens;
    private static TextView[] RankingPlayerNames;
    private static TextView[] RankingPlayerPoints;

    private static SeekBar[] PlayerBars;

    private Button BackButton;
    private Button ForwardButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_round1);

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

        for (int i = 0; i < 4; i++){
            RankingPlayerNames[i] = (TextView) findViewById(idsNamesForRanking[i]);
            RankingPlayerNames[i].setText(PlayerNames.getPlayers()[i]);
            RankingPlayerPoints[i] = (TextView) findViewById(idsPointsForRanking[i]);
            RankingPlayerPoints[i].setText(String.valueOf(0));
            PlayerNamesList[i] = (TextView) findViewById(idsPlayerNames[i]);
            PlayerNamesList[i].setText(PlayerNames.getPlayers()[i]);
            PlayerTokens[i] = (TextView) findViewById(idsTokens[i]);
            PlayerBars[i] = (SeekBar) findViewById(idsBars[i]);
        }

        ForwardButton = (Button) findViewById(R.id.ForwardButton);
        BackButton = (Button) findViewById(R.id.BackButton);

        PlayerBars[0].setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                PlayerTokens[0].setText(String.valueOf(progress));
                if(isSum(8)) ForwardButton.setEnabled(true);
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
                if(isSum(8)) ForwardButton.setEnabled(true);
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
                if(isSum(8)) ForwardButton.setEnabled(true);
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
                if(isSum(8)) ForwardButton.setEnabled(true);
                else ForwardButton.setEnabled(false);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        BackButton.setOnClickListener(  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OpenInsertPlayerNames = new Intent(Round1.this, PlayerNames.class);
                startActivity(OpenInsertPlayerNames);
            }
        });

        ForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pointsForToken = Settings.getRound1Points();
                PlayerNames.setRoundPoints(1, PlayerBars[0].getProgress() * pointsForToken,
                        PlayerBars[1].getProgress() * pointsForToken,
                        PlayerBars[2].getProgress() * pointsForToken,
                        PlayerBars[3].getProgress() * pointsForToken);

                Intent OpenNextRound = new Intent(Round1.this, Round2.class);
                startActivity(OpenNextRound);
            }
        });

    }

    private static boolean isSum(int valueToCheck){
        int sum = 0;
        for(int i = 0; i < 4; i++){
            sum += PlayerBars[i].getProgress();
        }
        if (sum == valueToCheck) return true;
        else return false;
    }

}
