package tw.dh46.android_tdd_learning_java;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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
                String account = edtAccount.getText().toString();
                String password = edtPassword.getText().toString();

                boolean isLogin = false;
                //帳號至少8碼，第1碼為英文
                if (account.length() >= 8) {
                    if (Character.isLetter(account.toUpperCase().charAt(0))) {
                        isLogin = true;
                    }
                }
            }
        });
    }
}