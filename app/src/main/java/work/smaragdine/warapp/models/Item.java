package work.smaragdine.warapp.models;

import android.media.Image;

public class Item {

    private String name;

    private int image_name;

    private int code;

    public  Item(String name, int image_name, int code) {
        this.name = name;
        this.image_name = image_name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public int getImageName() {
        return image_name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
