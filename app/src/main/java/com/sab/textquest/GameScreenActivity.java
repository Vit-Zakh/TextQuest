package com.sab.textquest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.Map;

public class GameScreenActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b_north;
    private Button b_south;
    private Button b_east;
    private Button b_west;
    private Button b_quit;

    private TextView locationDescription;

    Location currentLocation;
    Map<Integer, Location> locations;

    Utils utils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        b_north = findViewById(R.id.b_north);
        b_south = findViewById(R.id.b_south);
        b_east = findViewById(R.id.b_east);
        b_west = findViewById(R.id.b_west);
        b_quit = findViewById(R.id.b_quit_gameScreen);

        locationDescription = findViewById(R.id.tv_locationDescription);

        b_north.setOnClickListener(this);
        b_south.setOnClickListener(this);
        b_east.setOnClickListener(this);
        b_west.setOnClickListener(this);
        b_quit.setOnClickListener(this);

            utils = new Utils();

            locations = utils.getLocationsJson(this, "locations.json");

        currentLocation = locations.get(1);
        setPaths(currentLocation.getPathToChoose());

        locationDescription.setText(currentLocation.getLocationDescription());

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case (R.id.b_quit_gameScreen):
                finish();
                break;
            case(R.id.b_north):
                choosePath("N");
                break;
            case(R.id.b_south):
                choosePath("S");
                break;
            case(R.id.b_east):
                choosePath("E");
                break;
            case(R.id.b_west):
                choosePath("W");
                break;
        }
    }

    public void choosePath(String direction){
        currentLocation = locations.get(currentLocation.getPathToChoose().get(direction));
        locationDescription.setText(currentLocation.getLocationDescription());
        setPaths(currentLocation.getPathToChoose());
    }

    public void setPaths(Map<String, Integer> map){
        checkPath(map, "N", b_north);
        checkPath(map, "S", b_south);
        checkPath(map, "W", b_west);
        checkPath(map, "E", b_east);
    }

    public void checkPath(Map<String, Integer> map, String key, Button button){
        if ((!map.containsKey(key))) {
            button.setClickable(false);
            button.setBackgroundResource(R.color.colorNoPath);
        } else {
            button.setClickable(true);
            button.setBackgroundResource(R.color.colorGoodToGo);
        }
    }
    }


