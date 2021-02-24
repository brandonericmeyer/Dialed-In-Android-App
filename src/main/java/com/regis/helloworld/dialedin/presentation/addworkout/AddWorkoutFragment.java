package com.regis.helloworld.dialedin.presentation.addworkout;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.regis.helloworld.dialedin.R;
import com.regis.helloworld.dialedin.domain.Workout;
import com.regis.helloworld.dialedin.services.WorkSvcSQLiteImpl;

import java.util.ArrayList;
import java.util.List;

public class AddWorkoutFragment extends Fragment {

    private AddWorkoutViewModel mViewModel;

    public static AddWorkoutFragment newInstance() {
        return new AddWorkoutFragment();
    }
    //private WorkSvcImpl workSvcImpl;
    private WorkSvcSQLiteImpl workSvcSQLiteImpl;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.add_workout_fragment, container, false);

        // workSvcImpl = new WorkSvcImpl(getActivity().getApplicationContext());

        workSvcSQLiteImpl = new WorkSvcSQLiteImpl(getActivity().getApplicationContext());


        Button button = (Button) view.findViewById(R.id.addNewWorkoutBtn);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                final TextInputEditText workoutTitle = (TextInputEditText) view.findViewById(R.id.workoutTitle);
                final TextInputEditText exercise = (TextInputEditText) view.findViewById(R.id.exercise);

                List<String> exercises = new ArrayList<>();
                exercises.add(exercise.getText().toString());
                Workout workout = new Workout(workoutTitle.getText().toString(), exercises);
                //workSvcImpl.remove(workout);
                //boolean isCreated = workSvcImpl.create(workout);

                //workSvcSQLiteImpl.remove(workout);
                boolean isCreated = workSvcSQLiteImpl.create(workout);

                System.out.println(isCreated);
            }
        });

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(AddWorkoutViewModel.class);
        // TODO: Use the ViewModel
    }

}
