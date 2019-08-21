package designMode.Order;

public class CommandPatternDemo {
    public static void main(String[] args) {
        Stock abcStock = new Stock();

        Buy buyStockOrder = new Buy(abcStock);
        Sell sellStockOrder = new Sell(abcStock);

        Invoker broker = new Invoker();
        broker.takeOrder(buyStockOrder);
        broker.takeOrder(sellStockOrder);

        broker.placeOrders();
    }
}
