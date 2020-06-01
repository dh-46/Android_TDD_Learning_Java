package tw.dh46.android_tdd_learning_java.lab2;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by DanielHuang on 2020/6/1
 * <p>
 * Day10 - Mock Android Framework: https://ithelp.ithome.com.tw/articles/10219891
 * 透過Mock Android Framework，解決當程式相依於Android framework時，仍使用Local Unit Test
 * --------------------------------------------------
 * Repository: 處理帳號與密碼儲存(SharedPreference)
 */
public class Repository {

    public static final String PREF_NAME = "UserData";
    public static final String KEY_USER_ID = "userId";
    private Context mContext;

    public Repository(Context context) {
        mContext = context;
    }

    /**
     * 儲存使用者帳號至SharedPreference
     *
     * @param userId
     */
    public void saveUserId(String userId) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        sharedPreferences.edit().putString(KEY_USER_ID, userId).commit();
    }

}
