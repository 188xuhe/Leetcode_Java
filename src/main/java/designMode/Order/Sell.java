package designMode.Order;


//卖命令
public class Sell implements Order{
    private Stock stock;

    public Sell(Stock stock){
        this.stock = stock;
    }
    @Override
    public void execute() {
        stock.sell();
    }
}
