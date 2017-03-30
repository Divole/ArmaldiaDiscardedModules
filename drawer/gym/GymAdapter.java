package com.armaldia.game.drawer.gym;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.armaldia.game.utilities.ImageUtilities;
import com.armaldia.game.MainActivity;
import com.armaldia.game.utilities.NumberUtility;
import com.armaldia.game.R;
import com.armaldia.game.callbacks.ImageCallbacks;
import com.armaldia.game.character.ArmaldiaCharacter;
import com.armaldia.game.GetImageTask;
import com.armaldia.game.utilities.StatsUtilities;
import com.armaldia.game.drawer.gym.async_task.ExerciseAsyncTask;

import java.util.List;

public class GymAdapter extends BaseAdapter implements ImageCallbacks {
    private List<ExerciseDM> gymActivities;
    private Context context;
    private int job_type;

    private static final int REQUIREMENTS = 0;
    private static final int REWARD = 1;

    public GymAdapter(List<ExerciseDM> gymActivities, Context context) {
        this.gymActivities = gymActivities;
        this.context = context;
        this.job_type = job_type;
    }

    @Override
    public int getCount() {
        return gymActivities.size();
    }

    @Override
    public Object getItem(int position) {
        return gymActivities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.universal_list_item, null);
        }

        LinearLayout contract_container = (LinearLayout) convertView.findViewById(R.id.container);
        FrameLayout.LayoutParams layoutParams= (FrameLayout.LayoutParams) contract_container.getLayoutParams();
        int dp_5 = (int) context.getResources().getDimension(R.dimen.normal_5dp);
        int dp_95 = (int) context.getResources().getDimension(R.dimen.normal_95dp);

        if(position == 0){
            layoutParams.setMargins(dp_5,dp_95,dp_5,dp_5);
        }else{
            layoutParams.setMargins(dp_5, 0, dp_5, dp_5);
        }
        contract_container.setLayoutParams(layoutParams);

        final ExerciseDM item = gymActivities.get(position);
        System.out.println("GYM: creating list item " + position);

        TextView contractTitle = (TextView) convertView.findViewById(R.id.title);
        contractTitle.setText(item.getTitle());

        TextView action_btn = (TextView) convertView.findViewById(R.id.action_btn);
        action_btn.setText(context.getResources().getString(R.string.exercise));
        action_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new ExerciseAsyncTask(context, item.getId()).execute();
            }
        });

        LinearLayout requirementsLayout = (LinearLayout) convertView.findViewById(R.id.requirements_layout);
        putRequirements(requirementsLayout, item);

        LinearLayout rewardsLayout = (LinearLayout) convertView.findViewById(R.id.rewards_layout);
        putRewards(rewardsLayout, item);

        if(item.getImg()!= null){
            ImageView contract_img = (ImageView)convertView.findViewById(R.id.contract_img);
            contract_img.setImageDrawable(item.getImg());
        }else{

            String path = "/img/gym/activities/" + item.getId() + ".png";
            new GetImageTask(this, path, position).execute();
        }
        return convertView;
    }

    @Override
    public void setImage(Drawable drawable, int position) {
        System.out.println("JOB CENTER: setting image");
        gymActivities.get(position).setImg(drawable);
        notifyDataSetChanged();
    }

    private void putRequirements(LinearLayout parent, ExerciseDM activity){
        parent.removeAllViews();
        int index = 0;
        ArmaldiaCharacter character = ((MainActivity)context).getCharacter();

        if(activity.getRequiredStatus() == StatsUtilities.STATUS_ACTIVE){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.STATUS_ACTIVE_ICON);
            boolean valid = activity.getRequiredStatus() == character.getStatus();
            View child = StatsUtilities.createChild(context, drawable, "Active", index, REQUIREMENTS, valid);
            index++;
            parent.addView(child);
        }
        if(activity.getRequiredLevel() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.LEVEL_STAT_ICON);
            boolean valid = activity.getRequiredLevel() <= character.getLevel();
            View child = StatsUtilities.createChild(context, drawable, "" + activity.getRequiredLevel(), index, REQUIREMENTS, valid);
            index++;
            parent.addView(child);
        }
        if(activity.getIncreaseHunger() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.HUNGER_STAT_ICON);
            int value = (int) activity.getIncreaseHunger();
            String string = "-"+value;
            boolean valid = activity.getIncreaseHunger() <= character.getHunger();
            View child = StatsUtilities.createChild(context, drawable, string, index, REQUIREMENTS, valid);
            index++;
            parent.addView(child);
        }
        if(activity.getCostStamina() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.STAMINA_STAT_ICON);
            int value = (int) activity.getCostStamina();
            String string = "-"+value;
            boolean valid = activity.getCostStamina() <= character.getStamina();
            View child = StatsUtilities.createChild(context, drawable, "" + string, index, REQUIREMENTS, valid);
            index++;
            parent.addView(child);
        }
        if(activity.getCostEnergy() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.ENERGY_STAT_ICON);
            int value = (int) activity.getCostEnergy();
            String string = "-"+value;
            boolean valid = activity.getCostEnergy() <= character.getEnergy();
            View child = StatsUtilities.createChild(context, drawable, "" + string, index, REQUIREMENTS, valid);
            index++;
            parent.addView(child);
        }
        if(activity.getCostMoney() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.CYBERS_BLACK_ICON);
            int value = activity.getCostMoney();
            String string = "-"+value;
            boolean valid = activity.getCostMoney() <= character.getMoney();
            View child = StatsUtilities.createChild(context, drawable, "" + string, index, REQUIREMENTS, valid);
            index++;
            parent.addView(child);
        }
    }

    private void putRewards(LinearLayout parent, ExerciseDM activity){

        parent.removeAllViews();
        int index = 0;

        if(activity.getIncreaseStrength() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.STRENGTH_STAT_ICON);
            double value = activity.getIncreaseStrength();
            double min= NumberUtility.round(0.5 * value, 1);
            double max = NumberUtility.round(1.5 * value, 1);
            String string = "+"+min+" - "+max;
            View child = StatsUtilities.createChild(context, drawable, string, index, REQUIREMENTS, true);
            index++;
            parent.addView(child);
        }

        if(activity.getIncreaseStaminaLimit() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.STAMINA_STAT_ICON);
            double value = activity.getIncreaseStaminaLimit();
            double min= NumberUtility.round(0.5 * value, 1);
            double max = NumberUtility.round(1.5 * value, 1);
            String string = "+"+min+" - "+max;
            View child = StatsUtilities.createChild(context, drawable, string, index, REQUIREMENTS, true);
            index++;
            parent.addView(child);
        }

        if(activity.getIncreaseEnergyLimit() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.ENERGY_STAT_ICON);
            double value = activity.getIncreaseEnergyLimit();
            double min= NumberUtility.round(0.5 * value, 1);
            double max = NumberUtility.round(1.5 * value, 1);
            String string = "+"+min+" - "+max;
            View child = StatsUtilities.createChild(context, drawable, string, index, REQUIREMENTS, true);
            index++;
            parent.addView(child);
        }

        if(activity.getIncreaseHealthLimit() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.HEALTH_STAT_ICON);
            double value = activity.getIncreaseHealthLimit();
            double min= NumberUtility.round(0.5 * value, 1);
            double max = NumberUtility.round(1.5 * value, 1);
            String string = "+"+min+" - "+max;
            View child = StatsUtilities.createChild(context, drawable, string, index, REQUIREMENTS, true);
            index++;
            parent.addView(child);
        }
        if(activity.getIncreaseMorale() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.MORALE_STAT_ICON);
            double value = activity.getIncreaseMorale();
            double min= NumberUtility.round(0.5 * value, 1);
            double max = NumberUtility.round(1.5 * value, 1);
            String string = "+"+min+" - "+max;
            View child = StatsUtilities.createChild(context, drawable, string, index, REQUIREMENTS, true);
            index++;
            parent.addView(child);
        }
        if(activity.getIncreaseExperience() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.EXPERIENCE_STAT_ICON);
            double value = activity.getIncreaseExperience();
            double min= NumberUtility.round(0.5 * value, 1);
            double max = NumberUtility.round(1.5 * value, 1);
            String string = "+"+min+" - "+max;
            View child = StatsUtilities.createChild(context, drawable, string, index, REQUIREMENTS, true);
            index++;
            parent.addView(child);
        }
    }
}
