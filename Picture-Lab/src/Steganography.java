import java.awt.Color;

public class Steganography {

    public static void main(String[] args) {
        Picture beach = new Picture("beach.jpg");
        beach.explore();
        Picture copy = testClearLow(beach);
        copy.explore();
    }

    /**
     * Clear the lower (rightmost) two bits in a pixel.
     */
    public static void clearLow(Pixel p) {
        /* To be implemented */
        p.setRed(p.getRed() / 4 * 4);
        p.setGreen(p.getGreen() / 4 * 4);
        p.setBlue(p.getBlue() / 4 * 4);
    }

    /**
     * Set the lower 2 bits in a pixel to the highest 2 bitsin c
     */
    public static void setLow(Pixel p, Color c) {
        /* To be implemented */
    }

    public static Picture testClearLow(Picture p) {
        Pixel[][] pixels = p.getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel column : row) {
                clearLow(column);
            }
        }
        return p;
    }

}