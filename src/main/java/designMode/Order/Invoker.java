package designMode.Order;

import java.util.ArrayList;
import java.util.List;


//调用者
public class Invoker {
    private List<Order> orderList = new ArrayList<>();

    public void takeOrder(Order order){
        orderList.add(order);
    }

    /**
     * 执行orderList 中的order，最后清除orderList
     */
    public void placeOrders(){
        for (Order order : orderList){
            order.execute();
        }
        orderList.clear();
    }
}
