package mvp.biz;

import mvp.bean.User;

/**
 * Created by Robot on 2017/5/2.
 */

public class UserBiz implements IUserBiz {
    @Override
    public void login(final String userName, final String passWord, final OnLoginListener loginListener) {
        //模拟子线程耗时操作
        new Thread()
        {
            @Override
            public void run()
            {
                try
                {
                    Thread.sleep(2000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                //模拟登录成功
                if ("qwe".equals(userName) && "123".equals(passWord))
                {
                    User user = new User();
                    user.setUserName(userName);
                    user.setPassWord(passWord);
                    loginListener.loginSuccess(user);
                } else
                {
                    loginListener.loginFailed();
                }
            }
        }.start();
    }
}
