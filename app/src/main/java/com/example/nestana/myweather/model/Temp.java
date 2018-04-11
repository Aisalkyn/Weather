package com.example.nestana.myweather.model;

import android.os.Parcel;
import android.os.Parcelable;

import static neobis.kaindykant.utils.Constants.addSignToTemp;

/**
 * Created by Ismet on 10/30/2017.
 */

public class Temp implements Parcelable {
    private String max;
    private String min;

    protected Temp(Parcel in) {
        max = in.readString();
        min = in.readString();
    }

    public static final Creator<Temp> CREATOR = new Creator<Temp>() {
        @Override
        public Temp createFromParcel(Parcel in) {
            return new Temp(in);
        }

        @Override
        public Temp[] newArray(int size) {
            return new Temp[size];
        }
    };

    public String getMax() {
        return addSignToTemp(max);
    }

    public String getMin() {
        return addSignToTemp(min);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(max);
        dest.writeString(min);
    }
}
