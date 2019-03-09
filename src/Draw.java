import java.awt.image.BufferedImage;

public interface Draw {
    
    void draw(Square square, BufferedImage image);
    
    void draw(Rectangle rectangle, BufferedImage image);
    
    void draw(Line line, BufferedImage image);
    
    void draw(Circle circle, BufferedImage image);
    
    void draw(Triangle triangle, BufferedImage image);
    
    void draw(Diamond diamond, BufferedImage image);
    
    void draw(Polygon polygon, BufferedImage image);
    
}
