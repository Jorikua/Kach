package ua.kaganovych.kach;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import ua.kaganovych.kach.provider.workout.WorkoutColumns;
import ua.kaganovych.kach.provider.workout.WorkoutSelection;

public class DayScreenFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor> {

    private DayScreenAdapter mAdapter;
    private Button mAddExButton;
    private int mDayOfTheWeek;

    public static DayScreenFragment newInstance(int day_of_the_week) {
        DayScreenFragment fragment = new DayScreenFragment();
        Bundle bundle = new Bundle();
        bundle.putInt(MainFragment.DAY_OF_THE_WEEK, day_of_the_week);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDayOfTheWeek = getArguments().getInt(MainFragment.DAY_OF_THE_WEEK);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_day_screen, container, false);
        mAddExButton = (Button) rootView.findViewById(R.id.add_exercise_button);
        mAdapter = new DayScreenAdapter(getActivity(), null, 0);
        setListAdapter(mAdapter);
        mAddExButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CategoriesActivity.class);
                intent.putExtra(MainFragment.DAY_OF_THE_WEEK, mDayOfTheWeek);
                getActivity().startActivity(intent);
            }
        });

        return rootView;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        WorkoutSelection selection = new WorkoutSelection();
        String[] projection = WorkoutColumns.ALL_COLUMNS;
        selection.dayOfTheWeek(mDayOfTheWeek).query(getActivity().getContentResolver(), projection);
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        mAdapter.changeCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        mAdapter.changeCursor(null);
    }
}
