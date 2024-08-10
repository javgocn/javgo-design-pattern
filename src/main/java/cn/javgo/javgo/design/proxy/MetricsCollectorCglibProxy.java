package cn.javgo.javgo.design.proxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Desc：基于 CGLIB 的动态代理
 *
 * @author javgo
 * @date 2024-08-10
 */
public class MetricsCollectorCglibProxy implements MethodInterceptor {

    private MetricsCollector metricsCollector;

    public MetricsCollectorCglibProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    /**
     * 创建代理
     *
     * @param targetClass 目标类
     * @return 代理对象
     */
    public Object createProxy(Class<?> targetClass) {
        // 创建代理(目标类的子类)
        Enhancer enhancer = new Enhancer();
        // 设置代理类的父类为目标类
        enhancer.setSuperclass(targetClass);
        // 设置回调方法，this 表示当前类，即当前类实现了 MethodInterceptor 接口，所以可以作为回调方法
        enhancer.setCallback(this);
        return enhancer.create();
    }

    /**
     * 拦截器方法，用于在方法调用前后进行性能监控
     *
     * @param o 被拦截的实例
     * @param method 被拦截的方法
     * @param objects 被拦截方法的参数
     * @param methodProxy 方法代理，用于调用被拦截的方法
     * @return 被拦截方法的返回值
     * @throws Throwable 被拦截方法可能抛出的异常
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        long startTimestamp = System.currentTimeMillis();

        // 调用父类的方法
        Object result = methodProxy.invokeSuper(o, objects);

        long endTimeStamp = System.currentTimeMillis();
        long responseTime = endTimeStamp - startTimestamp;
        String apiName = o.getClass().getSuperclass().getName() + ":" + method.getName();
        RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
        metricsCollector.recordRequest(requestInfo);

        return result;
    }
}
