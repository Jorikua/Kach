package ua.kaganovych.kach.provider.workout;

import ua.kaganovych.kach.provider.base.BaseModel;

import java.util.Date;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

/**
 * Data model for the {@code workout} table.
 */
public interface WorkoutModel extends BaseModel {

    /**
     * Get the {@code category} value.
     * Can be {@code null}.
     */
    @Nullable
    String getCategory();

    /**
     * Get the {@code day_of_the_week} value.
     * Can be {@code null}.
     */
    @Nullable
    Integer getDayOfTheWeek();
}
