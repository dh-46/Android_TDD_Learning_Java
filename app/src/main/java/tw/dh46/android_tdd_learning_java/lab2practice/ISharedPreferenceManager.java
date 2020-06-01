package tw.dh46.android_tdd_learning_java.lab2practice;

/**
 * Created by DanielHuang on 2020/6/1
 * 練習
 *
 * 上一個commit 直接Mock SharePreference不一定是好的解法。
 * 練習另一個做法是增加一個中介層SharePreferenceManager，
 * 改去測試有沒有傳送正確的資料到ISharePreferenceManager，
 * 而不是去每次都要Mock SharePreference。
 */
public interface ISharedPreferenceManager {

    void insertString(String key, String value);
}
