package cn.javgo.javgo.design.factory.demo;

import org.springframework.beans.factory.NoSuchBeanDefinitionException;

import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Desc：bean 工厂
 *
 * @author javgo
 * @date 2024-08-10
 */
public class BeansFactory {

    /**
     * 容器初始化时候，将所有单例 bean 放入容器中
     */
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();

    /**
     * bean 定义
     */
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    /**
     * 获取 bean
     * @param beanId bean id
     * @return bean
     */
    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        if (beanDefinition == null) {
            throw new NoSuchBeanDefinitionException("Bean is not defined: " + beanId);
        }
        return createBean(beanDefinition);
    }

    /**
     * 添加 bean 定义
     * @param beanDefinitionList bean 定义列表
     */
    public void addBeanDefinitions(List<BeanDefinition> beanDefinitionList) {
        // 存入 bean 定义
        for (BeanDefinition beanDefinition : beanDefinitionList) {
            this.beanDefinitions.putIfAbsent(beanDefinition.getId(), beanDefinition);

            // 预先创建非懒加载的单例 bean
            if (!beanDefinition.isLazyInit() && beanDefinition.isSingleton()) {
                createBean(beanDefinition);
            }
        }
    }

    /**
     * 创建 bean
     * @param beanDefinition bean 定义
     * @return bean
     */
    protected Object createBean(BeanDefinition beanDefinition) {
        // 如果是单例且已存在，直接返回
        if (beanDefinition.isSingleton() && singletonObjects.contains(beanDefinition.getId())) {
            return singletonObjects.get(beanDefinition.getId());
        }

        // 反射创建 bean
        Object bean = null;
        try {
            // 获取 bean 类
            Class<?> beanClass = Class.forName(beanDefinition.getClassName());
            // 获取构造函数参数
            List<BeanDefinition.ConstructorArg> args = beanDefinition.getConstructorArgs();

            if (args.isEmpty()) {
                // 无参构造函数
                bean = beanClass.newInstance();
            } else {
                // 带参数的构造函数

                // 获取构造函数参数类型
                Class<?>[] argClasses = new Class<?>[args.size()];
                // 获取构造函数参数值
                Object[] argObjects = new Object[args.size()];

                for (int i = 0; i < args.size(); i++) {
                    BeanDefinition.ConstructorArg arg = args.get(i);
                    if (!arg.isRef()) {
                        // 普通类型参数
                        argClasses[i] = arg.getType();
                        argObjects[i] = arg.getArg();
                    } else {
                        // 引用类型参数

                        // 进行依赖注入
                        BeanDefinition refBeanDefinition = beanDefinitions.get(arg.getArg());
                        if (refBeanDefinition == null) {
                            throw new NoSuchBeanDefinitionException("Bean is not defined: " + arg.getArg());
                        }
                        argClasses[i] = Class.forName(refBeanDefinition.getClassName());
                        // 递归创建 bean
                        argObjects[i] = createBean(refBeanDefinition);
                    }
                }
                bean = beanClass.getConstructor(argClasses).newInstance(argObjects);
            }
        } catch (ClassNotFoundException | IllegalAccessException
                 | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new BeanCreationFailureException("Failed to create bean: " + beanDefinition.getId(), e);
        }

        // 如果是单例，将其放入缓存
        if (beanDefinition.isSingleton()) {
            singletonObjects.putIfAbsent(beanDefinition.getId(), bean);
            return singletonObjects.get(beanDefinition.getId());
        }

        return bean;
    }
}
