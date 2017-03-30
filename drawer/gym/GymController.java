package com.armaldia.game.drawer.gym;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

public class GymController {
    private JSONObject gymData;

    public void setGymData(JSONObject gymData) {
        this.gymData = gymData;
    }
    public List<ExerciseDM> createGymActivitiesList(){
        List<ExerciseDM> activities = new LinkedList<>();
        try {
            JSONArray array = gymData.getJSONArray("activities");
            for (int i = 0; i< array.length(); i++) {
                ExerciseDM item = new ExerciseDM();
                JSONObject obj = array.getJSONObject(i);
                item.setId(Integer.parseInt(obj.getString("ActivityID")));
                item.setTitle(obj.getString("Title"));
                item.setDescription(obj.getString("Description"));
                item.setRequiredStatus(Integer.parseInt(obj.getString("RequiredStatus")));
                item.setRequiredLevel(Integer.parseInt(obj.getString("RequiredLevel")));
                item.setIncreaseStrength(Double.valueOf(obj.getString("IncreaseStrength")));
                item.setIncreaseStaminaLimit(Double.valueOf(obj.getString("IncreaseStaminaLimit")));
                item.setIncreaseEnergyLimit(Double.valueOf(obj.getString("IncreaseEnergyLimit")));
                item.setIncreaseHealthLimit(Double.valueOf(obj.getString("IncreaseHealthLimit")));
                item.setIncreaseMorale(Double.valueOf(obj.getString("IncreaseMorale")));
                item.setIncreaseHunger(Double.valueOf(obj.getString("IncreaseHunger")));
                item.setIncreaseExperience(Double.valueOf(obj.getString("IncreaseExperience")));
                item.setCostStamina(Double.valueOf(obj.getString("CostStamina")));
                item.setCostEnergy(Double.valueOf(obj.getString("CostEnergy")));
                item.setCostMoney(Integer.parseInt(obj.getString("CostMoney")));
                item.setCostMoneyReal(Integer.parseInt(obj.getString("CostMoneyReal")));
                item.setActive(Integer.parseInt(obj.getString("Active")));
                item.setCreated(obj.getString("Created"));
                activities.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return activities;
    }
}
