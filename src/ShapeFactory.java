import java.awt.image.BufferedImage;
import java.io.IOException;

import fileio.implementations.FileReader;

public class ShapeFactory {
    
   public Shape getShape(String shapeType, FileReader read, BufferedImage image) throws IOException{
      if(shapeType == null){
         return null;
      }     
         
      if(shapeType.equals("SQUARE")){
          Square square = Square.getShape(read, image);
         return square;
      }
      
      if(shapeType.equals("RECTANGLE")){
          Rectangle rectangle = Rectangle.getShape(read, image);
         return rectangle;
      }
      
      if(shapeType.equals("LINE")){
          Line line = Line.getShape(read, image);
         return line;
      }
      
      if(shapeType.equals("CIRCLE")){
          Circle circle = Circle.getShape(read, image);
         return circle;
      }
      
      if(shapeType.equals("TRIANGLE")){
          Triangle triangle = Triangle.getShape(read, image);
         return triangle;
      }
      
      if(shapeType.equals("DIAMOND")){
          Diamond diamond = Diamond.getShape(read, image);
         return diamond;
      }
      
      if(shapeType.equals("POLYGON")){
          Polygon polygon = Polygon.getShape(read, image);
         return polygon;
      }
      
      return null;
   }
}