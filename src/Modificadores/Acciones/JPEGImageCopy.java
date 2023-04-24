package Modificadores.Acciones;

import Modificadores.BmpHandlerCopy;
import Modificadores.ImageHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class JPEGImageCopy extends ImageHandler {

    BmpHandlerCopy copia;
    public JPEGImageCopy(String filename) {
        super(filename);
        copia = new BmpHandlerCopy(filename);
    }

    @Override
    public void readFile() throws Exception {
        copia.readFile();
    }

    @Override
    public void generateFiles() throws Exception {
         copia.generateFiles();
    }
}
