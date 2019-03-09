import java.awt.Color;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DrawShape implements Draw{

    @Override
    public void draw(Square square, BufferedImage image) {
        
        int xUp = square.getXUp();
        int yUp = square.getYUp();
        int dim = square.getDim();
        String fill = square.getFill();
        String line = square.getLine();
        int transpLine = square.getTranspLine();
        int transpFill = square.getTranspFill();
        int rgbLine = square.returnColor(line,transpLine);
        int rgbFill = square.returnColor(fill,transpFill);
        
        for (int y = yUp; y < yUp + dim; y++) {
            for (int x = xUp; x < xUp + dim; x++) {
                
                if (x < image.getWidth() && y < image.getHeight()) {
                
                    if (x == xUp || y == yUp || x == xUp + dim - 1 || y == yUp + dim - 1) {
                        image.setRGB(x, y, rgbLine);
                    } else {
                        image.setRGB(x, y, rgbFill);
                    }
                
                }
                
            }
        }
        
    }
    
    @Override
    public void draw(Rectangle rectangle, BufferedImage image) {
        
        int xUp = rectangle.getXUp();
        int yUp = rectangle.getYUp();
        int height = rectangle.getHeight();
        int width = rectangle.getWidth();
        String fill = rectangle.getFill();
        String line = rectangle.getLine();
        int transpLine = rectangle.getTranspLine();
        int transpFill = rectangle.getTranspFill();
        int rgbLine = rectangle.returnColor(line,transpLine);
        int rgbFill = rectangle.returnColor(fill,transpFill);
        
        for (int y = yUp; y < yUp + height; y++) {
            for (int x = xUp; x < xUp + width; x++) {
                
                if (x < image.getWidth() && y < image.getHeight()) {
                
                    if (x == xUp || y == yUp || x == xUp + width - 1 || y == yUp + height - 1) {
                        image.setRGB(x, y, rgbLine);
                    } else {
                        image.setRGB(x, y, rgbFill);
                    }
                
                }
                
            }
        }
        
    }
    
    
    
    @Override
    public void draw(Line line, BufferedImage image) {
        
        int x1 = line.getXDown();
        int y1 = line.getYDown();
        int x2 = line.getXUp();
        int y2 = line.getYUp();
     // initialize variables
        int x,y;
        x = line.getXDown();
        y = line.getYDown();
        int delta_x = Math.abs(x2 - x1);
        int delta_y = Math.abs(y2 - y1);
        int s1 = (int) Math.signum(x2 - x1);
        int s2 = (int) Math.signum(y2 - y1);
        int rgb = line.returnColor(line.getLineColor(), line.getTranspLine());
     
        // interchange delta_x and delta_y, depending on the slope of the line
        boolean interchanged;
        if (delta_y > delta_x)
        {
            int a = delta_x;
            delta_x = delta_y;
            delta_y = a;
            interchanged = true;
        }
        else interchanged = false;
     
        // initialize the error term to compensate for a nonzero intercept
        int error = 2 * delta_y - delta_x;
     
        for (int i = 0 ; i < delta_x; i++) {
           
            if (x < image.getWidth() && y < image.getHeight() && x >= 0 && y >= 0) {
                image.setRGB(x, y, rgb);
            }
     
            while (error > 0) {
                if (interchanged == true) x = x + s1;
                else y = y + s2;
                error = error - 2 * delta_x;
            }
     
            if (interchanged == true) y = y + s2;
            else x = x + s1;
     
            error = error + 2 * delta_y;
        }
        
    }

    @Override
    public void draw(Circle circle, BufferedImage image) {
        
        int x = circle.getX();
        int y = circle.getY();
        int r = circle.getRadius();
        int d = 3 - 2 * r;
        int p = 0,q = r;
        int rgb = circle.returnColor(circle.getLine(), circle.getTranspLine());
        int rgbFill = circle.returnColor(circle.getFill(), circle.getTranspFill());
        while (p < q) {
            
            drawCircle(x, y, p, q, rgb, rgbFill, image, circle.getFill(), circle.getTranspFill());
            p++;
            
            if (d < 0) {
                d = d + 4 * p + 6;
            } else {
                q--;
                d = d + 4 * (p - q) + 10;
            }
            drawCircle(x, y, p, q, rgb, rgbFill, image, circle.getFill(), circle.getTranspFill());
            
            
        }
        
        floodFill(x, y, rgb, rgbFill, image);
        
    }
    
    private final void drawCircleFill(int x, int y, int p, int q, int rgb, int rgbFill, BufferedImage image, String lineColor, int t) {
        
        DrawShape draw = new DrawShape();
        Line line = new Line();
        line.init(x-p+1, y+q, x+p, y+q, lineColor, t, image);
        draw.draw(line, image);
        
        line.init(x-p+1, y-q, x+p, y-q, lineColor, t, image);
        draw.draw(line, image);
        
        line.init(x-q+1, y+p, x+q, y+p, lineColor, t, image);
        draw.draw(line, image);
        
        line.init(x-q+1, y-p, x+q, y-p, lineColor, t, image);
        draw.draw(line, image);
        
    }
    
    private final void drawCircle(int x, int y, int p, int q, int rgb, int rgbFill, BufferedImage image, String lineColor, int t) {
        
        if (x+p < image.getWidth() && y+q < image.getHeight() && x+p >= 0 && y+q >= 0) {
        image.setRGB(x+p, y+q, rgb);
        }
        if (x-p < image.getWidth() && y+q < image.getHeight() && x-p >= 0 && y+q >= 0) {
        image.setRGB(x-p, y+q, rgb);
        }
        
        if (x+p < image.getWidth() && y-q < image.getHeight() && x+p >= 0 && y-q >= 0) {
        image.setRGB(x+p, y-q, rgb);
        }
        if (x-p < image.getWidth() && y-q < image.getHeight() && x-p >= 0 && y-q >= 0) {
        image.setRGB(x-p, y-q, rgb);
        }

        if (x+q < image.getWidth() && y+p < image.getHeight() && x+q >= 0 && y+p >= 0) {
        image.setRGB(x+q, y+p, rgb);
        }
        if (x-q < image.getWidth() && y+p < image.getHeight() && x-q >= 0 && y+p >= 0) {
        image.setRGB(x-q, y+p, rgb);
        }
        
        if (x+q < image.getWidth() && y-p < image.getHeight() && x+q >= 0 && y-p >= 0) {
        image.setRGB(x+q, y-p, rgb);
        }
        if (x-q < image.getWidth() && y-p < image.getHeight() && x-q >= 0 && y-p >= 0) {
        image.setRGB(x-q, y-p, rgb);
        }
        
    }
    
    private final void floodFill(int xC, int yC, int lineColor, int replacement, BufferedImage image) {
        
        LinkedList<Pixel> list = new LinkedList<Pixel>();
        Pixel p = new Pixel(xC, yC);
        list.add(p);
        int contor = 0;
        while (list.isEmpty() == false) {
            contor++;
            Pixel pix = list.remove();
            int x = pix.x;
            int y = pix.y;
            if (image.getRGB(x, y) != replacement) {
            image.setRGB(x, y, replacement);
            
            if (y-1 >= 0) {
                if (image.getRGB(x, y-1) != replacement && image.getRGB(x, y-1) != lineColor) {
                    Pixel e = new Pixel(x, y-1);
                        list.add(e);
                }
            }
            
            if (y+1 < image.getHeight()) {
                if (image.getRGB(x, y+1) != replacement && image.getRGB(x, y+1) != lineColor) {
                    Pixel e = new Pixel(x, y+1);
                        list.add(e);
                }
            }
            
            if (x-1 >= 0) {
                if (image.getRGB(x-1, y)  != replacement && image.getRGB(x-1, y) != lineColor) {
                    Pixel e = new Pixel(x-1, y);
                        list.add(e);
                }
            }
            
            if (x+1 < image.getWidth()) {
                if (image.getRGB(x+1, y)  != replacement && image.getRGB(x+1, y) != lineColor) {
                    Pixel e = new Pixel(x+1, y);
                        list.add(e);
                }
            }
            }
        }
        
    }

    @Override
    public void draw(Triangle triangle, BufferedImage image) {
        
        DrawShape draw = new DrawShape();
        Line line = new Line();
        line.init(triangle.getX1(), triangle.getY1(), triangle.getX2(), triangle.getY2(), triangle.getLine(), triangle.getTranspLine(), image);
        draw.draw(line, image);
        line.init(triangle.getX2(), triangle.getY2(), triangle.getX3(), triangle.getY3(), triangle.getLine(), triangle.getTranspLine(), image);
        draw.draw(line, image);
        line.init(triangle.getX3(), triangle.getY3(), triangle.getX1(), triangle.getY1(), triangle.getLine(), triangle.getTranspLine(), image);
        draw.draw(line, image);
        int xc = (triangle.getX1()+triangle.getX2()+triangle.getX3()) / 3;
        int yc = (triangle.getY1()+triangle.getY2()+triangle.getY3()) / 3;
        int rgbFill = triangle.returnColor(triangle.getFill(), triangle.getTranspFill()); 
        int rgb = triangle.returnColor(triangle.getLine(), triangle.getTranspLine()); 
        floodFill(xc, yc, rgb, rgbFill, image);
        
    }

    @Override
    public void draw(Diamond diamond, BufferedImage image) {
        
        DrawShape draw = new DrawShape();
        Line line = new Line();
        int xl,xr,yu,yd,xc,yc;
        xc = diamond.getX();
        yc = diamond.getY();
        xl = diamond.getX() - diamond.getWidth() / 2;
        xr = diamond.getX() + diamond.getWidth() / 2;
        yd = diamond.getY() - diamond.getHeight() / 2;
        yu = diamond.getY() + diamond.getHeight() / 2;
        line.init(xl, yc, xc, yu, diamond.getLine(), diamond.getTranspLine(), image);
        draw.draw(line, image);
        line.init(xc, yu, xr, yc, diamond.getLine(), diamond.getTranspLine(), image);
        draw.draw(line, image);
        line.init(xr, yc, xc, yd, diamond.getLine(), diamond.getTranspLine(), image);
        draw.draw(line, image);
        line.init(xc, yd, xl, yc, diamond.getLine(), diamond.getTranspLine(), image);
        draw.draw(line, image);
        int rgbFill = diamond.returnColor(diamond.getFill(), diamond.getTranspFill()); 
        int rgb = diamond.returnColor(diamond.getLine(), diamond.getTranspLine()); 
        floodFill(xc, yc, rgb, rgbFill, image);
        
    }

    @Override
    public void draw(Polygon polygon, BufferedImage image) {
        
        DrawShape draw = new DrawShape();
        Line line = new Line();
        Pixel[] coordinates = polygon.getCoordinates();
        int xc = 0, yc = 0;
        for (int i = 0; i < polygon.getNrNodes() - 1; i++) {
            int x1 = coordinates[i].x;
            int y1 = coordinates[i].y;
            int x2 = coordinates[i+1].x;
            int y2 = coordinates[i+1].y;
            line.init(x1, y1, x2, y2, polygon.getLine(), polygon.getTranspLine(), image);
            draw.draw(line, image);
            xc = xc + x1;
            yc = yc + y1;
        }
        int x1 = coordinates[polygon.getNrNodes() - 1].x;
        int y1 = coordinates[polygon.getNrNodes() - 1].y;
        int x2 = coordinates[0].x;
        int y2 = coordinates[0].y;
        line.init(x1, y1, x2, y2, polygon.getLine(), polygon.getTranspLine(), image);
        draw.draw(line, image);
        xc = xc + x1;
        yc = yc + y1;
        xc = xc / polygon.getNrNodes();
        yc = yc / polygon.getNrNodes();
        int rgbFill = polygon.returnColor(polygon.getFill(), polygon.getTranspFill()); 
        int rgb = polygon.returnColor(polygon.getLine(), polygon.getTranspLine()); 
        floodFill(xc, yc, rgb, rgbFill, image);
    }

}
