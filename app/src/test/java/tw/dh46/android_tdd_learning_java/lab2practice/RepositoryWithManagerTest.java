package tw.dh46.android_tdd_learning_java.lab2practice;

import org.junit.Test;
import org.mockito.Mockito;

import tw.dh46.android_tdd_learning_java.lab2.Repository;

/**
 * Created by DanielHuang on 2020/6/1
 *
 */
public class RepositoryWithManagerTest {

    @Test
    public void saveUserId(){

        // 1. 建立測試物件要用的Mock
        // 也因為介面而避免去Mock Android Framework
        ISharedPreferenceManager mockPreferenceManager = Mockito.mock(ISharedPreferenceManager.class);
        RepositoryWithManager repositoryWithManager = new RepositoryWithManager(mockPreferenceManager);

        String userId = "A123456";
        String prefKey = "UserId";

        // 執行要測試的行為
        repositoryWithManager.saveUserId(userId);

        // 驗證是否有執行sharedPreference的方法及是否有正確的值
        Mockito.verify(mockPreferenceManager).insertString(
                prefKey,
                userId
        );

        // 這樣只有驗證是否有執行該方法，但不檢查其值是否正確
//        Mockito.verify(mockPreferenceManager).insertString(
//                Mockito.anyString(),
//                Mockito.anyString()
//        );
    }
}
