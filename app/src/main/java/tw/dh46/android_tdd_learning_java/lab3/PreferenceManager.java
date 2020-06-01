package tw.dh46.android_tdd_learning_java.lab3;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DanielHuang on 2020/6/1
 */
public class PreferenceManager implements IPreferenceManager {

    private String prefName = "UserData";

    private SharedPreferences preferences;

    public PreferenceManager(Context context) {
       preferences = context.getSharedPreferences(prefName, Context.MODE_PRIVATE);
    }

    @Override
    public void saveString(String key, String value) {
        preferences.edit().putString(key, value).commit();
    }

    @Override
    public String getString(String key) {
        return preferences.getString(key,"");
    }
}
