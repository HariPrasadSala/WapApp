package work.smaragdine.warapp.data;

import java.util.ArrayList;

import work.smaragdine.warapp.R;
import work.smaragdine.warapp.models.Item;

public class Gun {

    public ArrayList<Item> getGunList() {
        ArrayList<Item> gunList = new ArrayList<>();
        gunList.add(new Item("AK 47", R.drawable.sergeant_reckless));
        gunList.add(new Item("Snipper",R.drawable.comanche));
        gunList.add(new Item("SMG",R.drawable.cincinnati));
        return gunList;
    }

}
