package designMode.Factory;


//创建扩展了 AbstractFactory 的工厂类
public class ShapeFactory extends AbstractFactory {
    @Override
    public Color getColor(String shapeType) {
        return null;
    }

    @Override
    public Shape getShape(String shapeType) {
        if(shapeType == null){
            return null;
        }
        if(shapeType.equalsIgnoreCase("CIRCLE")){
            return new Circle();
        } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
            return new Rectangle();
        }
        return null;
    }
}
