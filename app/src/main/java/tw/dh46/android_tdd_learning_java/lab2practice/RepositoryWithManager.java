package tw.dh46.android_tdd_learning_java.lab2practice;

/**
 * Created by DanielHuang on 2020/6/1
 * 練習
 * 改用Interface解耦合
 */
public class RepositoryWithManager {


    private ISharedPreferenceManager sharedPreferenceManager;

    public RepositoryWithManager(ISharedPreferenceManager sharedPreferenceManager) {
        this.sharedPreferenceManager = sharedPreferenceManager;
    }

    /**
     * 改透過 ISharedPreferenceManager來存取
     * @param userId
     */
    public void saveUserId(String userId) {
        sharedPreferenceManager.insertString("UserId", userId);
    }
}
