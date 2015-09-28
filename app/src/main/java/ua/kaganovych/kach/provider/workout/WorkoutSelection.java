package ua.kaganovych.kach.provider.workout;

import java.util.Date;

import android.content.Context;
import android.content.ContentResolver;
import android.database.Cursor;
import android.net.Uri;

import ua.kaganovych.kach.provider.base.AbstractSelection;

/**
 * Selection for the {@code workout} table.
 */
public class WorkoutSelection extends AbstractSelection<WorkoutSelection> {
    @Override
    protected Uri baseUri() {
        return WorkoutColumns.CONTENT_URI;
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param contentResolver The content resolver to query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code WorkoutCursor} object, which is positioned before the first entry, or null.
     */
    public WorkoutCursor query(ContentResolver contentResolver, String[] projection) {
        Cursor cursor = contentResolver.query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new WorkoutCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(contentResolver, null)}.
     */
    public WorkoutCursor query(ContentResolver contentResolver) {
        return query(contentResolver, null);
    }

    /**
     * Query the given content resolver using this selection.
     *
     * @param context The context to use for the query.
     * @param projection A list of which columns to return. Passing null will return all columns, which is inefficient.
     * @return A {@code WorkoutCursor} object, which is positioned before the first entry, or null.
     */
    public WorkoutCursor query(Context context, String[] projection) {
        Cursor cursor = context.getContentResolver().query(uri(), projection, sel(), args(), order());
        if (cursor == null) return null;
        return new WorkoutCursor(cursor);
    }

    /**
     * Equivalent of calling {@code query(context, null)}.
     */
    public WorkoutCursor query(Context context) {
        return query(context, null);
    }


    public WorkoutSelection id(long... value) {
        addEquals("workout." + WorkoutColumns._ID, toObjectArray(value));
        return this;
    }

    public WorkoutSelection idNot(long... value) {
        addNotEquals("workout." + WorkoutColumns._ID, toObjectArray(value));
        return this;
    }

    public WorkoutSelection orderById(boolean desc) {
        orderBy("workout." + WorkoutColumns._ID, desc);
        return this;
    }

    public WorkoutSelection orderById() {
        return orderById(false);
    }

    public WorkoutSelection category(String... value) {
        addEquals(WorkoutColumns.CATEGORY, value);
        return this;
    }

    public WorkoutSelection categoryNot(String... value) {
        addNotEquals(WorkoutColumns.CATEGORY, value);
        return this;
    }

    public WorkoutSelection categoryLike(String... value) {
        addLike(WorkoutColumns.CATEGORY, value);
        return this;
    }

    public WorkoutSelection categoryContains(String... value) {
        addContains(WorkoutColumns.CATEGORY, value);
        return this;
    }

    public WorkoutSelection categoryStartsWith(String... value) {
        addStartsWith(WorkoutColumns.CATEGORY, value);
        return this;
    }

    public WorkoutSelection categoryEndsWith(String... value) {
        addEndsWith(WorkoutColumns.CATEGORY, value);
        return this;
    }

    public WorkoutSelection orderByCategory(boolean desc) {
        orderBy(WorkoutColumns.CATEGORY, desc);
        return this;
    }

    public WorkoutSelection orderByCategory() {
        orderBy(WorkoutColumns.CATEGORY, false);
        return this;
    }

    public WorkoutSelection dayOfTheWeek(Integer... value) {
        addEquals(WorkoutColumns.DAY_OF_THE_WEEK, value);
        return this;
    }

    public WorkoutSelection dayOfTheWeekNot(Integer... value) {
        addNotEquals(WorkoutColumns.DAY_OF_THE_WEEK, value);
        return this;
    }

    public WorkoutSelection dayOfTheWeekGt(int value) {
        addGreaterThan(WorkoutColumns.DAY_OF_THE_WEEK, value);
        return this;
    }

    public WorkoutSelection dayOfTheWeekGtEq(int value) {
        addGreaterThanOrEquals(WorkoutColumns.DAY_OF_THE_WEEK, value);
        return this;
    }

    public WorkoutSelection dayOfTheWeekLt(int value) {
        addLessThan(WorkoutColumns.DAY_OF_THE_WEEK, value);
        return this;
    }

    public WorkoutSelection dayOfTheWeekLtEq(int value) {
        addLessThanOrEquals(WorkoutColumns.DAY_OF_THE_WEEK, value);
        return this;
    }

    public WorkoutSelection orderByDayOfTheWeek(boolean desc) {
        orderBy(WorkoutColumns.DAY_OF_THE_WEEK, desc);
        return this;
    }

    public WorkoutSelection orderByDayOfTheWeek() {
        orderBy(WorkoutColumns.DAY_OF_THE_WEEK, false);
        return this;
    }
}
