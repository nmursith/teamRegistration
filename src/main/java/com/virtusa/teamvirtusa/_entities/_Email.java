package com.virtusa.teamvirtusa._entities;

/**
 * Created by delegate on 7/13/17.
 */
public class _Email {
    private boolean available;

    public _Email(boolean available) {
        this.available = available;
    }


    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
