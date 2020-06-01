package tw.dh46.android_tdd_learning_java.lab3;

import android.content.Context;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by DanielHuang on 2020/6/1
 * 執行時會開啟模擬器或手機，表示是使用InstrumentedTest
 * 因為已使用PreferenceManagerTest來處理SP寫入，
 * 所以之後程式擴充，應該不需要再新寫別的Android測試程式。
 * 記得，如果不是使用Android framework就該使用Local Unit Test
 */
@RunWith(AndroidJUnit4.class)
public class PreferenceManagerTest {

    @Test
    public void useAppContext() {
        Context context = InstrumentationRegistry.getInstrumentation().getContext();
        String userId = "A1234567";
        String preKey = "UserId";

        // 建立 PreferenceManager 物件
        IPreferenceManager preferenceManager = new PreferenceManager(context);

        // 寫入
        preferenceManager.saveString(preKey, userId);

        // 寫出
        String valueFromPm = preferenceManager.getString(preKey);

        // 驗證寫入與寫出值是否相同
        Assert.assertEquals("A1234567", valueFromPm);
    }

}
