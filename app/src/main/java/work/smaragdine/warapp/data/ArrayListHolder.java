package work.smaragdine.warapp.data;

import java.util.ArrayList;

import work.smaragdine.warapp.models.Item;

public class ArrayListHolder {

    public final ArrayList<Item> selectedItemsList = new ArrayList<>();

    private ArrayListHolder() {}

    public static ArrayListHolder getInstance() {
        if( instance == null ) {
            instance = new ArrayListHolder();
        }
        return instance;
    }

    private static ArrayListHolder instance;

}
