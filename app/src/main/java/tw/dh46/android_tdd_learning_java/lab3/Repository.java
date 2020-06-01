package tw.dh46.android_tdd_learning_java.lab3;

/**
 * Created by DanielHuang on 2020/6/1
 */
public class Repository {

    private IPreferenceManager preferenceManager;

    public Repository(IPreferenceManager preferenceManager) {
        this.preferenceManager = preferenceManager;
    }

    public void saveUserId(String userId) {
        preferenceManager.saveString("UserId", userId);
    }
}
