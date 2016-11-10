package hu.paprikapp.husi;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by szugyi on 10/11/16.
 */
public class AlcoholVolume implements Parcelable{
    private double alcohol;
    private int volume;

    public AlcoholVolume() {

    }

    private AlcoholVolume(Parcel in) {
        alcohol = in.readDouble();
        volume = in.readInt();
    }

    public double getAlcohol() {
        return alcohol;
    }

    public void setAlcohol(double alcohol) {
        this.alcohol = alcohol;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return String.format("%s ml - %s%%", volume, alcohol);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        out.writeDouble(alcohol);
        out.writeInt(volume);
    }

    public static final Parcelable.Creator<AlcoholVolume> CREATOR
            = new Parcelable.Creator<AlcoholVolume>() {
        public AlcoholVolume createFromParcel(Parcel in) {
            return new AlcoholVolume(in);
        }

        public AlcoholVolume[] newArray(int size) {
            return new AlcoholVolume[size];
        }
    };
}
