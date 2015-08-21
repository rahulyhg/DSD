package com.example.android.dsd;

/**
 * Created by MEGH on 22/3/2015.
 */
public class FutureDateException extends Exception {
    public String toString(){
        return "Start date cannot be after End date";
    }
}
