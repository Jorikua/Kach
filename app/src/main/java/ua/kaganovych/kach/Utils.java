package ua.kaganovych.kach;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class Utils {

    public static void replaceFragment(AppCompatActivity activity, boolean addToBackStack, Fragment fragment, int containerId) {
        activity.invalidateOptionsMenu();
        String fragmentTag = fragment.getClass().getName();
        boolean fragmentPopped = activity.getSupportFragmentManager().popBackStackImmediate(fragmentTag, 0);

        if (!fragmentPopped && activity.getSupportFragmentManager().findFragmentByTag(fragmentTag) == null) {
            FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
            transaction.replace(containerId, fragment, fragmentTag);
            if (addToBackStack) {
                transaction.addToBackStack(fragmentTag);
            }
            transaction.commit();
        }
    }

}
