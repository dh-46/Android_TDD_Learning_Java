package tw.dh46.android_tdd_learning_java.lab2;

import android.content.Context;
import android.content.SharedPreferences;

import org.junit.Test;
import org.mockito.Mockito;

/**
 * Created by DanielHuang on 2020/6/1
 * <p>
 * Repository中使用的SharedPreference物件有使用到Context物件，
 * 因此，就常理推斷應該使用InstrumentTest(AndroidTest)，
 * 但是為了增加測試的速度與效率，我們希望能夠直接在JVM上執行UnitTest。
 * 所以必須使用Mockito框架
 * 測試步驟：
 *
 * 0. 新增 Mockito Framework
 * 1. Mock Context、SharePreference
 * 2. 使用when thenReturn 讓Production code 呼叫sharedPreference時回傳模擬的物件
 * 3. 執行被測試物件：Activity 呼叫repository.saveUserId()
 * 4. 使用verify method，驗證模擬物件是否有呼叫putString，並傳入正確的參數
 * 5. 檢查SharedPreference是否有呼叫commit
 *
 * --------------------------------------------------
 * TestCode --測試--> Repository.saveUserId() (SUT)
 *          --驗證是否有正確與mock互動--> mock(SharedPreference) (MOCK)
 */
public class RepositoryTest {


    @Test
    public void saveUserId(){

        String userId = "A1234567";

        // 1. Mock Context、SharePreference
        SharedPreferences mockSharedPreferences = Mockito.mock(SharedPreferences.class);
        SharedPreferences.Editor mockSharedPreferencesEditor = Mockito.mock(SharedPreferences.Editor.class);
        Context mockContext = Mockito.mock(Context.class);

        // 2. 使用when thenReturn 讓Production code 呼叫sharedPreference時回傳模擬的物件
        // 2-1 當Production code呼叫SP時回傳mock的物件
        Mockito.when(mockContext.getSharedPreferences(Mockito.anyString(), Mockito.anyInt())).thenReturn(mockSharedPreferences);
        // 2-2 當Production code呼叫SP.edit()時回傳mock的物件
        Mockito.when(mockSharedPreferences.edit()).thenReturn(mockSharedPreferencesEditor);
        // 2-3 Production code呼叫editor.putString時回傳mock的物件
        Mockito.when(mockSharedPreferencesEditor.putString(Mockito.anyString(), Mockito.anyString())).thenReturn(mockSharedPreferencesEditor);

        // 3. 執行被測試物件 => 呼叫repository.saveUserId()
        Repository repository = new Repository(mockContext);
        repository.saveUserId(userId);

        // 4. 使用verify method，驗證模擬物件是否有呼叫putString，並傳入正確的參數
        Mockito.verify(mockSharedPreferencesEditor).putString(Repository.KEY_USER_ID, userId);

        // 5. 檢查SharedPreference是否有呼叫commit
        Mockito.verify(mockSharedPreferencesEditor).commit();
    }
}
