package cn.javgo.javgo.design.proxy;

/**
 * Desc：
 *
 * @author javgo
 * @date 2024-08-10
 */
public interface IUserController {
    UserVo login(String telephone, String password);
    UserVo register(String telephone, String password);
}
