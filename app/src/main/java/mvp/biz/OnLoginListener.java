package mvp.biz;

import mvp.bean.User;

/**
 * Created by Robot on 2017/5/1.
 */

public interface OnLoginListener {
    public void loginSuccess(User user);
    public void loginFailed();
}
