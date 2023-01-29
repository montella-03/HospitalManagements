package com.example.Project.error;
public class HospitalNotFoundException extends Exception{
    public HospitalNotFoundException() {
        super();
    }

    public HospitalNotFoundException(String message) {
        super(message);
    }

    public HospitalNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HospitalNotFoundException(Throwable cause) {
        super(cause);
    }

    protected HospitalNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
