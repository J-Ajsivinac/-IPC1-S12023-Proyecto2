package Modificadores.MisClases;

import Interfaz.Convertidor;
import static Interfaz.Convertidor.listaP;
import static Interfaz.Convertidor.model;
import static Interfaz.Convertidor.modelA;
import static Interfaz.Convertidor.op;
import Modificadores.Acciones.*;
import Modificadores.JPEGHandler;
import java.io.File;
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
        double division = (100.0 / max);
        BigDecimal temp = new BigDecimal(100.0 / max);
        pasos = temp.setScale(0, RoundingMode.UP).intValue();
        int iNombre = ruta.lastIndexOf("\\") + 1;
        int fNombre = ruta.lastIndexOf(".");
        nombreArchivo = ruta.substring(iNombre, fNombre);

    }

    public void run() {
        try {
            procesar();
            Convertidor.progreso.setValue((int) (Convertidor.progreso.getValue() + pasos));
            File fTemp = new File(ruta + "");
            int cantidadimg = max / Convertidor.total;
            for (int i = 0; i < Convertidor.model.size(); i++) {
                if (Convertidor.model.get(i).equals(fTemp.getName())) {
                    Convertidor.cantidad.set(i, Convertidor.cantidad.get(i) + 1);

                    if (Convertidor.cantidad.get(i) == cantidadimg) {
                        Convertidor.model.removeElementAt(i);
                        Convertidor.cantidad.remove(i);
                    }
                }
            }
            if (model.size() == 0) {
                modelA.removeAllElements();
                Convertidor.nombres.removeAllElements();
                listaP.vaciarLista();
                op.vaciarLista();
                Convertidor.consola.append("\n");
            }

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

                Convertidor.consola.append("Imagen:  " + nombreArchivo + "  ==> Filtro: JPEG a BMP y Viceversa\n");
                break;
            case 2:
                if (!extension.equals("bmp")) {
                    JPEGImageCopy fitroCopiar = new JPEGImageCopy(ruta);
                    JPEGHandler.runHandler(fitroCopiar);

                    Convertidor.consola.append("Imagen:  " + nombreArchivo + "  ==> Filtro: Copia JPEG\n");
                }

                break;
            case 3:
                if (!extension.equals("bmp")) {
                    JPEGImageHandlerColors filtroColores = new JPEGImageHandlerColors(ruta);
                    JPEGHandler.runHandler(filtroColores);
                    Convertidor.consola.append("Imagen:  " + nombreArchivo + "  ==> Filtro: Rojo Verde Azul Sepia\n");
                }
                break;
            case 4:
                if (!extension.equals("bmp")) {
                    JPEGImageHandlerRotator filtroRotar = new JPEGImageHandlerRotator(ruta);
                    JPEGHandler.runHandler(filtroRotar);
                    Convertidor.consola.append("Imagen:  " + nombreArchivo + "  ==> Filtro: ModificarImagen\n");
                }
                break;
            case 5:
                if (!extension.equals("bmp")) {
                    JPEGImageHandlerBN filtroBN = new JPEGImageHandlerBN(ruta);
                    JPEGHandler.runHandler(filtroBN);
                    Convertidor.consola.append("Imagen:  " + nombreArchivo + "  ==> Filtro: Blanco y Negro\n");
                }
                break;
            default:
                throw new AssertionError();
        }
    }

}
