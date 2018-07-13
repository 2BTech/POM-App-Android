package com.twobtech.pomapp.Models;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BLEPacket implements Serializable{

    public String deviceID = "";
    public int num = 0;//
    public String name = "";
    public Double value = 0.0;
    public String units = "";
    public Double latitude = 0.0;
    public Double longitude = 0.0;
    public Date timestamp = new Date();
    public String comment = "";

    public GasModel gasParent = null;
    public DeviceModel deviceParent = null;

    public List<String> photos = new ArrayList<>();

    public String getTimestampString () {
        DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(timestamp);
    }

    public JSONObject toJSON() {
        JSONObject json = new JSONObject();
        try {
            json.accumulate("deviceID", deviceID);
            json.accumulate("number", num);
            json.accumulate("name", name);
            json.accumulate("value", value);
            json.accumulate("units", units);
            json.accumulate("latitude", latitude);
            json.accumulate("longitude", longitude);
            json.accumulate("timestamp", getTimestampString());
            json.accumulate("comment", comment);
        } catch (JSONException e) {
            e.printStackTrace();
            Log.e("BLEPacket", "ERROR ENCODING JSON");
        }
        return json;
    }

    public JSONObject toJSONv2() {
        JSONObject json = new JSONObject();
        try {
            json.accumulate("app_time", getTimestampString());
            json.accumulate("pam_time", "0000-00-00T00:00");
            json.accumulate("num", num);
            json.accumulate("name", name);
            json.accumulate("unit", units);
            json.accumulate("val", value);

            json.accumulate("comment", comment);

            JSONArray gps = new JSONArray();
            gps.put(latitude);
            gps.put(longitude);
            gps.put(5);
            json.accumulate("gps", gps);

            JSONArray jPh = new JSONArray();
            for (int i = 0; i < photos.size(); i++) {
                //jPh.put(deviceID + "_" + String.valueOf(i) + "_" + getTimestampString());
                jPh.put(photos.get(i));
            }
            json.accumulate("photos", jPh);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return json;
    }

    public BLEPacket()
    {

    }

    public BLEPacket(String json)
    {
        loadJSONv1(json);
    }

    public BLEPacket(String json, int version) {
        switch (version) {
            case 1:
                loadJSONv1(json);
                break;
            case 2:
                loadJSONv2(json);
                break;
            default:
                Log.e("BLEPacket", "Invalid Version Number");
        }
    }

    private void loadJSONv1(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            deviceID = obj.getString("deviceID");
            num = obj.getInt("number");
            name = obj.getString("name");
            value = obj.getDouble("value");
            units = obj.getString("units");
            latitude = obj.getDouble("latitude");
            longitude = obj.getDouble("longitude");
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            timestamp = sdf.parse(obj.getString("timestamp"));
            comment = obj.getString("comment");
        } catch (JSONException e) {
            Log.e("BLEPacket", "ERROR DECODING JSON ERROR");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
            Log.e("BLEPacket", "ERROR DECODING JSON DATE");
        }
    }

    private void loadJSONv2(String json) {
        try {
            JSONObject obj = new JSONObject(json);
            DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            timestamp = sdf.parse(obj.getString("app_time"));
            num = obj.getInt("num");
            name = obj.getString("name");
            units = obj.getString("unit");
            value = obj.getDouble("val");
            comment = obj.getString("comment");
            JSONArray jPh = obj.getJSONArray("photos");
            for (int i = 0; i < jPh.length(); i++) {
                photos.add(jPh.getString(i));
            }

            JSONArray gps = obj.getJSONArray("gps");
            if (gps.length() == 3) {
                latitude = gps.getDouble(0);
                longitude = gps.getDouble(1);
            } else {
                Log.e("BLEPacket", "Could not decode GPS data!");
            }

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
