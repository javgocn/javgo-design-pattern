package cn.javgo.javgo.design.factory.demo;

/**
 * Desc：Bean 创建失败异常
 *
 * @author javgo
 * @date 2024-08-10
 */
public class BeanCreationFailureException extends RuntimeException {

    public BeanCreationFailureException(String message) {
        super(message);
    }

    public BeanCreationFailureException(String message, Throwable cause) {
        super(message, cause);
    }
}
