import java.awt.Color;

public class Shape {

    public final int returnColor(String color,int transparency) {
        String R = color.substring(1, 3);
        String G = color.substring(3, 5);
        String B = color.substring(5, 7);
        int r = Integer.parseInt(R, 16);
        int g = Integer.parseInt(G, 16);
        int b = Integer.parseInt(B, 16);
        Color col = new Color(r, g, b, transparency);
        return col.getRGB(); 
    }
    
}
