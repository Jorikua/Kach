package ua.kaganovych.kach.provider.workout;

import android.net.Uri;
import android.provider.BaseColumns;

import ua.kaganovych.kach.provider.WorkoutProvider;
import ua.kaganovych.kach.provider.workout.WorkoutColumns;

/**
 * Columns for the {@code workout} table.
 */
public class WorkoutColumns implements BaseColumns {
    public static final String TABLE_NAME = "workout";
    public static final Uri CONTENT_URI = Uri.parse(WorkoutProvider.CONTENT_URI_BASE + "/" + TABLE_NAME);

    /**
     * Primary key.
     */
    public static final String _ID = BaseColumns._ID;

    public static final String CATEGORY = "category";

    public static final String DAY_OF_THE_WEEK = "day_of_the_week";


    public static final String DEFAULT_ORDER = TABLE_NAME + "." +_ID;

    // @formatter:off
    public static final String[] ALL_COLUMNS = new String[] {
            _ID,
            CATEGORY,
            DAY_OF_THE_WEEK
    };
    // @formatter:on

    public static boolean hasColumns(String[] projection) {
        if (projection == null) return true;
        for (String c : projection) {
            if (c.equals(CATEGORY) || c.contains("." + CATEGORY)) return true;
            if (c.equals(DAY_OF_THE_WEEK) || c.contains("." + DAY_OF_THE_WEEK)) return true;
        }
        return false;
    }

}
