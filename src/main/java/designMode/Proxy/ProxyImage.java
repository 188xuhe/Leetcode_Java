package designMode.Proxy;

public class ProxyImage implements Image{
    private Image image;

    public ProxyImage(){
        System.out.println("这是代理类");
        image = new RealImage();
    }
    @Override
    public void display() {
        System.out.println("代理显示");
    }
}
