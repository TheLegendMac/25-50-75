package com.macrealstudios.practiceset2;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int teamACash = 0;
    int teamBCash = 0;
    //Current Acc, last, and value with gravity
    private SensorManager sm;
    private float acelVal, acelLast, shake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sm.registerListener(sensorListener, sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_NORMAL);

        acelVal = SensorManager.GRAVITY_EARTH;
        acelLast = SensorManager.GRAVITY_EARTH;
        shake = 0.00f;

    }

    public void add1000ForTeamA(View v) {
        teamACash = teamACash + 1000;
        displayForTeamA(teamACash);
    }

    public void add100ForTeamA(View v) {
        teamACash = teamACash + 100;
        displayForTeamA(teamACash);
    }

    public void add50ForTeamA(View v) {
        teamACash = teamACash + 50;
        displayForTeamA(teamACash);
    }

    /**
     * Displays the given score for Team A.
     */
    public void displayForTeamA(int score) {
        TextView scoreView = findViewById(R.id.teamAScore);
        scoreView.setText(String.valueOf(score));
    }

    public void add1000ForTeamB(View v) {
        teamBCash = teamBCash + 1000;
        displayForTeamB(teamBCash);
    }

    public void add100ForTeamB(View v) {
        teamBCash = teamBCash + 100;
        displayForTeamB(teamBCash);
    }

    public void add50ForTeamB(View v) {
        teamBCash = teamBCash + 50;
        displayForTeamB(teamBCash);
    }

    /**
     * Displays the given score for Team B.
     */
    public void displayForTeamB(int score) {
        TextView scoreView = findViewById(R.id.teamBScore);
        scoreView.setText(String.valueOf(score));
    }

    private final SensorEventListener sensorListener = new SensorEventListener() {
        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float x = sensorEvent.values[0];
            float y = sensorEvent.values[1];
            float z = sensorEvent.values[2];
            acelLast = acelVal;
            acelVal = (float) Math.sqrt((double) (x * x + y * y + z * z));
            float delta = acelVal - acelLast;
            shake = shake * 0.9f + delta;

            if (shake > 12) {
                teamACash = 0;
                teamBCash = 0;
                displayForTeamA(teamACash);
                displayForTeamB(teamBCash);

                Toast toast = Toast.makeText(MainActivity.this, "Money Cleared!",Toast.LENGTH_SHORT);
                toast.show();
            }

        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {

        }
    };
}