package ua.kaganovych.kach;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class CategoriesActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private CategoriesFragment mCategoriesFragment;

    private Toolbar mToolbar;
    private ImageView mBackButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        mBackButton = (ImageView)mToolbar.findViewById(R.id.toolbar_back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CategoriesActivity.this, "BACK PRESSED", Toast.LENGTH_LONG).show();
            }
        });

        mCategoriesFragment = new CategoriesFragment();
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .replace(R.id.container, mCategoriesFragment)
                .commit();
    }
}
