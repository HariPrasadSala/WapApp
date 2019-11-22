package work.smaragdine.warapp.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class WarUpdatesListener extends BroadcastReceiver {

    private static String TAG = "com.smaragdine.work.WarUpdatesListener";

    /*Parameter to collect the updates and stages of war.*/
    public static final String STATUS = "STATUS";

    /*Intent Filter*/
    public static final String WAR_STATUS = "com.smaragdine.work.WAR_STATUS";

    @Override
    public void onReceive(Context context, Intent intent) {
        String status = intent.getStringExtra(STATUS);
        Log.d(TAG, status);
    }

}
