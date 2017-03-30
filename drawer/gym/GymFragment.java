package com.armaldia.game.drawer.gym;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.armaldia.game.MainActivity;
import com.armaldia.game.R;

public class GymFragment extends ListFragment {

    private GymAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        GymController gymController = ((MainActivity)getActivity()).getGymController();
        adapter = new GymAdapter(gymController.createGymActivitiesList(), getActivity());
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_fitness_center, container, false);
    }
}
