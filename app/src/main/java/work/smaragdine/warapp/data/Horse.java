package work.smaragdine.warapp.data;

import java.util.ArrayList;

import work.smaragdine.warapp.R;
import work.smaragdine.warapp.models.Item;

public class Horse {

    public ArrayList<Item> getHorseList() {
        ArrayList<Item> horseList = new ArrayList<>();
        horseList.add(new Item("Sergeant Reckless", R.drawable.sergeant_reckless));
        horseList.add(new Item("Comanche",R.drawable.comanche));
        horseList.add(new Item("Cincinnati",R.drawable.cincinnati));
        return horseList;
    }

}
