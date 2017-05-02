package mvp.presenter;

import android.os.Handler;
import android.util.Log;

import mvp.bean.User;
import mvp.biz.IUserBiz;
import mvp.biz.OnLoginListener;
import mvp.biz.UserBiz;
import mvp.view.IUserLoginView;

import static android.content.ContentValues.TAG;

/**
 * Created by Robot on 2017/5/1.
 */

public class UserLoginPresenter {

    private IUserLoginView userLoginView;
    private IUserBiz userbiz;
    private Handler mHandler = new Handler();

    public UserLoginPresenter(IUserLoginView userLoginView) {

        this.userLoginView = userLoginView;
        this.userLoginView = userLoginView;
        this.userbiz = new UserBiz();
    }

    public void login() {
        userLoginView.showLoading();
        Log.e(TAG, "login: "+userLoginView.getUserName() );
        Log.e(TAG, "login: "+userLoginView.getPassWord() );
        userbiz.login(userLoginView.getUserName(), userLoginView.getPassWord(), new OnLoginListener() {
            @Override
            public void loginSuccess(final User user) {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.toMainActivity(user);
                        userLoginView.hideLoading();
                    }
                });
            }

            @Override
            public void loginFailed() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        userLoginView.showFailedError();
                        userLoginView.hideLoading();
                    }
                });
            }

        });

    }

    public void clear() {
        userLoginView.clearPassWord();
        userLoginView.clearUserName();
    }
}
