package Modificadores.Acciones;

import Interfaz.Principal;
import Modificadores.ImageHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class JPEGImageHandlerRotator extends ImageHandler {

    BufferedImage tempImagen;

    public JPEGImageHandlerRotator(String filename) {
        super(filename);
    }

    @Override
    public void readFile() throws Exception {
        tempImagen = ImageIO.read(new File(this.handledFileName));
    }

    @Override
    public void generateFiles() throws Exception {
        BufferedImage copiaRotadaenX = new BufferedImage(tempImagen.getWidth(), tempImagen.getHeight(), BufferedImage.TYPE_INT_RGB);
        BufferedImage copiaRotadaenY = new BufferedImage(tempImagen.getWidth(), tempImagen.getHeight(), BufferedImage.TYPE_INT_RGB);

        for (int i = 0; i < tempImagen.getWidth(); i++) {
            for (int j = 0; j < tempImagen.getHeight(); j++) {
                int pixel = tempImagen.getRGB(i, j);

                int nuevaPosX = (int) (tempImagen.getWidth() - 1 - i);
                int nuevaPosY = (int) (tempImagen.getHeight() - 1 - j);

                copiaRotadaenX.setRGB(nuevaPosX, j, pixel);
                copiaRotadaenY.setRGB(i, nuevaPosY, pixel);
            }
        }

        int indiceInicial = super.getFileName().lastIndexOf("\\") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");
        String nombreRotX = "Hrotation-" + this.handledFileName.substring(indiceInicial, indiceFinal);
        String nombreRotY = "Vrotation-" + this.handledFileName.substring(indiceInicial, indiceFinal);
        File fileRotX = new File(Principal.dir + nombreRotX+".JPEG");
        File fileRotY = new File(Principal.dir + nombreRotY+".JPEG");
        new File(fileRotX.getParent()).mkdirs();
        ImageIO.write(copiaRotadaenX, "JPEG", fileRotX);
        ImageIO.write(copiaRotadaenY, "JPEG", fileRotY);
    }

}
