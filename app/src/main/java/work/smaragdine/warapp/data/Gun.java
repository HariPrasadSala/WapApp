package work.smaragdine.warapp.data;

import java.util.ArrayList;

import work.smaragdine.warapp.R;
import work.smaragdine.warapp.models.Item;

public class Gun {

    public ArrayList<Item> getGunList() {
        ArrayList<Item> gunList = new ArrayList<>();
        gunList.add(new Item("Kolibri", R.drawable.kolibri, 2));
        gunList.add(new Item("Snipper",R.drawable.snipper, 2));
        gunList.add(new Item("SMG",R.drawable.smg, 2));
        return gunList;
    }

}
