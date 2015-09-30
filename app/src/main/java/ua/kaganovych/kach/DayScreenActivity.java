package ua.kaganovych.kach;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import ua.kaganovych.kach.fragments.DayScreenFragment;
import ua.kaganovych.kach.fragments.MainFragment;

public class DayScreenActivity extends AppCompatActivity {

    private FragmentManager mFragmentManager;
    private DayScreenFragment mDayScreenFragment;

    private Toolbar mToolbar;
    private ImageView mBackButton;
    private TextView mTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day_screen);

        Intent intent = getIntent();
        String title = intent.getStringExtra(MainFragment.DAY_NAME);

        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        Toolbar.LayoutParams params = new Toolbar.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, Gravity.CENTER);
        View toolbar_title = getLayoutInflater().inflate(R.layout.toolbar_custom_layout, null);
        mToolbar.addView(toolbar_title, params);

        mTitle = (TextView)toolbar_title.findViewById(R.id.toolbar_title);
        mTitle.setText(title.toUpperCase());

        mBackButton = (ImageView)mToolbar.findViewById(R.id.toolbar_back_button);
        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mDayScreenFragment = DayScreenFragment.newInstance(intent.getIntExtra(MainFragment.DAY_OF_THE_WEEK, 0));
        mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction()
                .replace(R.id.current_day_container, mDayScreenFragment)
                .commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_day_screen, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                Intent intent = new Intent(this, CategoriesActivity.class);
                intent.putExtra(MainFragment.DAY_OF_THE_WEEK, getIntent().getIntExtra(MainFragment.DAY_OF_THE_WEEK, 0));
                startActivity(intent);
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
