package com.go.login.data.entity;



//{
//statusCode*	number
//        error*	string
//        message	{...}

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

//        }
public class ErrorRegistration {
    public ErrorRegistration(int statusCode, String error, Object massage) {
        this.statusCode = statusCode;
        this.error = error;
        this.massage = massage;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Object getMassage() {
        return massage;
    }

    public void setMassage(Object massage) {
        this.massage = massage;
    }

    @SerializedName("statusCode")
    @Expose
    private int statusCode;
    @SerializedName("error")
    @Expose
    private String error;
    @SerializedName("massage")
    @Expose
    private Object massage;
}
