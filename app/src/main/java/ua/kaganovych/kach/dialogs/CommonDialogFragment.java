package ua.kaganovych.kach.dialogs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ua.kaganovych.kach.R;

public class CommonDialogFragment extends AppCompatDialogFragment {

    public static final String CATEGORY_TITLE = "category_title";

    private TextView mTitle;

    public static CommonDialogFragment newInstance(String title) {
        CommonDialogFragment fragment = new CommonDialogFragment();
        Bundle b = new Bundle();
        b.putString(CATEGORY_TITLE, title);
        fragment.setArguments(b);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, 0);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.common_dialog_layout, container, false);

        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.dialog_shape);
        mTitle = (TextView)rootView.findViewById(R.id.dialog_text_view);
        mTitle.setText(getArguments().getString(CATEGORY_TITLE));
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        int width = getResources().getDimensionPixelSize(R.dimen.category_dialog_width);
        int height = getResources().getDimensionPixelSize(R.dimen.category_dialog_height);
        getDialog().getWindow().setLayout(width, height);
        getDialog().getWindow().setGravity(Gravity.CENTER);
    }
}
