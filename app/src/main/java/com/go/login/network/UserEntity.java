package com.go.login.network;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/*
UserEntity{
_id*	string
email*	string
createdAt*	string
plan*	{...}
needCard*	boolean
hasTrial	boolean
trialDays	number
}
* */


public class UserEntity {
    @SerializedName("_id")
    @Expose
    private String id;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("createdAt")
    @Expose
    private String createdAt;
    @SerializedName("plan")
    @Expose
    private Object plan;
    @SerializedName("needCard")
    @Expose
    private boolean needCard;
    @SerializedName("hasTrial")
    @Expose
    private boolean hasTrial;
    @SerializedName("trialDays")
    @Expose
    private int trialDays;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getPlan() {
        return plan;
    }

    public void setPlan(Object plan) {
        this.plan = plan;
    }
    public boolean getNeedCard() {
        return needCard;
    }

    public void setNeedCard(boolean needCard) {
        this.needCard = needCard;
    }
    public boolean getHasTrial() {
        return hasTrial;
    }

    public void setHasTrial(boolean hasTrial) {
        this.hasTrial = hasTrial;
    }
    public int getTrialDays() {
        return trialDays;
    }

    public void setTrialDays(int trialDays) {
        this.trialDays = trialDays;
    }

}