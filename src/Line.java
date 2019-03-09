import java.awt.image.BufferedImage;
import java.io.IOException;

import fileio.implementations.FileReader;

public class Line extends Shape implements BeDrawn{
    
    private static int xDown;
    private static int yDown;
    private static int xUp;
    private static int yUp;
    private static String lineColor;
    private static int transpLine;
    private static BufferedImage image;
    private static Line line;	//Singleton
    
    private Line(FileReader read, BufferedImage newImage) throws IOException {
        xDown = read.nextInt();
        yDown = read.nextInt();
        xUp = read.nextInt();
        yUp = read.nextInt();
        lineColor = read.nextWord();
        transpLine = read.nextInt();
        image = newImage;
    }
    
    Line() {
    }
    
    public static void init(int xD,int yD, int xU, int yU, String lC, int tL, BufferedImage newImage) {
        xDown = xD;
        yDown = yD;
        xUp = xU;
        yUp = yU;
        lineColor = lC;
        transpLine = tL;
        image = newImage;
    }
    
    public static Line getShape(FileReader read, BufferedImage image) throws IOException {
        line = new Line(read, image);
        return line;
    }
    
    public final int getXDown() {
        return xDown;
    }
    
    public final int getYDown() {
        return yDown;
    }
    
    public final int getXUp() {
        return xUp;
    }
    
    public final int getYUp() {
        return yUp;
    }   
    
    public final String getLineColor() {
        return lineColor;
    }
    
    public final int getTranspLine() {
        return transpLine;
    }

    @Override
    public void beDrawn(Draw d) {
        
        d.draw(this, image);
        
    }
    

    

}
