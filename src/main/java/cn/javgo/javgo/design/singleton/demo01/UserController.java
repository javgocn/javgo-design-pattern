package cn.javgo.javgo.design.singleton.demo01;

/**
 * Desc: Logger类的应用示例
 *
 * @author javgo
 * @create 2024-08-04 13:57
 */
public class UserController {

//    private Logger logger = new Logger();

    public void login(String username, String password) {
        // ...省略业务逻辑代码...
//        logger.log("用户 " + username + " 登录成功！");

        Logger.getInstance().log("用户 " + username + " 登录成功！");
    }
}
