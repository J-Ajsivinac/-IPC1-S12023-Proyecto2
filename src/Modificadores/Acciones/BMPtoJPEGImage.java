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
        File output = new File("./Temporal/" + conversionName + ".jpeg");
        new File(output.getParent()).mkdirs();
        ImageIO.write(imagen, "jpeg", output);
    }

}
