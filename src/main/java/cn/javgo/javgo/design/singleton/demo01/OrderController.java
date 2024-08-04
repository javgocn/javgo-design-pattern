package cn.javgo.javgo.design.singleton.demo01;

/**
 * Desc: Logger类的应用示例
 *
 * @author javgo
 * @create 2024-08-04 14:02
 */
public class OrderController {

//    private Logger logger = new Logger();

    public void create(OrderVo order) {
        // ...省略业务逻辑代码...
//        logger.log("Created an order: " + order.toString());

        Logger.getInstance().log("Created an order: " + order.toString());
    }
}
