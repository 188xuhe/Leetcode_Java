package designMode.Order;

import org.omg.CORBA.Object;


//买命令
public class Buy implements Order {
    private Stock stock;

    public Buy(Stock stock){
        this.stock = stock;
    }

    @Override
    public void execute() {
        stock.buy();
    }
}
