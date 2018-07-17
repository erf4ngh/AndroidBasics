package com.erfan.android.courtcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int ScoreTeamA = 0;
    int ScoreTeamB = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_a_score);
        scoreView.setText(String.valueOf(score));
    }
    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = (TextView) findViewById(R.id.team_b_score);
        scoreView.setText(String.valueOf(score));
    }
    public void threePoints(View v){
        ScoreTeamA = ScoreTeamA + 3;
        displayForTeamA(ScoreTeamA);
    }
    public void twoPoints(View v){
        ScoreTeamA = ScoreTeamA + 2;
        displayForTeamA(ScoreTeamA);
    }
    public void free(View v){
        ScoreTeamA = ScoreTeamA + 1;
        displayForTeamA(ScoreTeamA);
    }
    public void threePointsB(View v){
        ScoreTeamB = ScoreTeamB + 3;
        displayForTeamB(ScoreTeamB);
    }
    public void twoPointsB(View v){
        ScoreTeamB = ScoreTeamB + 2;
        displayForTeamB(ScoreTeamB);
    }
    public void freeB(View v){
        ScoreTeamB = ScoreTeamB + 1;
        displayForTeamB(ScoreTeamB);
    }
    public void reset(View v){
        ScoreTeamA = 0;
        ScoreTeamB = 0;
        displayForTeamA(ScoreTeamA);
        displayForTeamB(ScoreTeamB);
    }
}
