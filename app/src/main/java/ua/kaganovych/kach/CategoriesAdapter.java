package ua.kaganovych.kach;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import ua.kaganovych.kach.model.Categories;

public class CategoriesAdapter extends ArrayAdapter<Categories> {

    private FragmentActivity mActivity;

    public CategoriesAdapter(Context context, ArrayList<Categories> list, FragmentActivity activity) {
        super(context, 0, list);
        mActivity = activity;
    }

    private static class ViewHolder {
        private TextView mName;
        private ImageView mAddButton;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final Categories item = getItem(position);
        ViewHolder viewHolder;

        if (convertView ==  null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.category_item, parent, false);
            viewHolder.mName = (TextView)convertView.findViewById(R.id.title_text_view);
            viewHolder.mAddButton = (ImageView)convertView.findViewById(R.id.add_category_button);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.mName.setText(item.getName());
        viewHolder.mName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CommonDialogFragment.newInstance(item.getName()).show(mActivity.getSupportFragmentManager(), "");
            }
        });
        viewHolder.mAddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Category: " + item.getName(), Toast.LENGTH_LONG).show();
            }
        });

        return convertView;
    }
}
