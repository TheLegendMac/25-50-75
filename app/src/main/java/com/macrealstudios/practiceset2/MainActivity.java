package com.macrealstudios.practiceset2;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/*Purpose:
    Try to score points in this two-player tapping frenzy game. Reach 75 points while eliminating points from your opponent and you win. Drop to 25 points and you lose.  Easy and simple!

    Note: Best played on tablets.

    Icon provided by:
    asianson.design
 */

public class MainActivity extends AppCompatActivity {

    //Initializing global score variables for both teams
    int rocketPoints = 50;
    int spursPoints = 50;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //Resets the score when the user taps on "Tap to clear"
    public void tapReset(View view) {
        rocketPoints = 50;
        spursPoints = 50;
        displayScoreForRocket(rocketPoints);
        displayScoreForSpurs(spursPoints);

        Toast.makeText(MainActivity.this, R.string.score_cleared_toast, Toast.LENGTH_SHORT).show();
    }

    //Add one point for team Rocket
    public void addOneForRocket(View v) {
        rocketPoints = rocketPoints + 1;
        displayScoreForRocket(rocketPoints);
    }

    //Deduct five points from team Rocket
    public void minusFiveForRocket(View v) {
        rocketPoints = rocketPoints + -5;
        displayScoreForRocket(rocketPoints);
    }

    /**
     * Displays the given score for Team Rocket. If score is 75 or more this team will win. If it is 25 or less they lose
     */
    public void displayScoreForRocket(int score) {
        TextView scoreView = findViewById(R.id.team_rocket_score);
        scoreView.setText(String.valueOf(score));

        if (score >= 75) {
            scoreView.setText(String.valueOf("Winner"));
        } else if (score <= 25) {
            scoreView.setText(String.valueOf("Dead"));
        }
    }

    //Add one point for team Spurs
    public void addOneForSpurs(View v) {
        spursPoints = spursPoints + 1;
        displayScoreForSpurs(spursPoints);
    }

    //Deduct five points from team Spurs
    public void minusFiveForSpurs(View v) {
        spursPoints = spursPoints - 5;
        displayScoreForSpurs(spursPoints);

    }

    /**
     * Displays the given score for team Spurs. If score is 75 or more this team will win. If it is 25 or less they lose
     */
    public void displayScoreForSpurs(int score) {
        TextView scoreView = findViewById(R.id.team_spur_score);
        scoreView.setText(String.valueOf(score));

        if (score >= 75) {
            scoreView.setText(String.valueOf("Winner"));
        } else if (score <= 25) {
            scoreView.setText(String.valueOf("Dead"));
        }
    }
}