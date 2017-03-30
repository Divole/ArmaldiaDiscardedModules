package com.armaldia.game.drawer.university;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by dovile on 10/11/16.
 */
public class UniversityController {
    private JSONObject universityData;

    public UniversityController() {
    }

    public void setUniversityData(JSONObject universityData) {
        this.universityData = universityData;
    }

    public List<CourseDM> createCoursesList(){
        List<CourseDM> activities = new LinkedList<>();
        try {
            JSONArray array = universityData.getJSONArray("activities");
            for (int i = 0; i< array.length(); i++) {
                CourseDM item = new CourseDM();
                JSONObject obj = array.getJSONObject(i);
                item.setCourseID(Integer.parseInt(obj.getString("CourseID")));
                item.setTitle(obj.getString("Title"));
                item.setDescription(obj.getString("Description"));
                item.setRequiredStatus(Integer.parseInt(obj.getString("RequiredStatus")));
                item.setRequiredLevel(Integer.parseInt(obj.getString("RequiredLevel")));
                item.setIncreaseIntelligence(Double.valueOf(obj.getString("IncreaseIntelligence")));
                item.setIncreaseHunger(Double.valueOf(obj.getString("IncreaseHunger")));
                item.setIncreaseReputation(Double.valueOf(obj.getString("IncreaseReputation")));
                item.setIncreaseExperience(Double.valueOf(obj.getString("IncreaseExperience")));
                item.setIncreaseHunger(Double.valueOf(obj.getString("IncreaseHunger")));
                item.setIncreaseExperience(Double.valueOf(obj.getString("IncreaseExperience")));
                item.setCostEnergy(Double.valueOf(obj.getString("CostEnergy")));
                item.setCostMoney(Integer.parseInt(obj.getString("CostMoney")));
                item.setCostMoneyReal(Integer.parseInt(obj.getString("CostMoneyReal")));
                item.setActive(Integer.parseInt(obj.getString("Active")));
//                item.setCreated(obj.getString("Created"));
                activities.add(item);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return activities;
    }
}
