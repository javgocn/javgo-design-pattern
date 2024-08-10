package cn.javgo.javgo.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Desc：动态代理
 *
 * @author javgo
 * @date 2024-08-10
 */
public class MetricsCollectorProxy {

    private MetricsCollector metricsCollector;

    public MetricsCollectorProxy() {
        this.metricsCollector = new MetricsCollector();
    }

    /**
     * 创建代理
     *
     * @param proxiedObject 被代理的对象
     * @return 代理对象
     */
    public Object createProxy(Object proxiedObject) {
        // 获取被代理对象的接口
        Class<?>[] interfaces = proxiedObject.getClass().getInterfaces();
        // 创建动态代理处理器
        DynamicProxyHandler handler = new DynamicProxyHandler(proxiedObject);
        // 创建动态代理对象(TIP: 这里的董涛代理实现类不需要我们编写，JDK会自动生成，然后调用handler的invoke方法)
        return Proxy.newProxyInstance(proxiedObject.getClass().getClassLoader(), interfaces, handler);
    }

    /**
     * 动态代理处理器
     */
    private class DynamicProxyHandler implements InvocationHandler {

        /**
         * 被代理的对象
         */
        private Object proxiedObject;

        public DynamicProxyHandler(Object proxiedObject) {
            this.proxiedObject = proxiedObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            long startTimestamp = System.currentTimeMillis();

            // 通过反射调用原始对象的方法
            Object result = method.invoke(proxiedObject, args);

            long endTimeStamp = System.currentTimeMillis();
            long responseTime = endTimeStamp - startTimestamp;

            String apiName = proxiedObject.getClass().getName() + ":" + method.getName();
            RequestInfo requestInfo = new RequestInfo(apiName, responseTime, startTimestamp);
            metricsCollector.recordRequest(requestInfo);

            return result;
        }
    }
}
