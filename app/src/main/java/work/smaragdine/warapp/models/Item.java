package work.smaragdine.warapp.models;

import android.media.Image;

public class Item {

    private String name;

    private int image_name;

    public  Item(String name, int image_name) {
        this.name = name;
        this.image_name = image_name;
    }

    public String getName() {
        return name;
    }

    public int getImageName() {
        return image_name;
    }

}
