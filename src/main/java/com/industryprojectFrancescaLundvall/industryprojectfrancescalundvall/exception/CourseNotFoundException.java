package com.industryprojectFrancescaLundvall.industryprojectfrancescalundvall.exception;

public class CourseNotFoundException extends Exception {

    public CourseNotFoundException() {
        super();
    }

    public CourseNotFoundException(String e) {
        super(e);
    }

    public CourseNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public CourseNotFoundException(Throwable cause) {
        super(cause);
    }

    protected CourseNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }


}
