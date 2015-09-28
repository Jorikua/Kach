package ua.kaganovych.kach.provider.workout;

import java.util.Date;

import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ua.kaganovych.kach.provider.base.AbstractCursor;

/**
 * Cursor wrapper for the {@code workout} table.
 */
public class WorkoutCursor extends AbstractCursor implements WorkoutModel {
    public WorkoutCursor(Cursor cursor) {
        super(cursor);
    }

    /**
     * Primary key.
     */
    public long getId() {
        Long res = getLongOrNull(WorkoutColumns._ID);
        if (res == null)
            throw new NullPointerException("The value of '_id' in the database was null, which is not allowed according to the model definition");
        return res;
    }

    /**
     * Get the {@code category} value.
     * Can be {@code null}.
     */
    @Nullable
    public String getCategory() {
        String res = getStringOrNull(WorkoutColumns.CATEGORY);
        return res;
    }

    /**
     * Get the {@code day_of_the_week} value.
     * Can be {@code null}.
     */
    @Nullable
    public Integer getDayOfTheWeek() {
        Integer res = getIntegerOrNull(WorkoutColumns.DAY_OF_THE_WEEK);
        return res;
    }
}
