package ua.kaganovych.kach;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

import ua.kaganovych.kach.provider.workout.WorkoutColumns;

public class DayScreenAdapter extends CursorAdapter{

    private static class ViewHolder {
        private TextView mTitle;
        private int titleIndex;
    }

    public DayScreenAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.day_category_item, parent, false);
        ViewHolder viewHolder = new ViewHolder();
        viewHolder.mTitle = (TextView)view.findViewById(R.id.category_title_text_view);
        viewHolder.titleIndex = cursor.getColumnIndex(WorkoutColumns.CATEGORY);
        view.setTag(viewHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder = (ViewHolder)view.getTag();
        holder.mTitle.setText(cursor.getString(holder.titleIndex));
    }
}
