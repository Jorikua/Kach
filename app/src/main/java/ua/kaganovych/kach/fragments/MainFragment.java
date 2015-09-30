package ua.kaganovych.kach.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import ua.kaganovych.kach.DayScreenActivity;
import ua.kaganovych.kach.adapters.MainAdapter;
import ua.kaganovych.kach.R;

public class MainFragment extends Fragment {

    private String[] mTitleArray;
    private int[] mImageArray;
    private MainAdapter mAdapter;
    private GridView mGridView;

    public static final String DAY_OF_THE_WEEK = "day_of_the_week";
    public static final String DAY_NAME = "day_name";

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        mGridView = (GridView)rootView.findViewById(R.id.days_grid_view);

        mTitleArray = getResources().getStringArray(R.array.days);
        mImageArray = new int[] {R.drawable.monday, R.drawable.tuesday, R.drawable.wednesday, R.drawable.thursday, R.drawable.friday, R.drawable.saturday, R.drawable.sunday, R.drawable.bg_timer};
        mAdapter = new MainAdapter(getActivity(), mTitleArray, mImageArray);
        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 7) {
                    Toast.makeText(getActivity(), R.string.timer_toast_message, Toast.LENGTH_LONG).show();
                } else {
                    String title = mAdapter.getItem(position);
                    Intent intent = new Intent(getActivity(), DayScreenActivity.class);
                    intent.putExtra(DAY_OF_THE_WEEK, position);
                    intent.putExtra(DAY_NAME, title);
                    getActivity().startActivity(intent);
                }

            }
        });

        return rootView;
    }
}
