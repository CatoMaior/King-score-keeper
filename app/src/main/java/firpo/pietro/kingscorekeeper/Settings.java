package firpo.pietro.kingscorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
    }

    public static int getRound1Points(){
        return -2;
    }

    public static int getRound2Points(){
        return -3;
    }

    public static int getRound3Points(){
        return -8;
    }

    public static int getRound4Points(){
        return -8;
    }

    public static int getRound5Points(){
        return -1;
    }

    public static int getRound6Points(){
        return -4;
    }

    public static int getRound7Points(){
        return -1;
    }

    public static int getRound8Points(){
        return 1;
    }

    public static int getRound9Points(){
        return 1;
    }

    public static int getRound10Points(){
        return 1;
    }

    public static int getRound11Points(){
        return 1;
    }

    public static int getRound12Points(){
        return 1;
    }

    public static int getRound13Points(){
        return 2;
    }
}
