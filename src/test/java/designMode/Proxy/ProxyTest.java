package designMode.Proxy;

import designMode.Proxy.Image;
import designMode.Proxy.ProxyImage;

public class ProxyTest {
    public static void main(String[] args){
        Image image = new ProxyImage();
        image.display();
    }
}
