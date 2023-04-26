package Modificadores.MisClases;

import Interfaz.Convertidor;
import Modificadores.Acciones.*;
import Modificadores.JPEGHandler;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ejecutarP extends Thread {

    private int opcion = 0;
    private String ruta;
    private String nombreArchivo = "";
    private int max;
    private int pasos;
    public ejecutarP(int opcion, String ruta, int max) {
        this.opcion = opcion;
        this.ruta = ruta;
        this.max = max;
        double division = (100.0/max);
        BigDecimal temp = new BigDecimal(100.0/max);
        pasos = temp.setScale(0, RoundingMode.UP).intValue();
        int iNombre = ruta.lastIndexOf("\\") + 1;
        int fNombre = ruta.lastIndexOf(".");
        nombreArchivo = ruta.substring(iNombre, fNombre);
    }

    public void run() {
        System.out.println("");
        try {
            procesar();
            Convertidor.progreso.setValue((int) (Convertidor.progreso.getValue()+pasos));
        } catch (Exception ex) {
            Logger.getLogger(ejecutarP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void procesar() throws Exception {

        int indiceInicial = ruta.lastIndexOf(".");
        String extension = ruta.substring(indiceInicial + 1, ruta.length());
        switch (opcion) {
            case 1:
                if (extension.equals("bmp")) {
                    BMPtoJPEGImage filtroConversion = new BMPtoJPEGImage(ruta);
                    JPEGHandler.runHandler(filtroConversion);
                } else {
                    JPEGtoBMPImage filtroConversion = new JPEGtoBMPImage(ruta);
                    JPEGHandler.runHandler(filtroConversion);
                }
                
                Convertidor.consola.append("Imagen: { " + nombreArchivo + " } > Filtro: JPEG a BMP y Viceversa\n");
                break;
            case 2:
                if (!extension.equals("bmp")) {
                    JPEGImageCopy fitroCopiar = new JPEGImageCopy(ruta);
                    JPEGHandler.runHandler(fitroCopiar);
                    
                    Convertidor.consola.append("Imagen: { " + nombreArchivo + " } > Filtro: Copia JPEG\n");
                }

                break;
            case 3:
                if (!extension.equals("bmp")) {
                    JPEGImageHandlerColors filtroColores = new JPEGImageHandlerColors(ruta);
                    JPEGHandler.runHandler(filtroColores);
                    Convertidor.consola.append("Imagen: { " + nombreArchivo + " } > Filtro: Rojo Verde Azul Sepia\n");
                }
                break;
            case 4:
                if (!extension.equals("bmp")) {
                    JPEGImageHandlerRotator filtroRotar = new JPEGImageHandlerRotator(ruta);
                    JPEGHandler.runHandler(filtroRotar);
                    Convertidor.consola.append("Imagen: { " + nombreArchivo + " } > Filtro: ModificarImagen\n");
                }
                break;
            case 5:
                if (!extension.equals("bmp")) {
                    JPEGImageHandlerBN filtroBN = new JPEGImageHandlerBN(ruta);
                    JPEGHandler.runHandler(filtroBN);
                    Convertidor.consola.append("Imagen: { " + nombreArchivo + " } > Filtro: Blanco y Negro\n");
                }
                break;
            default:
                throw new AssertionError();
        }
    }

}
