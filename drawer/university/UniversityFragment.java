package com.armaldia.game.drawer.university;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.armaldia.game.MainActivity;
import com.armaldia.game.R;

public class UniversityFragment extends ListFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        UniversityController universityController = ((MainActivity)getActivity()).getUniversityController();
        UniversityAdapter adapter = new UniversityAdapter(universityController.createCoursesList(), getActivity());
        setListAdapter(adapter);
        return inflater.inflate(R.layout.fragment_university, container, false);
    }
}
