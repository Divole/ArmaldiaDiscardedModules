package com.armaldia.game.drawer.university;

import android.graphics.drawable.Drawable;

public class CourseDM {
    private int courseID; //":"1",
    private String title; //":"Basic anatomy",
    private String Description; //":"Anatomy is the branch of biology...",
    private int requiredCharacterTypes; //":"[1][2][3][4]",
    private int requiredCharacterClasses; //":"[1][2][3][4][5][6]",
    private int requiredStatus; //":"1",
    private int requiredLevel; //":"1",
    private double increaseIntelligence; //":"1",
    private double increaseHunger; //":"2",
    private double increaseReputation; //":"2",
    private double increaseExperience; //":"5",
    private double costEnergy; //":"5",
    private int costMoney; //":"50",
    private int costMoneyReal; //":"0",
    private int active; //":"1",
    private int created; //":"2015-05-28 13:46:35"
    private Drawable img= null;

    public CourseDM() {}

    public int getCourseID() {
        return courseID;
    }

    public void setCourseID(int courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public int getRequiredCharacterTypes() {
        return requiredCharacterTypes;
    }

    public void setRequiredCharacterTypes(int requiredCharacterTypes) {
        this.requiredCharacterTypes = requiredCharacterTypes;
    }

    public int getRequiredCharacterClasses() {
        return requiredCharacterClasses;
    }

    public void setRequiredCharacterClasses(int requiredCharacterClasses) {
        this.requiredCharacterClasses = requiredCharacterClasses;
    }

    public int getRequiredStatus() {
        return requiredStatus;
    }

    public void setRequiredStatus(int requiredStatus) {
        this.requiredStatus = requiredStatus;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public double getIncreaseIntelligence() {
        return increaseIntelligence;
    }

    public void setIncreaseIntelligence(double increaseIntelligence) {
        this.increaseIntelligence = increaseIntelligence;
    }

    public double getIncreaseHunger() {
        return increaseHunger;
    }

    public void setIncreaseHunger(double increaseHunger) {
        this.increaseHunger = increaseHunger;
    }

    public double getIncreaseReputation() {
        return increaseReputation;
    }

    public void setIncreaseReputation(double increaseReputation) {
        this.increaseReputation = increaseReputation;
    }

    public double getIncreaseExperience() {
        return increaseExperience;
    }

    public void setIncreaseExperience(double increaseExperience) {
        this.increaseExperience = increaseExperience;
    }

    public double getCostEnergy() {
        return costEnergy;
    }

    public void setCostEnergy(double costEnergy) {
        this.costEnergy = costEnergy;
    }

    public int getCostMoney() {
        return costMoney;
    }

    public void setCostMoney(int costMoney) {
        this.costMoney = costMoney;
    }

    public int getCostMoneyReal() {
        return costMoneyReal;
    }

    public void setCostMoneyReal(int costMoneyReal) {
        this.costMoneyReal = costMoneyReal;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public int getCreated() {
        return created;
    }

    public void setCreated(int created) {
        this.created = created;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }

}
