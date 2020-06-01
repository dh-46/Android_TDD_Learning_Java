package tw.dh46.android_tdd_learning_java.lab1;

/**
 * Created by DanielHuang on 2020/6/1
 *
 * 驗證邏輯抽取成類別或方法，可容易撰寫測試。
 * 繼續擴大就會是選擇適合的開發架構，如MVVM、MVP、MVC等...
 */
public class RegisterVerify {

    /**
     * 驗證帳號是否符合規則
     * 1. 長度大於6位
     * 2. 首字為字母
     * @param loginId
     * @return
     */
    public boolean isLoginIdVerify(String loginId) {
        boolean isLoginIdOk = false;

        // 帳號至少6碼，第1碼為英文
        if (loginId.length() >= 6) {
            if (Character.isLetter(loginId.charAt(0))) {
                isLoginIdOk = true;
            }
        }

        return isLoginIdOk;
    }

    /**
     * 驗證密碼是否符合規則
     * 1. 長度大於8位
     * 2. 首字為字母
     * @param password
     * @return
     */
    public boolean isPasswordVerify(String password) {
        boolean isPasswordOk = false;

        if (password.length() >= 8) {
            if (Character.isLetter(password.charAt(0))) {
                isPasswordOk = true;
            }
        }

        return isPasswordOk;
    }
}
