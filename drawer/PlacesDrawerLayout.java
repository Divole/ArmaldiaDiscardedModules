package com.armaldia.game.drawer;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.armaldia.game.MainActivity;
import com.armaldia.game.toolbar.ArmaldiaToolbar;
import com.armaldia.game.utilities.AppUtilities;

import java.util.LinkedList;

public class PlacesDrawerLayout extends DrawerLayout {

    public static final String job_center = "JOB CENTER";
    public static final String university = "UNIVERSITY";
    public static final String real_estate_agency = "REAL ESTATE AGENCY";
    public static final String city_market = "CITY MARKET";
    public static final String fitness_center = "FITNESS CENTER";
    public static final String hospital = "HOSPITAL";
    public static final String hall_of_fame = "HALL OF FAME";
    private static final String fridge = "FRIDGE";
    private static final String backpack = "BACKPACK";
    private static final String achievements = "ACHIEVEMENTS";
    private static final String referrals = "REFERRALS";


    public PlacesDrawerLayout(Context context) {
        super(context);
    }

    public PlacesDrawerLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PlacesDrawerLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void createMenu(ArmaldiaToolbar toolbar){
        View passport = ((MainActivity)getContext()).findViewById(com.armaldia.game.R.id.passport);
        passport.setPadding(0, AppUtilities.getStatusBarHeight(getContext()), 0, 0);

        LinkedList<DrawerItemDM> list = new LinkedList<>();
        String[] headings = getResources().getStringArray(com.armaldia.game.R.array.drawer_item_headings);
        String[] icons = getResources().getStringArray(com.armaldia.game.R.array.drawer_item_icon_names);

        for (int i = 0; i < headings.length; i++){
            DrawerItemDM item = new DrawerItemDM(getResources().getIdentifier(icons[i],"drawable", ((MainActivity)getContext()).getPackageName()),headings[i]);
            list.add(i,item);
        }

        final DrawerAdapter adapter = new DrawerAdapter(list, getContext());
        ListView drawerList = (ListView) findViewById(com.armaldia.game.R.id.left_drawer_list);
        drawerList.setAdapter(adapter);
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                DrawerItemDM item = (DrawerItemDM) adapter.getItem(position);
                switch (item.getHeading()) {
                    case job_center:
                        ((MainActivity) getContext()).displayJobCenter(job_center);
                        break;
                    case university:
                        ((MainActivity) getContext()).displayUniversity(university);
                        break;
                    case real_estate_agency:
                        ((MainActivity) getContext()).displayRealEstateAgency(real_estate_agency);
                        break;
                    case city_market:
                        ((MainActivity) getContext()).displayCityMarket(city_market);
                        break;
                    case fitness_center:
                        ((MainActivity) getContext()).displayGym(fitness_center);
                        break;
                    case hospital:
                        ((MainActivity) getContext()).displayHospital(hospital);
                        break;
                    case hall_of_fame:
                        ((MainActivity) getContext()).displayHallOfFame(hall_of_fame);
                        break;
                }
            }
        });

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(((MainActivity)getContext()), this, toolbar, com.armaldia.game.R.string.drawer_open, com.armaldia.game.R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                ((MainActivity)getContext()).invalidateOptionsMenu();
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                ((MainActivity)getContext()).invalidateOptionsMenu();
            }
        };
        addDrawerListener(mDrawerToggle);
    }
}
