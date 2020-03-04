package firpo.pietro.kingscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Ranking extends AppCompatActivity {

    private static TextView[] RankingPlayerNames;
    private static TextView[] RankingPlayerPoints;

    private Button BackButton;
    private Button ForwardButton;

    private static boolean[] isPlayerinRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);

        int idsNamesForRanking[] = new int[] {R.id.FirstPlayerName, R.id.SecondPlayerName,
                R.id.ThirdPlayerName, R.id.FourthPlayerName};
        int idsPointsForRanking[] = new int[] {R.id.FirstPlayerPoints, R.id.SecondPlayerPoints,
                R.id.ThirdPlayerPoints, R.id.FourthPlayerPoints};

        ForwardButton = (Button) findViewById(R.id.ForwardButton);
        BackButton = (Button) findViewById(R.id.BackButton);

        RankingPlayerNames = new TextView[4];
        RankingPlayerPoints = new TextView[4];
        isPlayerinRanking = new boolean[4];

        for (int i = 0; i < 4; i++){
            isPlayerinRanking[i] = false;
            RankingPlayerNames[i] = (TextView) findViewById(idsNamesForRanking[i]);
            RankingPlayerPoints[i] = (TextView) findViewById(idsPointsForRanking[i]);
        }

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

        BackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ForwardButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OpenNextRound = new Intent(Ranking.this, MainMenu.class);
                startActivity(OpenNextRound);
            }
        });

    }
}
