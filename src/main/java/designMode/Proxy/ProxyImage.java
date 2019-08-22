package designMode.Proxy;

public class ProxyImage implements Image{
    private RealImage realImage;

    public ProxyImage(){
        System.out.println("这是代理类");
        realImage = new RealImage();
    }
    @Override
    public void display() {
        System.out.println("代理显示");
        realImage.display();
    }
}
