package com.armaldia.game.drawer.gym;


import android.graphics.drawable.Drawable;

public class ExerciseDM {

    private int id = 0;
    private String title = null;
    private String description = null;
    private int requiredStatus = 0;
    private int requiredLevel = 0;
    private double increaseStrength = 0;
    private double increaseStaminaLimit = 0; //":"0",
    private double increaseEnergyLimit = 0;//":"0",
    private double increaseHealthLimit = 0; //":"0",
    private double increaseMorale = 0; //":"1",
    private double increaseHunger = 0; //":"3",
    private double increaseExperience = 0; //":"3",
    private double costStamina = 0; //":"1",
    private double costEnergy = 0; //":"5",
    private int costMoney = 0; //":"50",
    private int costMoneyReal = 0; //":"0",
    private int active = 0; //":"1",
    private String created  = null; //":"2015-05-28 15:22:49"
    private Drawable img= null;


    public ExerciseDM() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getRequiredStatus() {
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

    public double getIncreaseStrength() {
        return increaseStrength;
    }

    public void setIncreaseStrength(double increaseStrength) {
        this.increaseStrength = increaseStrength;
    }

    public double getIncreaseStaminaLimit() {
        return increaseStaminaLimit;
    }

    public void setIncreaseStaminaLimit(double increaseStaminaLimit) {
        this.increaseStaminaLimit = increaseStaminaLimit;
    }

    public double getIncreaseEnergyLimit() {
        return increaseEnergyLimit;
    }

    public void setIncreaseEnergyLimit(double increaseEnergyLimit) {
        this.increaseEnergyLimit = increaseEnergyLimit;
    }

    public double getIncreaseHealthLimit() {
        return increaseHealthLimit;
    }

    public void setIncreaseHealthLimit(double increaseHealthLimit) {
        this.increaseHealthLimit = increaseHealthLimit;
    }

    public double getIncreaseMorale() {
        return increaseMorale;
    }

    public void setIncreaseMorale(double increaseMorale) {
        this.increaseMorale = increaseMorale;
    }

    public double getIncreaseHunger() {
        return this.increaseHunger;
    }

    public void setIncreaseHunger(double increaseHunger) {
        this.increaseHunger = increaseHunger;
    }

    public double getIncreaseExperience() {
        return increaseExperience;
    }

    public void setIncreaseExperience(double increaseExperience) {
        this.increaseExperience = increaseExperience;
    }

    public double getCostStamina() {
        return costStamina;
    }

    public void setCostStamina(double costStamina) {
        this.costStamina = costStamina;
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

    public double getCostMoneyReal() {
        return costMoneyReal;
    }

    public void setCostMoneyReal(int costMoneyReal) {
        this.costMoneyReal = costMoneyReal;
    }

    public double getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public Drawable getImg() {
        return img;
    }

    public void setImg(Drawable img) {
        this.img = img;
    }
}
