package Modificadores.Acciones;

import Interfaz.Principal;
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
                tonoVerde.setRGB(xPixel, yPixel, greenColor.getRGB());
                tonoAzul.setRGB(xPixel, yPixel, blueColor.getRGB());
                sepia.setRGB(xPixel, yPixel, sepiaColor.getRGB());

            }
        }
        int indiceInicial = super.getFileName().lastIndexOf("\\") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");
        String nombreSin = this.handledFileName.substring(indiceInicial, indiceFinal);
        File output = new File(Principal.dir +"Red-"+ nombreSin + ".jpeg");
        File output1 = new File(Principal.dir +"Green-"+ nombreSin + ".jpeg");
        File output2 = new File(Principal.dir +"Blue-"+ nombreSin + ".jpeg");
        File output3 = new File(Principal.dir +"Sepia-"+ nombreSin + ".jpeg");
        new File(output.getParent()).mkdirs();
        new File(output1.getParent()).mkdirs();
        new File(output2.getParent()).mkdirs();
        new File(output3.getParent()).mkdirs();
        try {
            ImageIO.write(tonoRojo, "jpeg", output);
            ImageIO.write(tonoVerde, "jpeg", output1);
            ImageIO.write(tonoAzul, "jpeg", output2);
            ImageIO.write(sepia, "jpeg", output3);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
