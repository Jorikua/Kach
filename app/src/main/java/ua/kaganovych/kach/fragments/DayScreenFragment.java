package ua.kaganovych.kach.fragments;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import ua.kaganovych.kach.CategoriesActivity;
import ua.kaganovych.kach.R;
import ua.kaganovych.kach.adapters.DayScreenAdapter;
import ua.kaganovych.kach.dialogs.DeletionDialogFragment;
import ua.kaganovych.kach.provider.workout.WorkoutColumns;

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

        getLoaderManager().initLoader(0, null, this);

        return rootView;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        Cursor cursor = (Cursor) mAdapter.getItem(position);
        String category = cursor.getString(cursor.getColumnIndex(WorkoutColumns.CATEGORY));
        int itemId = cursor.getInt(cursor.getColumnIndex(WorkoutColumns._ID));
        DeletionDialogFragment.newInstance(category, itemId).show(getActivity().getSupportFragmentManager(), "");
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        String[] projection = WorkoutColumns.ALL_COLUMNS;
        String selection = WorkoutColumns.DAY_OF_THE_WEEK + " =?";
        String[] selectionArgs = new String[] {String.valueOf(mDayOfTheWeek)};
        return new CursorLoader(getActivity(), WorkoutColumns.CONTENT_URI, projection, selection, selectionArgs, null);
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
