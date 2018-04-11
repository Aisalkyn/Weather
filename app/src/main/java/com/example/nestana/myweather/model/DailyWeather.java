package com.example.nestana.myweather.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Ismet on 10/30/2017.
 */

public class DailyWeather implements Parcelable{
    private String date;
    private Temp temp;
    private long timestamp;

    protected DailyWeather(Parcel in) {
        date = in.readString();
        temp = in.readParcelable(Temp.class.getClassLoader());
        timestamp = in.readLong();
    }

    public static final Creator<DailyWeather> CREATOR = new Creator<DailyWeather>() {
        @Override
        public DailyWeather createFromParcel(Parcel in) {
            return new DailyWeather(in);
        }

        @Override
        public DailyWeather[] newArray(int size) {
            return new DailyWeather[size];
        }
    };

    public String getDate() {
        return date;
    }

    public Temp getTemp() {
        return temp;
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
        dest.writeString(date);
        dest.writeParcelable(temp, flags);
        dest.writeLong(timestamp);
    }
}
