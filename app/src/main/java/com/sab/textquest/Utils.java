package com.sab.textquest;

import android.content.Context;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

public class Utils {




    public Map<Integer, Location> getLocationsJson(Context context, String fileName) {
        String locationsJsonString;
        Map<Integer, Location> locations = new HashMap<>();

        try {
            InputStream is = context.getAssets().open(fileName);

            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            locationsJsonString = new String(buffer, "UTF-8");

            JSONArray arr = new JSONArray(locationsJsonString);

            for (int i = 0; i < arr.length(); i++){
                JSONObject obj = (JSONObject) arr.get(i);
                int locId = obj.getInt("id");
                String locDescr = obj.getString("locationDescription");
                Map<String, Integer> locExits = new HashMap<>();

                if(!obj.isNull("northPath")){
                    locExits.put("N", obj.getInt("northPath"));}

                if(!obj.isNull("southPath")){
                        locExits.put("S", obj.getInt("southPath"));}

                if(!obj.isNull("eastPath")){
                        locExits.put("E", obj.getInt("eastPath"));}

                if(!obj.isNull("westPath")){
                        locExits.put("W", obj.getInt("westPath"));}

                Location location = new Location(locId, locDescr);
                location.setPathToChoose(locExits);

                locations.put(locId, location);

            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (
                JSONException e) {
            e.printStackTrace();
        }
        return locations;
    }
}
