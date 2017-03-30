package com.armaldia.game.drawer;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.armaldia.game.R;

import java.util.LinkedList;

public class DrawerAdapter extends BaseAdapter {

    private LinkedList<DrawerItemDM> drawerItems;
    private Context context;

    public DrawerAdapter(LinkedList<DrawerItemDM> drawerItems, Context context) {
        this.drawerItems = drawerItems;
        this.context = context;
    }

    @Override
    public int getCount() {
        return drawerItems.size();
    }

    @Override
    public Object getItem(int i) {
        return drawerItems.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.drawer_list_item, null);
        }
        DrawerItemDM drawerItem = drawerItems.get(i);
        ImageView iconView = (ImageView) view.findViewById(R.id.drawer_item_icon);
        iconView.setImageResource(drawerItem.getIconID());
        TextView titleView = (TextView) view.findViewById(R.id.drawer_item_text);
        titleView.setText(drawerItem.getHeading());
        return view;
    }
}
