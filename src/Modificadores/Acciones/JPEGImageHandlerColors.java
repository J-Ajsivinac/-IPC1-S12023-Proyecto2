package Modificadores.Acciones;

import Modificadores.ImageHandler;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JPEGImageHandlerColors extends ImageHandler {

    BufferedImage jpg = null;
    BufferedImage bmp = null;
    File bmpTemporal;

    public JPEGImageHandlerColors(String filename) {
        super(filename);
    }

    @Override
    public void readFile() throws Exception {
        jpg = ImageIO.read(new File(this.handledFileName));
    }

    @Override
    public void generateFiles() throws Exception {
        filtro();
    }

    public void filtro() throws IOException {
        int[][] array2D = new int[jpg.getWidth()][jpg.getHeight()];
        for (int xPixel = 0; xPixel < jpg.getWidth(); xPixel++) {
            for (int yPixel = 0; yPixel < jpg.getHeight(); yPixel++) {
                int color = jpg.getRGB(xPixel, yPixel);
                Color color1 = new Color(color, true);
                if (color == Color.BLACK.getRGB()) {
                    array2D[xPixel][yPixel] = 1;
                    System.out.println(color1+" XD ");
                } else {
                    array2D[xPixel][yPixel] = 0; // ?
                }
            }
        }
    }

}
