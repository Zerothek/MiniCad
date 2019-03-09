import java.awt.image.BufferedImage;
import java.io.IOException;

import fileio.implementations.FileReader;

public class Rectangle extends Shape implements BeDrawn{
    
    private int xUp;
    private int yUp;
    private int height;
    private int width;
    private String line;
    private int transpLine;
    private String fill;
    private int transpFill;
    private BufferedImage image;
    private static Rectangle rectangle;
    
    private Rectangle(FileReader read, BufferedImage newImage) throws IOException {
        xUp = read.nextInt();
        yUp = read.nextInt();
        height = read.nextInt();
        width = read.nextInt();
        line = read.nextWord();
        transpLine = read.nextInt();
        fill = read.nextWord();
        transpFill = read.nextInt();
        image = newImage;
    }
    
    public static Rectangle getShape(FileReader read, BufferedImage image) throws IOException {
        rectangle = new Rectangle(read, image);
        return rectangle;
    }
    
    public final int getXUp() {
        return xUp;
    }
    
    public final int getYUp() {
        return yUp;
    }
    
    public final int getHeight() {
        return height;
    }
    
    public final int getWidth() {
        return width;
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
