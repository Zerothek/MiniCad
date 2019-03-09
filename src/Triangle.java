import java.awt.image.BufferedImage;
import java.io.IOException;

import fileio.implementations.FileReader;

public class Triangle extends Shape implements BeDrawn{
    
    private int x1;
    private int y1;
    private int x2;
    private int y2;
    private int x3;
    private int y3;
    private String line;
    private int transpLine;
    private String fill;
    private int transpFill;
    private BufferedImage image;
    private static Triangle triangle;
    
    private Triangle(FileReader read, BufferedImage newImage) throws IOException {
        x1 = read.nextInt();
        y1 = read.nextInt();
        x2 = read.nextInt();
        y2 = read.nextInt();
        x3 = read.nextInt();
        y3 = read.nextInt();
        line = read.nextWord();
        transpLine = read.nextInt();
        fill = read.nextWord();
        transpFill = read.nextInt();
        image = newImage;
    }
    
    public static Triangle getShape(FileReader read, BufferedImage image) throws IOException {
        triangle = new Triangle(read, image);
        return triangle;
    }
    
    public final int getX1() {
        return x1;
    }
    
    public final int getY1() {
        return y1;
    }
    
    public final int getX2() {
        return x2;
    }
    
    public final int getY2() {
        return y2;
    }
    
    public final int getX3() {
        return x3;
    }
    
    public final int getY3() {
        return y3;
    }
    
    public final int getTranspLine() {
        return transpLine;
    }
    
    public final int getTranspFill() {
        return transpFill;
    }
    
    public final String getLine() {
        return line;
    }
    
    public final String getFill() {
        return fill;
    }

    @Override
    public void beDrawn(Draw d) {
        
        d.draw(this, image);
        
    }

}
