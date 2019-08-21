# 抽象工厂模式


应用实例：
工作了，为了参加一些聚会，肯定有两套或多套衣服吧，比如说有商务装（成套，一系列具体产品）、时尚装（成套，一系列具体产品），甚至对于一个家庭来说，可能有商务女装、商务男装、时尚女装、时尚男装，这些也都是成套的，即一系列具体产品。
在您的家中，某一个衣柜（具体工厂）只能存放某一种这样的衣服（成套，一系列具体产品），每次拿这种成套的衣服时也自然要从这个衣柜中取出了。用 OOP 的思想去理解，所有的衣柜（具体工厂）都是衣柜类的（抽象工厂）某一个，而每一件成套的衣服又包括具体的上衣（某一具体产品），裤子（某一具体产品），这些具体的上衣其实也都是上衣（抽象产品），具体的裤子也都是裤子（另一个抽象产品）。


```
意图：
提供一个创建一系列相关或相互依赖对象的接口，而无需指定它们具体的类。

主要解决：
主要解决接口选择的问题。

何时使用：
系统的产品有多于一个的产品族，而系统只消费其中某一族的产品。

如何解决：
在一个产品族里面，定义多个产品。

关键代码：
在一个工厂里聚合多个同类产品。
```

![img](https://www.runoob.com/wp-content/uploads/2014/08/abstractfactory_pattern_uml_diagram.jpg)


1、创建 Shape 和 Color 接口；
2、实现 Shape 和 Color 这些接口的实体类；
3、创建抽象工厂类 AbstractFactory；
4、定义工厂类 ShapeFactory 和 ColorFactory，这两个工厂类都是扩展了 AbstractFactory；
5、创建一个工厂创造器/生成器类 FactoryProducer。

FactoryProducer生产工厂（ShapeFactory 或 ColorFactory） -> 
ShapeFactory 和 ColorFactory 生产对象(Shape 和 Color 这些接口的实体类的对象) ->
对象调用实例方法。


1、创建 Shape 和 Color 接口；

```java
public interface Shape {
   void draw();
}
```

```java
public interface Color {
   void fill();
}
```

2、实现 Shape 和 Color 这些接口的实体类

```java
Rectangle.java

public class Rectangle implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Rectangle::draw() method.");
   }
}
```

```java
public class Square implements Shape {
 
   @Override
   public void draw() {
      System.out.println("Inside Square::draw() method.");
   }
}
```



```java
public class Red implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Red::fill() method.");
   }
}
```

```java
public class Green implements Color {
 
   @Override
   public void fill() {
      System.out.println("Inside Green::fill() method.");
   }
}
```

3、创建抽象工厂类 AbstractFactory

```
public abstract class AbstractFactory {
   public abstract Color getColor(String color);
   public abstract Shape getShape(String shape) ;
}
```

4、定义工厂类 ShapeFactory 和 ColorFactory

```java
public class ShapeFactory extends AbstractFactory {
    
   @Override
   public Shape getShape(String shapeType){
      if(shapeType == null){
         return null;
      }        
      if(shapeType.equalsIgnoreCase("CIRCLE")){
         return new Circle();
      } else if(shapeType.equalsIgnoreCase("RECTANGLE")){
         return new Rectangle();
      } else if(shapeType.equalsIgnoreCase("SQUARE")){
         return new Square();
      }
      return null;
   }
   
   @Override
   public Color getColor(String color) {
      return null;
   }
}
```

```java
public class ColorFactory extends AbstractFactory {
    
   @Override
   public Shape getShape(String shapeType){
      return null;
   }
   
   @Override
   public Color getColor(String color) {
      if(color == null){
         return null;
      }        
      if(color.equalsIgnoreCase("RED")){
         return new Red();
      } else if(color.equalsIgnoreCase("GREEN")){
         return new Green();
      } else if(color.equalsIgnoreCase("BLUE")){
         return new Blue();
      }
      return null;
   }
}
```

5、创建一个工厂创造器/生成器类 FactoryProducer

```java
public class FactoryProducer {
   public static AbstractFactory getFactory(String choice){
      if(choice.equalsIgnoreCase("SHAPE")){
         return new ShapeFactory();
      } else if(choice.equalsIgnoreCase("COLOR")){
         return new ColorFactory();
      }
      return null;
   }
}
```

```java
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
```

