package Entity;

import java.util.ArrayList;

public class MenuList {
    private ArrayList<Menu> menuList;

    public MenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }

    public ArrayList<Menu> getMenuList() {
        return this.menuList;
    }

    public void setMenuList(ArrayList<Menu> menuList) {
        this.menuList = menuList;
    }
}
