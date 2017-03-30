package com.armaldia.game.drawer;

public class DrawerItemDM {
    private int iconID;
    private String heading;

    public DrawerItemDM(int iconID, String heading) {
        this.iconID = iconID;
        this.heading = heading;
    }

    public int getIconID() {
        return iconID;
    }

    public String getHeading() {
        return heading;
    }

}
