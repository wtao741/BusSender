package tuxdev.studio.maminasatabus;

import android.text.SpannableString;
import android.text.style.RelativeSizeSpan;

public class Data {
    private boolean isRunning;
    private boolean isFirstTime;

    private double curSpeed;
    private double maxSpeed;

    private double latitude, longitude;
    private onGpsServiceUpdate onGpsServiceUpdate;

    public interface onGpsServiceUpdate {
        public void update();
    }

    public void setOnGpsServiceUpdate(onGpsServiceUpdate onGpsServiceUpdate) {
        this.onGpsServiceUpdate = onGpsServiceUpdate;
    }

    public void update() {
        onGpsServiceUpdate.update();
    }

    public Data() {
        isRunning = false;
        latitude = 0;
        longitude = 0;
        curSpeed = 0;
        maxSpeed = 0;
    }

    public Data(onGpsServiceUpdate onGpsServiceUpdate) {
        this();
        setOnGpsServiceUpdate(onGpsServiceUpdate);
    }

    public SpannableString getMaxSpeed() {
        SpannableString s = new SpannableString(String.format("%.0f", maxSpeed) + "km/h");
        s.setSpan(new RelativeSizeSpan(0.5f), s.length() - 4, s.length(), 0);
        return s;
    }

    public void setCurSpeed(double curSpeed) {
        this.curSpeed = curSpeed;
        if (curSpeed > maxSpeed) {
            maxSpeed = curSpeed;
        }
    }

    public void setLatlong(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public boolean isFirstTime() {
        return isFirstTime;
    }

    public void setFirstTime(boolean isFirstTime) {
        this.isFirstTime = isFirstTime;
    }

    public boolean isRunning() {
        return isRunning;
    }

    public void setRunning(boolean isRunning) {
        this.isRunning = isRunning;
    }


    public double getCurSpeed() {
        return curSpeed;
    }


}

