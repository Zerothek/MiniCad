import java.awt.image.BufferedImage;
import java.io.IOException;

import fileio.implementations.FileReader;

public class Circle extends Shape implements BeDrawn{
    
    private int x;
    private int y;
    private int radius;
    private String line;
    private int transpLine;
    private String fill;
    private int transpFill;
    private BufferedImage image;
    private static Circle circle;
    
    private Circle(FileReader read, BufferedImage newImage) throws IOException {
        x = read.nextInt();
        y = read.nextInt();
        radius = read.nextInt();
        line = read.nextWord();
        transpLine = read.nextInt();
        fill = read.nextWord();
        transpFill = read.nextInt();
        image = newImage;
    }
    
    public static Circle getShape(FileReader read, BufferedImage image) throws IOException {
        circle = new Circle(read, image);
        return circle;
    }
    
    public final int getX() {
        return x;
    }
    
    public final int getY() {
        return y;
    }
    
    public final int getRadius() {
        return radius;
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
