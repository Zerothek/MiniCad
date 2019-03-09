import java.awt.image.BufferedImage;
import java.io.IOException;

import fileio.implementations.FileReader;

public class Square extends Shape implements BeDrawn{
    
    private int xUp;
    private int yUp;
    private int dim;
    private String line;
    private int transpLine;
    private String fill;
    private int transpFill;
    private BufferedImage image;
    private static Square square;	//Singleton
    
    private Square(FileReader read, BufferedImage newImage) throws IOException {
        xUp = read.nextInt();
        yUp = read.nextInt();
        dim = read.nextInt();
        line = read.nextWord();
        transpLine = read.nextInt();
        fill = read.nextWord();
        transpFill = read.nextInt();
        image = newImage;
    }
    
    public static Square getShape(FileReader read, BufferedImage image) throws IOException {
        square = new Square(read, image);
        return square;
    }
    
    public final int getXUp() {
        return xUp;
    }
    
    public final int getYUp() {
        return yUp;
    }
    
    public final int getDim() {
        return dim;
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
