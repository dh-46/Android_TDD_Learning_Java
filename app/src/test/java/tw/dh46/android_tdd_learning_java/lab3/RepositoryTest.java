package tw.dh46.android_tdd_learning_java.lab3;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by DanielHuang on 2020/6/1
 */
public class RepositoryTest {

    @Test
    public void saveUserId() {
        IPreferenceManager mockPreferenceManager = Mockito.mock(IPreferenceManager.class);

        String userId = "A1234567";
        String preKey = "UserId";
        Repository repository = new Repository(mockPreferenceManager);

        // 執行要被測試的程式碼
        repository.saveUserId(userId);

        // 檢測
        Mockito.verify(mockPreferenceManager).saveString(preKey, userId);
    }

}
