package ua.kaganovych.kach.provider.workout;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ua.kaganovych.kach.provider.base.AbstractContentValues;

/**
 * Content values wrapper for the {@code workout} table.
 */
public class WorkoutContentValues extends AbstractContentValues {
    @Override
    public Uri uri() {
        return WorkoutColumns.CONTENT_URI;
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(ContentResolver contentResolver, @Nullable WorkoutSelection where) {
        return contentResolver.update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    /**
     * Update row(s) using the values stored by this object and the given selection.
     *
     * @param contentResolver The content resolver to use.
     * @param where The selection to use (can be {@code null}).
     */
    public int update(Context context, @Nullable WorkoutSelection where) {
        return context.getContentResolver().update(uri(), values(), where == null ? null : where.sel(), where == null ? null : where.args());
    }

    public WorkoutContentValues putCategory(@Nullable String value) {
        mContentValues.put(WorkoutColumns.CATEGORY, value);
        return this;
    }

    public WorkoutContentValues putCategoryNull() {
        mContentValues.putNull(WorkoutColumns.CATEGORY);
        return this;
    }

    public WorkoutContentValues putDayOfTheWeek(@Nullable Integer value) {
        mContentValues.put(WorkoutColumns.DAY_OF_THE_WEEK, value);
        return this;
    }

    public WorkoutContentValues putDayOfTheWeekNull() {
        mContentValues.putNull(WorkoutColumns.DAY_OF_THE_WEEK);
        return this;
    }
}
