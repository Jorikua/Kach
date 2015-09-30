package ua.kaganovych.kach.dialogs;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import ua.kaganovych.kach.R;
import ua.kaganovych.kach.provider.workout.WorkoutColumns;

public class DeletionDialogFragment extends AppCompatDialogFragment {

    public static final String CATEGORY_NAME = "category_name";
    public static final String ITEM_ID = "item_id";
    private ImageButton mDeleteButton;
    private ImageButton mCancelButton;

    private TextView mDialogText;

    private int mId;
    private String mCategoryName;

    public static DeletionDialogFragment newInstance(String category, int id) {
        DeletionDialogFragment fragment = new DeletionDialogFragment();
        Bundle bundle = new Bundle();
        bundle.putString(CATEGORY_NAME, category);
        bundle.putInt(ITEM_ID, id);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(STYLE_NO_TITLE, 0);
        mId = getArguments().getInt(ITEM_ID);
        mCategoryName = getArguments().getString(CATEGORY_NAME);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.deletion_dialog_layout, container, false);
        getDialog().getWindow().setBackgroundDrawableResource(R.drawable.dialog_shape);

        mDeleteButton = (ImageButton)rootView.findViewById(R.id.delete_dialog_delete_button);
        mCancelButton = (ImageButton)rootView.findViewById(R.id.delete_dialog_cancel_button);

        mDialogText = (TextView)rootView.findViewById(R.id.delete_dialog_title);
        mDialogText.setText(getString(R.string.deletion_dialog_text_start) + " " + mCategoryName + getString(R.string.deletion_dialog_text_end) + " " + mId);

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse(WorkoutColumns.CONTENT_URI + "/" + mId);
                getActivity().getContentResolver().delete(uri, null, null);
                dismiss();
            }
        });

        mCancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        int width = getResources().getDimensionPixelSize(R.dimen.deletion_dialog_width);
        int height = getResources().getDimensionPixelSize(R.dimen.deletion_dialog_height);
        getDialog().getWindow().setLayout(width, height);
        getDialog().getWindow().setGravity(Gravity.CENTER);

    }
}
