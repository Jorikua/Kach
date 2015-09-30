package ua.kaganovych.kach;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ua.kaganovych.kach.fragments.CategoriesFragment;
import ua.kaganovych.kach.fragments.MainFragment;

public class CategoriesActivity extends AppCompatActivity {

    private CategoriesFragment mCategoriesFragment;

    private Toolbar mToolbar;
    private ImageView mBackButton;
    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        View toolbar_view = getLayoutInflater().inflate(R.layout.toolbar_custom_layout, null);
        mTitle = (TextView)toolbar_view.findViewById(R.id.toolbar_title);
        mTitle.setText(R.string.category_activity_title);
        mToolbar.addView(toolbar_view, params);
        mBackButton = (ImageView)mToolbar.findViewById(R.id.toolbar_back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        mCategoriesFragment = CategoriesFragment.newInstance(getIntent().getIntExtra(MainFragment.DAY_OF_THE_WEEK, 0));
        Utils.replaceFragment(this, false, mCategoriesFragment, R.id.container);
    }
}
