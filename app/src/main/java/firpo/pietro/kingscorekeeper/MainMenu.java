package firpo.pietro.kingscorekeeper;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        Button NewMatchButton = (Button) findViewById(R.id.NewGameButton);
        Button LoadGameButton = (Button) findViewById(R.id.LoadGameButton);

        NewMatchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent OpenNameScreen = new Intent(MainMenu.this, PlayerNames.class);
                startActivity(OpenNameScreen);
            }
        });

    }
}
