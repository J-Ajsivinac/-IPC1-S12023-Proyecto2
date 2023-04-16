package Modificadores.Acciones;

import Modificadores.ImageHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.imageio.ImageIO;

public class JPEGtoBMPImage extends ImageHandler {

    protected byte[] filebytes;
    protected String conversionName;
    public boolean isBMP = false;
    private File input = null;
    private BufferedImage imagen = null;
    
    public JPEGtoBMPImage(String filename) {
        super(filename);
        int indiceInicial = super.getFileName().lastIndexOf("\\") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");
        System.out.println(indiceInicial + "-/-" + indiceFinal);
        this.conversionName = "converted-" + filename.substring(indiceInicial, indiceFinal);
        String extension = filename.substring(indiceFinal+1,filename.length());
        System.out.println(extension);
        isBMP = extension.equals("bmp") ? true : false;
    }

    @Override
    public void readFile() throws Exception {
        System.out.println(this.handledFileName);
        input = new File(this.handledFileName);
        imagen = ImageIO.read(input);
    }

    @Override
    public void generateFiles() throws Exception {
        String nuevaE = isBMP ? "jpeg" : "bmp";
        File output = new File("C:/Users/mesoi/Documents/Prueba/Temporal/" + conversionName + "."+nuevaE);
        ImageIO.write(imagen, nuevaE, output);
    }

}
