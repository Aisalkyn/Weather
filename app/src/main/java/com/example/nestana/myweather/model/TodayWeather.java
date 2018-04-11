package com.example.nestana.myweather.model;

import android.os.Parcel;
import android.os.Parcelable;

import static neobis.kaindykant.utils.Constants.addSignToTemp;

/**
 * Created by Ismet on 10/30/2017.
 */

public class TodayWeather implements Parcelable {
    private String temp;
    private String icon;
    private String type;
    private String exact_time;
    private long timestamp;

    protected TodayWeather(Parcel in) {
        temp = in.readString();
        icon = in.readString();
        type = in.readString();
        exact_time = in.readString();
        timestamp = in.readLong();
    }

    public static final Creator<TodayWeather> CREATOR = new Creator<TodayWeather>() {
        @Override
        public TodayWeather createFromParcel(Parcel in) {
            return new TodayWeather(in);
        }

        @Override
        public TodayWeather[] newArray(int size) {
            return new TodayWeather[size];
        }
    };

    public String getTemp() {
        return addSignToTemp(temp);
    }

    public String getIcon() {
        return (icon.length() == 1) ? "0" + icon : icon;
    }

    public String getType() {
        return type;
    }

    public String getExact_time() {
        return exact_time;
    }

    public long getTimestamp() {
        return timestamp;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(temp);
        dest.writeString(icon);
        dest.writeString(type);
        dest.writeString(exact_time);
        dest.writeLong(timestamp);
    }
}
