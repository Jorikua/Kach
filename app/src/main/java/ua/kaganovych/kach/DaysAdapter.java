package ua.kaganovych.kach;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DaysAdapter extends ArrayAdapter<String> {

    private int[] mImages;
    private String[] mTitles;

    public DaysAdapter(Context context, String[] titles, int[] images) {
        super(context, 0, titles);
        mImages = images;
        mTitles = titles;
    }

    private static class ViewHolder {
        private TextView mTitle;
        private ImageView mImage;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.day_item, parent, false);
            viewHolder.mTitle = (TextView)convertView.findViewById(R.id.day_title);
            viewHolder.mImage = (ImageView)convertView.findViewById(R.id.day_background);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder)convertView.getTag();
        }

        viewHolder.mTitle.setText(mTitles[position]);
        viewHolder.mImage.setImageResource(mImages[position]);

        return convertView;
    }
}
