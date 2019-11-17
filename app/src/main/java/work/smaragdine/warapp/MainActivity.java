package work.smaragdine.warapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.Toast;

import work.smaragdine.warapp.data.Horse;
import work.smaragdine.warapp.fragments.ButtonsFragment;
import work.smaragdine.warapp.fragments.SelectItemsFragment;
import work.smaragdine.warapp.fragments.TableViewFragment;

public class MainActivity extends AppCompatActivity implements ButtonsFragment.OnButtonClickListner, SelectItemsFragment.OnItemSelectedListener {

    private static String TAG = "work.smaragdine.warapp.MainActivity";
    private static final int REQUEST_SELECT_CONTACT = 1;
    private static final int HORSE = 1;
    private static final int GUN = 2;
    private static final int AMMUNITION =3;
    private static final int TEAM =4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            ButtonsFragment buttonsFragment = new ButtonsFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.add(R.id.frameLayout, buttonsFragment);
            fragmentTransaction.commit();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume");
    }

    @Override
    protected void onStop() {
        Log.d(TAG, "onStop");
        super.onStop();
    }

    @Override
    protected void onPause() {
        Log.d(TAG, "onPause");
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        Log.d(TAG, "onDestroy");
        super.onDestroy();
    }

    /*Get called when select buttons clicked in buttons fragment*/
    @Override
    public void onButtonClick(int code) {
        Bundle args = new Bundle();
        if (code == HORSE) {
            args.putInt("code", HORSE);
        } else if (code == GUN) {
            args.putInt("code", GUN);
        } else if (code == AMMUNITION) {
            args.putInt("code", AMMUNITION);
        }
        SelectItemsFragment selectItemsFragment = new SelectItemsFragment();
        selectItemsFragment.setArguments(args);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, selectItemsFragment);
        fragmentTransaction.commit();
    }

    /*Get called when select team button clicked in buttons fragment*/
    @Override
    public void onTeamButtonClick() {
        Toast.makeText(this, "onTeamButtonClick",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }

    @Override
    public void onViewTableButtonClick() {
        Toast.makeText(this, "onViewTableButtonClick",Toast.LENGTH_SHORT).show();
        TableViewFragment tableViewFragment = new TableViewFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, tableViewFragment);
        fragmentTransaction.commit();
    }


    /*Gets called when user selects any items from the list of Horses, Guns, Ammunition*/
    @Override
    public void onItemSelectedListner(int position, int code) {
        /*Toast.makeText(this, "Called By Fragment A: position - "+ position, Toast.LENGTH_SHORT).show();*/
        Bundle args = new Bundle();
        args.putInt("position", position);
        args.putInt("code", code);
        ButtonsFragment buttonsFragment = new ButtonsFragment();
        buttonsFragment.setArguments(args);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, buttonsFragment);
        fragmentTransaction.commit();
    }

    /*Get called when selected a contact from contacts app*/
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_SELECT_CONTACT && resultCode == RESULT_OK) {
            Uri contactUri = data.getData();
            String[] projection = new String[]{ContactsContract.CommonDataKinds.Nickname.DISPLAY_NAME};
            Cursor cursor = getContentResolver().query(contactUri, projection,
                    null, null, null);
            // If the cursor returned is valid, get the phone number
            if (cursor != null && cursor.moveToFirst()) {
                int nameIndex = cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME);
                String name = cursor.getString(nameIndex);
                Toast.makeText(this, "Result Ok Name:"+name, Toast.LENGTH_SHORT).show();
                Bundle args = new Bundle();
                args.putInt("code", TEAM);
                args.putString("contact_name", name);
                ButtonsFragment buttonsFragment = new ButtonsFragment();
                buttonsFragment.setArguments(args);
                FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.frameLayout, buttonsFragment);
                fragmentTransaction.commit();
            }
        } else
            Toast.makeText(this, "Problem while fetching contact.", Toast.LENGTH_SHORT).show();
    }

}
