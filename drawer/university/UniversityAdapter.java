package com.armaldia.game.drawer.university;

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

import java.util.List;

public class UniversityAdapter extends BaseAdapter implements ImageCallbacks {
    private List<CourseDM> universityCourses;
    private Context context;
    private int job_type;

    private static final int REQUIREMENTS = 0;
    private static final int REWARD = 1;

    public UniversityAdapter(List<CourseDM> universityCourses, Context context) {
        this.universityCourses = universityCourses;
        this.context = context;
        this.job_type = job_type;
    }

    @Override
    public int getCount() {
        return universityCourses.size();
    }

    @Override
    public Object getItem(int position) {
        return universityCourses.get(position);
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

        CourseDM item = universityCourses.get(position);
        System.out.println("UNIVERSITY: creating list item " + position);

        TextView contractTitle = (TextView) convertView.findViewById(R.id.title);
        contractTitle.setText(item.getTitle());
//        TextView contractDescription = (TextView) convertView.findViewById(R.id.description);
//        contractDescription.setText(item.getDescription());

        TextView action_btn = (TextView) convertView.findViewById(R.id.action_btn);
        action_btn.setText(context.getResources().getString(R.string.learn));

        LinearLayout requirementsLayout = (LinearLayout) convertView.findViewById(R.id.requirements_layout);
        putRequirements(requirementsLayout, item);

        LinearLayout rewardsLayout = (LinearLayout) convertView.findViewById(R.id.rewards_layout);
        putRewards(rewardsLayout, item);

        if(item.getImg()!= null){
            ImageView contract_img = (ImageView)convertView.findViewById(R.id.contract_img);
            contract_img.setImageDrawable(item.getImg());
        }else{

            String path = "/img/university/courses/" + item.getCourseID() + ".png";
            new GetImageTask(this, path, position).execute();
        }
        return convertView;
    }

    @Override
    public void setImage(Drawable drawable, int position) {
        System.out.println("JOB CENTER: setting image");
        universityCourses.get(position).setImg(drawable);
        notifyDataSetChanged();
    }

    private void putRequirements(LinearLayout parent, CourseDM course){
        parent.removeAllViews();
        int index = 0;
        ArmaldiaCharacter character = ((MainActivity)context).getCharacter();

        if(course.getRequiredStatus() == StatsUtilities.STATUS_ACTIVE){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.STATUS_ACTIVE_ICON);
            boolean valid = course.getRequiredStatus() == character.getStatus();
            View child = StatsUtilities.createChild(context, drawable, "Active", index, REQUIREMENTS, valid);
            index++;
            parent.addView(child);
        }
        if(course.getRequiredLevel() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.LEVEL_STAT_ICON);
            boolean valid = course.getRequiredLevel() == character.getLevel();
            View child = StatsUtilities.createChild(context, drawable, "" + course.getRequiredLevel(), index, REQUIREMENTS, valid);
            index++;
            parent.addView(child);
        }
        if(course.getCostEnergy() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.ENERGY_STAT_ICON);
            boolean valid = course.getCostEnergy() == character.getEnergy();
            View child = StatsUtilities.createChild(context, drawable, "-" + course.getCostEnergy(), index, REQUIREMENTS, valid);
            index++;
            parent.addView(child);
        }
        if(course.getCostMoney() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.CYBERS_BLACK_ICON);
            boolean valid = course.getCostMoney() == character.getMoney();
            View child = StatsUtilities.createChild(context, drawable, "-" + course.getCostMoney(), index, REQUIREMENTS, valid);
            index++;
            parent.addView(child);
        }
    }
    private void putRewards(LinearLayout parent, CourseDM course){

        parent.removeAllViews();
        int index = 0;

        if(course.getIncreaseIntelligence() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.INTELLIGENCE_STAT_ICON);
            double value = course.getIncreaseIntelligence();
            double min= NumberUtility.round(0.5 * value, 1);
            double max = NumberUtility.round(1.5 * value, 1);
            String string = "+"+min+" - "+max;
            View child = StatsUtilities.createChild(context, drawable, string, index, REQUIREMENTS, true);
            index++;
            parent.addView(child);
        }

        if(course.getIncreaseHunger() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.HUNGER_STAT_ICON);
            double value = course.getIncreaseHunger();
            double min= NumberUtility.round(0.5 * value, 1);
            double max = NumberUtility.round(1.5 * value, 1);
            String string = "+"+min+" - "+max;
            View child = StatsUtilities.createChild(context, drawable, string, index, REQUIREMENTS, true);
            index++;
            parent.addView(child);
        }

        if(course.getIncreaseReputation() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.REPUTATION_STAT_ICON);
            double value = course.getIncreaseReputation();
            double min= NumberUtility.round(0.5 * value, 1);
            double max = NumberUtility.round(1.5 * value, 1);
            String string = "+"+min+" - "+max;
            View child = StatsUtilities.createChild(context, drawable, string, index, REQUIREMENTS, true);
            index++;
            parent.addView(child);
        }

        if(course.getIncreaseExperience() > 0){
            Drawable drawable = ImageUtilities.getIcon(context, ImageUtilities.EXPERIENCE_STAT_ICON);
            double value = course.getIncreaseExperience();
            double min= NumberUtility.round(0.5 * value, 1);
            double max = NumberUtility.round(1.5 * value, 1);
            String string = "+"+min+" - "+max;
            View child = StatsUtilities.createChild(context, drawable, string, index, REQUIREMENTS, true);
            index++;
            parent.addView(child);
        }
    }

}
