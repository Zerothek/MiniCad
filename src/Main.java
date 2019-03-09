import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fileio.implementations.FileReader;

public class Main {
    
	/*This function returns an int corresponding to a hexa color represented as a string
	 * Ex: #FFFFA1*/
    private static int returnColor(String color,int transparency) {
        String R = color.substring(1, 3);
        String G = color.substring(3, 5);
        String B = color.substring(5, 7);
        int r = Integer.parseInt(R, 16);
        int g = Integer.parseInt(G, 16);
        int b = Integer.parseInt(B, 16);
        Color col = new Color(r, g, b, transparency);
        return col.getRGB(); 
    }

    public static void main(String[] args) throws IOException {
        
        String input = "input.txt";
      //  String input = args[0];
        FileReader read = new FileReader(input);
        int nrShapes,height,width,transparency;
        String shape,color;
        nrShapes = read.nextInt();	/*the number of shapes to be drawn*/
        
        //Drawing the canvas
        shape = read.nextWord(); 	/*the first shape in the file is always the canvas*/
        height = read.nextInt();	/*the height of the canvas*/
        width = read.nextInt();		/*the width of the canvas*/
        color = read.nextWord();	/*the color of the canvas*/
        transparency = read.nextInt();	/*the transparency of the canvas*/
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);

        int rgb = returnColor(color, transparency);
        

        /*Draw the backround*/
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                image.setRGB(x, y,rgb);
            }
        }
        
        nrShapes--;
        //end of the canvas
        DrawShape draw = new DrawShape();
        ShapeFactory shapeFactory = new ShapeFactory();
        
        /*Read the next shapes which are to be drawn(and their parameters) from the file
          and draw them.*/
        while(nrShapes > 0) {
            
            nrShapes--;
            shape = read.nextWord();
            if (shape.equals("SQUARE")) {
                Shape square = shapeFactory.getShape("SQUARE", read, image);
                draw.draw((Square)square, image);
            }
            
            if (shape.equals("RECTANGLE")) {
                Shape rectangle = shapeFactory.getShape("RECTANGLE", read, image);
                draw.draw((Rectangle)rectangle, image);
            }
            
            if (shape.equals("LINE")) {
                Shape line = shapeFactory.getShape("LINE", read, image);
                draw.draw((Line)line, image);
            }
            
            if (shape.equals("CIRCLE")) {
                Shape circle = shapeFactory.getShape("CIRCLE", read, image);
                draw.draw((Circle)circle, image);
            }
            
            if (shape.equals("TRIANGLE")) {
                Shape triangle = shapeFactory.getShape("TRIANGLE", read, image);
                draw.draw((Triangle)triangle, image);
            }
            
            if (shape.equals("DIAMOND")) {
                Shape diamond = shapeFactory.getShape("DIAMOND", read, image);
                draw.draw((Diamond)diamond, image);
            }
            
            if (shape.equals("POLYGON")) {
                Shape polygon = shapeFactory.getShape("POLYGON", read, image);
                draw.draw((Polygon)polygon, image);
            }

             
        }

        /*Create the PNG file*/
        ImageIO.write(image, "PNG", new File("drawing.png"));
    }
}
