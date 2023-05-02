package Modificadores.Acciones;

import Interfaz.Principal;
import Modificadores.BmpHandlerCopy;
import Modificadores.ImageHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class JPEGImageCopy extends ImageHandler {

    protected String conversionName;
    BmpHandlerCopy copia;

    public JPEGImageCopy(String filename) {
        super(filename);
        int indiceInicial = super.getFileName().lastIndexOf("\\") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");
        System.out.println(indiceInicial + "-/-" + indiceFinal);
        this.conversionName = "copy-" + filename.substring(indiceInicial, indiceFinal);
        copia = new BmpHandlerCopy(filename);
    }

    @Override
    public void readFile() throws Exception {
        copia.readFile();
    }

    @Override
    public void generateFiles() throws Exception {
        File fileBN = new File(Principal.dir + conversionName + ".jpeg");
        new File(fileBN.getParent()).mkdirs();
        copia.generateFiles();
    }
}
