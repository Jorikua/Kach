package ua.kaganovych.kach;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

public class DaysFragment extends Fragment {

    private String[] mTitleArray;
    private int[] mImageArray;
    private DaysAdapter mAdapter;
    private GridView mGridView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_days, container, false);

        mGridView = (GridView)rootView.findViewById(R.id.days_grid_view);

        mTitleArray = getResources().getStringArray(R.array.days);
        mImageArray = new int[] {R.drawable.monday, R.drawable.tuesday, R.drawable.wednesday, R.drawable.thursday, R.drawable.friday, R.drawable.saturday, R.drawable.sunday, R.drawable.bg_timer};
        mAdapter = new DaysAdapter(getActivity(), mTitleArray, mImageArray);
        mGridView.setAdapter(mAdapter);

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 7) {
                    Toast.makeText(getActivity(), "Функционал не доступен", Toast.LENGTH_LONG).show();
                }
                String title = mAdapter.getItem(position);
                Log.d("TAG", title);

            }
        });

        return rootView;
    }
}
