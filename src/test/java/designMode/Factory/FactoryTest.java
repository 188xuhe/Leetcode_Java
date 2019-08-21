package designMode.Factory;

public class FactoryTest {
    public static void main(String[] args){
        //获取形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("SHAPE");
        //获取形状为 Circle 的对象
        assert shapeFactory != null;
        Shape shape1 = shapeFactory.getShape("CIRCLE");
        //调用 Circle 的 draw 方法
        shape1.draw();

        /*****************************************************************************/

        //获取颜色工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("COLOR");
        //获取颜色为 Red 的对象
        assert colorFactory != null;
        Color color1 = colorFactory.getColor("RED");
        //调用 Red 的 fill 方法
        color1.fill();

    }
}
