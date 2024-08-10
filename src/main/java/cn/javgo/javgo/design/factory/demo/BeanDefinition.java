package cn.javgo.javgo.design.factory.demo;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc：bean 定义元数据
 *
 * @author javgo
 * @date 2024-08-10
 */
@Data
public class BeanDefinition {

    /**
     * bean id
     */
    private String id;

    /**
     * bean class
     */
    private String className;

    /**
     * 构造参数
     */
    private List<ConstructorArg> constructorArgs = new ArrayList<>();

    /**
     * 作用域(默认 prototype)
     */
    private Scope scope = Scope.PROTOTYPE;

    /**
     * 是否延迟初始化(默认 false)
     */
    private boolean lazyInit = false;

    /**
     * 是否单例
     */
    public boolean isSingleton() {
        return scope == Scope.SINGLETON;
    }

    /**
     * 构造参数
     */
    @Data
    public static class ConstructorArg {

        /**
         * 是否为引用
         */
        private boolean isRef;

        /**
         * 类型
         */
        private Class<?> type;

        /**
         * 值
         */
        private Object arg;
    }

    /**
     * 作用域
     */
    public static enum Scope {
        SINGLETON,
        PROTOTYPE
    }
}
