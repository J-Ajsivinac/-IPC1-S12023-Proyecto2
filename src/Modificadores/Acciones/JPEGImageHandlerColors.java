package Modificadores.Acciones;

import Modificadores.ImageHandler;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.imageio.ImageIO;

public class JPEGImageHandlerColors extends ImageHandler {

    BufferedImage jpg = null;
    BufferedImage bmp = null;
    File bmpTemporal;
    protected byte[] filebytes;

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
        bmp = new BufferedImage(jpg.getWidth(), jpg.getHeight(), BufferedImage.TYPE_INT_RGB);

        BufferedImage tonoRojo = new BufferedImage(jpg.getWidth(), jpg.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage tonoVerde = new BufferedImage(jpg.getWidth(), jpg.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage tonoAzul = new BufferedImage(jpg.getWidth(), jpg.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage sepia = new BufferedImage(jpg.getWidth(), jpg.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int xPixel = 0; xPixel < jpg.getWidth(); xPixel++) {
            for (int yPixel = 0; yPixel < jpg.getHeight(); yPixel++) {
                int color = jpg.getRGB(xPixel, yPixel);
                Color temp = new Color(color);
                Color redColor = new Color(temp.getRed(), 0, 0);
                Color blueColor = new Color(0, 0, temp.getBlue());
                Color greenColor = new Color(0, temp.getGreen(), 0);
                /*
                int sepiaBValue = (int)((rValue * 0.272) + (gValue * 0.534) + (bValue * 0.131));
		int sepiaGValue = (int)((rValue * 0.349) + (gValue * 0.686) + (bValue * 0.168));
		int sepiaRValue = (int)((rValue * 0.393) + (gValue * 0.769) + (bValue * 0.189));
                 */
                int rojosepia = (int) (0.393 * temp.getRed() + 0.769 * temp.getGreen() + 0.189 * temp.getBlue());
                int verdesepia = (int) (0.393 * temp.getRed() + 0.686 * temp.getGreen() + 0.168 * temp.getBlue());
                int azulsepia = (int) (0.272 * temp.getRed() + 0.534 * temp.getGreen() + 0.131 * temp.getBlue());

                rojosepia = rojosepia > 255 ? rojosepia = 255 : rojosepia;
                verdesepia = verdesepia > 255 ? verdesepia = 255 : verdesepia;
                azulsepia = azulsepia > 255 ? azulsepia = 255 : azulsepia;

                rojosepia = rojosepia < 0 ? rojosepia = 0 : rojosepia;
                verdesepia = verdesepia < 0 ? verdesepia = 0 : verdesepia;
                azulsepia = azulsepia < 0 ? azulsepia = 0 : azulsepia;

                Color sepiaColor = new Color(rojosepia, verdesepia, azulsepia);

                tonoRojo.setRGB(xPixel, yPixel, redColor.getRGB());
                tonoVerde.setRGB(xPixel, yPixel, blueColor.getRGB());
                tonoAzul.setRGB(xPixel, yPixel, greenColor.getRGB());
                sepia.setRGB(xPixel, yPixel, sepiaColor.getRGB());

            }
        }
        //FileOutputStream output = new FileOutputStream("C:/Users/mesoi/Documents/Prueba/Temporal/TempR" + ".jpg");
        //FileOutputStream output1 = new FileOutputStream("C:/Users/mesoi/Documents/Prueba/Temporal/TempV" + ".jpg");
        //FileOutputStream output2 = new FileOutputStream("C:/Users/mesoi/Documents/Prueba/Temporal/TempA" + ".jpg");
        FileOutputStream output3 = new FileOutputStream("C:/Users/mesoi/Documents/Prueba/Temporal/TempS4" + ".jpg");
        try {
            //ImageIO.write(tonoRojo, "jpg", output);
            //ImageIO.write(tonoVerde, "jpg", output1);
            //ImageIO.write(tonoAzul, "jpg", output2);
            ImageIO.write(sepia, "jpg", output3);
            //output.close();
            //output1.close();
            //output2.close();
            output3.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
