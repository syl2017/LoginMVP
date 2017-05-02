package mvp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.root.myapplication.R;
import com.root.myapplication.picture.MainActivity;

import mvp.bean.User;
import mvp.presenter.UserLoginPresenter;
import mvp.view.IUserLoginView;

/**
 * Created by Robot on 2017/5/1.
 */

public class UserLoginMainActivity extends AppCompatActivity implements IUserLoginView, View.OnClickListener {
    private static final String TAG = "UserLoginMainActivity";

    private UserLoginPresenter mUserLoginPresenter = new UserLoginPresenter(this);
    private EditText edit_username;
    private EditText edit_password;
    private Button login_button;
    private Button button_clear;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        initView();


    }

    @Override
    public String getUserName() {
        String username = edit_username.getText().toString().trim();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "username", Toast.LENGTH_SHORT).show();
            return "1";
        }
        return username;

    }

    @Override
    public String getPassWord() {
        String password = edit_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)) {
            Toast.makeText(this, "password", Toast.LENGTH_SHORT).show();
            return "1";
        }
        return password;
    }

    @Override
    public void clearUserName() {
        edit_username.setText("");
    }

    @Override
    public void clearPassWord() {
        edit_password.setText("");
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void toMainActivity(User user) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);


    }

    @Override
    public void showFailedError() {
        Toast.makeText(this,
                "login failed", Toast.LENGTH_SHORT).show();
    }


    private void initView() {
        edit_username = (EditText) findViewById(R.id.edit_username);
        edit_password = (EditText) findViewById(R.id.edit_password);
        login_button = (Button) findViewById(R.id.login_button);
        button_clear = (Button) findViewById(R.id.button_clear);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        login_button.setOnClickListener(this);
        button_clear.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_button:
                mUserLoginPresenter.login();
                break;
            case R.id.button_clear:
                mUserLoginPresenter.clear();

                break;
        }
    }

}
