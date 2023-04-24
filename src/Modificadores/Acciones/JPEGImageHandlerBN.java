package Modificadores.Acciones;

import Interfaz.Principal;
import Modificadores.ImageHandler;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class JPEGImageHandlerBN extends ImageHandler {

    BufferedImage tempImagen;

    public JPEGImageHandlerBN(String filename) {
        super(filename);
    }

    @Override
    public void readFile() throws Exception {
        tempImagen = ImageIO.read(new File(this.handledFileName));
    }

    @Override
    public void generateFiles() throws Exception {
        BufferedImage imagenBN = new BufferedImage(tempImagen.getWidth(), tempImagen.getHeight(), BufferedImage.TYPE_INT_RGB);
        for (int xPixel = 0; xPixel < tempImagen.getWidth(); xPixel++) {
            for (int yPixel = 0; yPixel < tempImagen.getHeight(); yPixel++) {
                int color = tempImagen.getRGB(xPixel, yPixel);
                Color temp = new Color(color);

                int promedio = (int) ((temp.getRed() + temp.getGreen() + temp.getBlue()) / 3);

                Color colorBN = new Color(promedio, promedio, promedio);

                imagenBN.setRGB(xPixel, yPixel, colorBN.getRGB());

            }
        }
        int indiceInicial = super.getFileName().lastIndexOf("\\") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");
        
        String nombreBN = "BN-" + this.handledFileName.substring(indiceInicial, indiceFinal);
        
        File fileBN = new File(Principal.dir + nombreBN + ".jpg");
        new File(fileBN.getParent()).mkdirs();
        ImageIO.write(imagenBN, "jpg", fileBN);
        
    }

}
