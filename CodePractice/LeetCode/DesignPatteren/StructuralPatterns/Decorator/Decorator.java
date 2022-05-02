package LeetCode.DesignPatteren.StructuralPatterns.Decorator;

interface Shape {
	void draw();
}

class Circle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape: Circle");

	}

}
class Rectangle implements Shape {

	@Override
	public void draw() {
		System.out.println("Shape: Rectangle");

	}

}
abstract class ShapeDecorator implements Shape 
{
	   protected Shape decoratedShape;

	   public ShapeDecorator(Shape decoratedShape){
	      this.decoratedShape = decoratedShape;
	   }

	   public void draw(){
	      decoratedShape.draw();
	   }	
}

class RedShapeDecorator extends ShapeDecorator {

	   public RedShapeDecorator(Shape decoratedShape) {
	      super(decoratedShape);		
	   }

	   @Override
	   public void draw() {
	      decoratedShape.draw();	       
	      setRedBorder(decoratedShape);
	   }

	   private void setRedBorder(Shape decoratedShape){
	      System.out.println("Border Color: Red");
	   }
	}
public class Decorator
{
	public static void main(String[] str)
	{
		Shape s=new RedShapeDecorator(new Circle());
		s.draw();
	}
}