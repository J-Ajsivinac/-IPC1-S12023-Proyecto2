package Modificadores.MisClases;

import Interfaz.Convertidor;
import static Interfaz.Convertidor.buttonRound2;
import static Interfaz.Convertidor.check1;
import static Interfaz.Convertidor.check2;
import static Interfaz.Convertidor.check3;
import static Interfaz.Convertidor.check4;
import static Interfaz.Convertidor.check5;
import static Interfaz.Convertidor.listaP;
import static Interfaz.Convertidor.model;
import static Interfaz.Convertidor.modelA;
import static Interfaz.Convertidor.op;
import static Interfaz.Convertidor.progreso;
import Interfaz.Principal;
import Modificadores.Acciones.*;
import Modificadores.ImageHandler;
import Modificadores.JPEGHandler;
import java.io.File;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

public class ejecutarP implements Runnable {

    private ImageHandler imagen;
    private int pasos;
    private StringBuilder sb = new StringBuilder();
    private String ruta;
    private int max;

    public ejecutarP(int opcion, String ruta, int pasos, String nombreArchivo, int max) {
        this.pasos = pasos;
        this.ruta = ruta;
        this.max = max;
        switch (opcion) {
            case 1:
                File crear = new File(Principal.dir);
                System.out.println(crear + "||");
                new File(crear.getParent()).mkdirs();
                imagen = new JPEGtoBMPImage(ruta);
                sb.append("Imagen:  " + nombreArchivo + "  ==> Filtro: JPEG a BMP y Viceversa\n");
                break;
            case 2:
                imagen = new JPEGImageCopy(ruta);
                sb.append("Imagen:  " + nombreArchivo + "  ==> Filtro: Copia JPEG\n");
                break;
            case 3:
                imagen = new JPEGImageHandlerColors(ruta);
                sb.append("Imagen:  " + nombreArchivo + "  ==> Filtro: Rojo Verde Azul Sepia\n");
                break;
            case 4:
                imagen = new JPEGImageHandlerRotator(ruta);
                sb.append("Imagen:  " + nombreArchivo + "  ==> Filtro: ModificarImagen\n");
                break;
            case 5:
                imagen = new JPEGImageHandlerBN(ruta);
                sb.append("Imagen:  " + nombreArchivo + "  ==> Filtro: Blanco y Negro\n");
                break;
            default:
                break;
        }

    }

    public void run() {
        try {
            JPEGHandler.runHandler(imagen);

            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    Convertidor.progreso.setValue((int) (Convertidor.progreso.getValue() + pasos));
                    Convertidor.consola.append(sb.toString());
                    int cantidadimg = max / Convertidor.total;
                    for (int i = 0; i < Convertidor.model.size(); i++) {
                        if (Convertidor.model.get(i).equals(ruta)) {
                            Convertidor.cantidad.set(i, Convertidor.cantidad.get(i) + 1);
                            if (Convertidor.cantidad.get(i) == cantidadimg) {
                                Convertidor.model.removeElementAt(i);
                                Convertidor.cantidad.remove(i);
                            }
                        }
                    }

                    if (model.getSize() == 0 && Convertidor.progreso.getValue() >= 100) {
                        modelA.removeAllElements();
                        Convertidor.nombres.removeAllElements();
                        listaP.vaciarLista();
                        op.vaciarLista();

                        check1.setSelected(false);
                        check2.setSelected(false);
                        check3.setSelected(false);
                        check4.setSelected(false);
                        check5.setSelected(false);
                        buttonRound2.setEnabled(true);
                        JOptionPane.showMessageDialog(null, "Filtros Aplicados");
                    }
                }
            });

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
