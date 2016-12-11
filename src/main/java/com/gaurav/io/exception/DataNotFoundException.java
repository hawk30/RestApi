package com.gaurav.io.exception;

/**
 * Created by oracle on 4/12/16.
 */
public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException(String message) {
        super(message);
    }
}
