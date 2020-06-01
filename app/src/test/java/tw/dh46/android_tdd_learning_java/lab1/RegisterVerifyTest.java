package tw.dh46.android_tdd_learning_java.lab1;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by DanielHuang on 2020/6/1
 * 第一個測試
 * 測試登入驗證機制
 * <p>
 * - 測試類別必須為Public
 * - 測試方法必須為Public
 * - 測試方法須加上@Test註解
 */
public class RegisterVerifyTest {

    private RegisterVerify registerVerify;

    /**
     * 測試前要做的事情
     */
    @Before
    public void setup() {
        registerVerify = new RegisterVerify();
    }

    /**
     * 驗證帳號為A123456，長度滿6個字，驗證結果應為true
     */
    @Test
    public void accountVerifyTrue() {
        String account = "A123456";
        boolean result = registerVerify.isLoginIdVerify(account);

        Assert.assertTrue(result);
    }

    /**
     * 驗證帳號為A123，長度不滿6個字，應為False
     */
    @Test
    public void accountVerifyFalse() {
        String account = "A123";
        boolean result = registerVerify.isLoginIdVerify(account);
        Assert.assertFalse(result);
    }

    /**
     * 驗證帳號為123456，長度滿6個字，首字不為英文，應為False
     */
    @Test
    public void accountVerifyFalseFirstCharNotLetter() {
        String account = "123456";
        boolean result = registerVerify.isLoginIdVerify(account);
        Assert.assertFalse(result);
    }

    /**
     * 驗證密碼為abc123456，長度滿8位，且首字為英文，應為true
     */
    @Test
    public void passwordVerifyTrue() {
        String password = "abc123456";
        boolean result = registerVerify.isPasswordVerify(password);
        Assert.assertTrue(result);
    }

    /**
     * 驗證密碼為abc123，長度不滿8位，首字為英文，應為false
     */
    @Test
    public void passwordVerifyFalse() {
        String password = "abc123";
        boolean result = registerVerify.isPasswordVerify(password);
        Assert.assertFalse(result);
    }

    /**
     * 驗證密碼為 12345678，長度滿8位，首字不為英文，應為false
     */
    @Test
    public void passwordVerifyFalseFirstCharNotLetter(){
        String password = "12345678";
        boolean result = registerVerify.isPasswordVerify(password);
        Assert.assertFalse(result);
    }
}
