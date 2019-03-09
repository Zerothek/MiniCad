import java.awt.image.BufferedImage;
import java.io.IOException;

import fileio.implementations.FileReader;

public class Diamond extends Shape implements BeDrawn{
    
    private int x;
    private int y;
    private int height;
    private int width;
    private String line;
    private int transpLine;
    private String fill;
    private int transpFill;
    private BufferedImage image;
    private static Diamond diamond;
    
    private Diamond(FileReader read, BufferedImage newImage) throws IOException {
        x = read.nextInt();
        y = read.nextInt();
        width = read.nextInt();
        height = read.nextInt();
        line = read.nextWord();
        transpLine = read.nextInt();
        fill = read.nextWord();
        transpFill = read.nextInt();
        image = newImage;
    }
    
    public static Diamond getShape(FileReader read, BufferedImage image) throws IOException {
        diamond = new Diamond(read, image);
        return diamond;
    }
    
    public final int getX() {
        return x;
    }
    
    public final int getY() {
        return y;
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
