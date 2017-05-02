package mvp.view;

import mvp.bean.User;

/**
 * Created by Robot on 2017/5/1.
 */

public interface IUserLoginView {
    String getUserName();

    String getPassWord();

    void clearUserName();

    void clearPassWord();

    void showLoading();

    void hideLoading();

    void toMainActivity(User user);

    void showFailedError();


}
