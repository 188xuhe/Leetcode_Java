package designMode.Strategy;

public class StrategyPatternDemo {
    public static void main(String[] args){
        Context context = new Context(new OperationAdd());
        System.out.println("10 + 5 = " + context.execu(10, 5));

        Context context1 = new Context(new OperationSubstract());
        System.out.println("10 - 5 = " + context1.execu(10, 5));
    }
}
