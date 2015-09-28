package ua.kaganovych.kach;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import ua.kaganovych.kach.api.ApiClient;
import ua.kaganovych.kach.model.Categories;
import ua.kaganovych.kach.model.Result;

public class CategoriesFragment extends ListFragment {

    private CategoriesAdapter mAdapter;
    private ArrayList<Categories> mCategoriesList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_categories, container, false);

        mCategoriesList = new ArrayList<>();
        mAdapter = new CategoriesAdapter(getActivity(), mCategoriesList, getActivity());
        setListAdapter(mAdapter);

        ApiClient.getKachApiInterface().getCategories().enqueue(new Callback<List<Result>>() {
            @Override
            public void onResponse(Response<List<Result>> response) {
                for (Result result : response.body()) {
                    mCategoriesList.addAll(result.categories);
                    mAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Throwable t) {
                Log.d("TAG", t.toString());
            }
        });

        return rootView;
    }
}
