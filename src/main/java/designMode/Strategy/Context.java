package designMode.Strategy;

//创建 Context 类
public class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int execu(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
