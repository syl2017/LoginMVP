package mvp.biz;

/**
 * Created by Robot on 2017/5/1.
 */

public interface IUserBiz {
    void login(String userName,String passWord,OnLoginListener loginListener);
}
