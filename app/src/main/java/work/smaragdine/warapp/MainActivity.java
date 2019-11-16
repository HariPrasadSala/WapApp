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

import work.smaragdine.warapp.fragments.ButtonsFragment;
import work.smaragdine.warapp.fragments.SelectItemsFragment;

public class MainActivity extends AppCompatActivity implements ButtonsFragment.OnButtonClickListner, SelectItemsFragment.OnItemSelectedListener {

    private static String TAG = "work.smaragdine.warapp.MainActivity";
    private static final int REQUEST_SELECT_CONTACT = 1;

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

    /*Get called when select horse button clicked in buttons fragment*/
    @Override
    public void onHorseButtonClick() {
        Toast.makeText(this, "onSelectHorseButtonClick",Toast.LENGTH_SHORT).show();
        SelectItemsFragment selectItemsFragment = new SelectItemsFragment();
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, selectItemsFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    /*Get called when select team button clicked in buttons fragment*/
    @Override
    public void onTeamButtonClick() {
        Toast.makeText(this, "onSelectHorseButtonClick",Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, REQUEST_SELECT_CONTACT);
        }
    }

    @Override
    public void onItemSelectedListner(int position) {
        /*Toast.makeText(this, "Called By Fragment A: position - "+ position, Toast.LENGTH_SHORT).show();*/
        Bundle args = new Bundle();
        args.putInt("position", position);
        ButtonsFragment buttonsFragment = new ButtonsFragment();
        buttonsFragment.setArguments(args);
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout, buttonsFragment);
        fragmentTransaction.addToBackStack(null);
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
            }
        } else
            Toast.makeText(this, "Problem while fetching contact.", Toast.LENGTH_SHORT).show();
    }

}
