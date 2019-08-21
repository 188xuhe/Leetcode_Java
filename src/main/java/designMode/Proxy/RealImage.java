package designMode.Proxy;

public class RealImage implements Image {
    @Override
    public void display() {
        System.out.println("这是被代理的的类");
    }
}
