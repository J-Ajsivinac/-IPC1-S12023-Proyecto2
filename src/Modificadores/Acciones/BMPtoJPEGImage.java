package Modificadores.Acciones;

import Modificadores.ImageHandler;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;

public class BMPtoJPEGImage extends ImageHandler {

    protected String conversionName;
    private File input = null;
    private BufferedImage imagen = null;

    public BMPtoJPEGImage(String filename) {
        super(filename);
        int indiceInicial = super.getFileName().lastIndexOf("\\") + 1;
        int indiceFinal = super.getFileName().lastIndexOf(".");
        System.out.println(indiceInicial + "-/-" + indiceFinal);
        this.conversionName = "converted-" + filename.substring(indiceInicial, indiceFinal);
    }

    @Override
    public void readFile() throws Exception {
        System.out.println(this.handledFileName);
        input = new File(this.handledFileName);
        imagen = ImageIO.read(input);
    }

    @Override
    public void generateFiles() throws Exception {
        File output = new File("C:/Users/mesoi/Documents/Prueba/Temporal/" + conversionName + ".jpeg");
        ImageIO.write(imagen, "jpeg", output);
    }

}
