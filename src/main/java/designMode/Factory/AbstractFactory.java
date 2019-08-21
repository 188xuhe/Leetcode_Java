package designMode.Factory;


//抽象工厂类
public abstract class AbstractFactory {
    public abstract Color getColor(String color);
    public abstract Shape getShape(String shape);

}
