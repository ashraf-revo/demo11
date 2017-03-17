package com.example.Model;

/**
 * Created by Ashraf Atef on 6/22/2016.
 */
public class Near_Request {
    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Long getStart_id() {
        return start_id;
    }

    public void setStart_id(Long start_id) {
        this.start_id = start_id;
    }

    public Long getEnd_id() {
        return end_id;
    }

    public void setEnd_id(Long end_id) {
        this.end_id = end_id;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    double longitude ;
    double latitude ;
    Long start_id ;
    Long end_id ;
    int counter ;
    int size ;
}
