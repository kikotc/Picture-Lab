import java.awt.Color;

public class Steganography {

    public static void main(String[] args) {
        Picture beach2 = new Picture("beach.jpg");
        beach2.explore();
        Picture copy2 = testSetLow(beach2, Color.PINK);
        copy2.explore();
        Picture copy3 = revealPicture(copy2);
        copy3.explore();
    }

    /**
     * Sets the highest two bits of each pixel’s colors
     * to the lowest two bits of each pixel’s colors
     */
    public static Picture revealPicture(Picture hidden) {
        Picture copy = new Picture(hidden);
        Pixel[][] pixels = copy.getPixels2D();
        Pixel[][] source = hidden.getPixels2D();
        for (int r = 0; r < pixels.length; r++) {
            for (int c = 0; c < pixels[0].length; c++) {
                Color col = source[r][c].getColor();
                pixels[r][c].setRed((pixels[r][c].getRed() % 64) + ((col.getRed() % 4) * 64));
                pixels[r][c].setBlue((pixels[r][c].getBlue() % 64) + ((col.getBlue() % 4) * 64));
                pixels[r][c].setGreen((pixels[r][c].getGreen() % 64) + ((col.getGreen() % 4) * 64));
            }
        }
        return copy;
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
     * Set the lower 2 bits in a pixel to the highest 2 bits in c
     */
    public static void setLow(Pixel p, Color c) {
        p.setRed((p.getRed() / 4 * 4) + (c.getRed() / 64));
        p.setGreen((p.getGreen() / 4 * 4) + (c.getGreen() / 64));
        p.setBlue((p.getBlue() / 4 * 4) + (c.getBlue() / 64));
    }

    public static Picture testSetLow(Picture p, Color c) {
        Pixel[][] pixels = p.getPixels2D();
        for (Pixel[] row : pixels) {
            for (Pixel column : row) {
                setLow(column, c);
            }
        }
        return p;
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