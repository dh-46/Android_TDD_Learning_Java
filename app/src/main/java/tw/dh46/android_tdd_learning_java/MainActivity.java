package tw.dh46.android_tdd_learning_java;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import tw.dh46.android_tdd_learning_java.lab1.RegisterVerify;

/**
 * 這裡有一個範例是註冊的功能。輸入帳號及密碼後可註冊為會員。
 * 功能描述：
 * 1.帳號至少需8碼，第1碼為英文。
 * 2.密碼至少需8碼，第1碼為英文，並包含1碼數字。
 * 3.點擊「註冊」，若失敗則使用AlertDialg告訴使用者失敗原因。
 * 4.點擊「註冊」，若成功則導至註冊成功頁。
 * 這個範例先不考慮要儲存註冊會員需要呼叫Web API。
 * 只是單純的將帳號密碼填好後，做資料檢查，如果符合帳號及密碼的格式，我們就視為成功。
 */
public class MainActivity extends AppCompatActivity {

    private EditText edtAccount, edtPassword;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        edtAccount = findViewById(R.id.edit_account);
        edtPassword = findViewById(R.id.edit_password);
        btnRegister = findViewById(R.id.btn_register);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verify();
                /**
                 * 這樣的程式碼不利於測試，所以需抽取成RegisterVerify類別等。
                 * 若是現實中的專案，不建議直接這樣提取，
                 * 應該先撰寫好相對應的單元測試，以確保邏輯不被破壞。
                 */
//                String account = edtAccount.getText().toString();
//                String password = edtPassword.getText().toString();
//
//                boolean isLogin = false;
//                //帳號至少8碼，第1碼為英文
//                if (account.length() >= 8) {
//                    if (Character.isLetter(account.toUpperCase().charAt(0))) {
//                        isLogin = true;
//                    }
//                }
            }
        });
    }


    /**
     * 執行驗證
     */
    private void verify() {
        String account = edtAccount.getText().toString();
        String password = edtPassword.getText().toString();

        RegisterVerify registerVerify = new RegisterVerify();

        boolean isAccountVerified = registerVerify.isLoginIdVerify(account);
        boolean isPasswordVerified = registerVerify.isPasswordVerify(password);

        if (isAccountVerified && isPasswordVerified) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this)
                    .setTitle("提示")
                    .setMessage("登入成功");
            builder.show();
        } else {
            if (!isAccountVerified) {
                Toast.makeText(this, "帳號不符規則",Toast.LENGTH_SHORT).show();
            }

            if (!isPasswordVerified) {
                Toast.makeText(this, "密碼不符規則",Toast.LENGTH_SHORT).show();
            }
        }
    }
}