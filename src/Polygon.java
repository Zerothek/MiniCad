import java.awt.image.BufferedImage;
import java.io.IOException;

import fileio.implementations.FileReader;

public class Polygon extends Shape implements BeDrawn{
    
    private int nrNodes;
    private Pixel[] coordinates;
    private String line;
    private int transpLine;
    private String fill;
    private int transpFill;
    private BufferedImage image;
    private static Polygon polygon;
    
    private Polygon(FileReader read, BufferedImage newImage) throws IOException {
        nrNodes = read.nextInt();
        coordinates = new Pixel[nrNodes];
        for (int i = 0;i < nrNodes; i++) {
            int x = read.nextInt();
            int y = read.nextInt();
            Pixel p = new Pixel(x,y);
            coordinates[i] = p;
        }
        line = read.nextWord();
        transpLine = read.nextInt();
        fill = read.nextWord();
        transpFill = read.nextInt();
        image = newImage;
    }
    
    public static Polygon getShape(FileReader read, BufferedImage image) throws IOException {
        polygon = new Polygon(read, image);
        return polygon;
    }
    
    public final int getNrNodes() {
        return nrNodes;
    }
    
    public final Pixel[] getCoordinates() {
        return coordinates;
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
