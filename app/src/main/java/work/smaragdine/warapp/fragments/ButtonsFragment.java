package work.smaragdine.warapp.fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import work.smaragdine.warapp.R;

public class ButtonsFragment extends Fragment {

    private static String TAG = "work.smaragdine.warapp.ButtonsFragment";
    private OnButtonClickListner listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        // Get a reference to the parent Activity.
        Log.d(TAG, "onAttach");
        if (context instanceof OnButtonClickListner) {
            this.listener = (OnButtonClickListner) context;
        }
    }

    // Called to do the initial creation of the Fragment.
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Initialize the Fragment.
        Log.d(TAG, "onCreate");
    }

    // Called once the Fragment has been created in order for it to
    // create its user interface.
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.d(TAG, "onCreateView");
        return inflater.inflate(R.layout.buttons_fragment, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        Log.d(TAG, "onViewCreated");
        Button selectHorseButton = (Button) view.findViewById(R.id.selectHorse);
        selectHorseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onHorseButtonClick();
            }
        });

        Button selectGunButton = (Button) view.findViewById(R.id.selectGun);
        selectGunButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Select Gun Clicked", Toast.LENGTH_SHORT).show();
            }
        });

        Button selectTeamButton = (Button) view.findViewById(R.id.selectTeam);
        selectTeamButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onTeamButtonClick();
            }
        });

        Button addAmmunitionButton = (Button) view.findViewById(R.id.addAmmunition);
        addAmmunitionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Add Ammunition Clicked", Toast.LENGTH_SHORT).show();
            }
        });

    }

    // Called once the parent Activity and the Fragment's UI have
    // been created.
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // Complete the Fragment initialization � particularly anything
        // that requires the parent Activity to be initialized or the
        // Fragment's view to be fully inflated.
        Log.d(TAG, "onActivityCreated");
    }

    // Called at the start of the visible lifetime.
    @Override
    public void onStart() {
        super.onStart();
        // Apply any required UI change now that the Fragment is visible.
        Log.d(TAG, "onStart");
    }

    // Called at the start of the active lifetime.
    @Override
    public void onResume() {
        super.onResume();
        // Resume any paused UI updates, threads, or processes required
        // by the Fragment but suspended when it became inactive.
        Log.d(TAG, "onResume");
    }

    // Called at the end of the active lifetime.
    @Override
    public void onPause() {
        // Suspend UI updates, threads, or CPU intensive processes
        // that don't need to be updated when the Activity isn't
        // the active foreground activity.
        // Persist all edits or state changes
        // as after this call the process is likely to be killed.
        super.onPause();
        Log.d(TAG, "onPause");
    }

    // Called to save UI state changes at the
    // end of the active lifecycle.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save UI state changes to the savedInstanceState.
        // This bundle will be passed to onCreate, onCreateView, and
        // onCreateView if the parent Activity is killed and restarted.
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG, "onSaveInstanceState");
    }

    // Called at the end of the visible lifetime.
    @Override
    public void onStop() {
        // Suspend remaining UI updates, threads, or processing
        // that aren't required when the Fragment isn't visible.
        super.onStop();
        Log.d(TAG, "onStop");
    }

    // Called when the Fragment's View has been detached.
    @Override
    public void onDestroyView() {
        // Clean up resources related to the View.
        super.onDestroyView();
        Log.d(TAG, "onDestroyView");
    }

    // Called at the end of the full lifetime.
    @Override
    public void onDestroy() {
        // Clean up any resources including ending threads,
        // closing database connections etc.
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    // Called when the Fragment has been detached from its parent Activity.
    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG, "onDetach");
    }

    public interface OnButtonClickListner {
        void onHorseButtonClick();
        void onTeamButtonClick();
    }

}
