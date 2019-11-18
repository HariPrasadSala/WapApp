package work.smaragdine.warapp.data;

import java.util.ArrayList;

import work.smaragdine.warapp.R;
import work.smaragdine.warapp.models.Item;

public class Ammunition {

    public ArrayList<Item> getAmmunitionList() {
        ArrayList<Item> ammunitionList = new ArrayList<>();
        ammunitionList.add(new Item("Bullets", R.drawable.bullets));
        ammunitionList.add(new Item("Armor",R.drawable.armor));
        ammunitionList.add(new Item("Night Vision",R.drawable.night_vision));
        return ammunitionList;
    }

}
