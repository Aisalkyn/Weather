package com.example.nestana.myweather.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Ismet on 10/30/2017.
 */

public class Weather implements Parcelable {
    private ArrayList<DailyWeather> list;
    private ArrayList<TodayWeather> today;


    protected Weather(Parcel in) {
        list = in.createTypedArrayList(DailyWeather.CREATOR);
        today = in.createTypedArrayList(TodayWeather.CREATOR);
    }

    public static final Creator<Weather> CREATOR = new Creator<Weather>() {
        @Override
        public Weather createFromParcel(Parcel in) {
            return new Weather(in);
        }

        @Override
        public Weather[] newArray(int size) {
            return new Weather[size];
        }
    };

    public ArrayList<DailyWeather> getList() {
        return list;
    }

    public ArrayList<TodayWeather> getToday() {
        return today;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeTypedList(list);
        dest.writeTypedList(today);
    }
}
