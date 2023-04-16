
package Modificadores.MisClases;

import java.io.Serializable;
import java.util.ArrayList;


public class DatosCategoria implements Serializable{
    private String nombreCategoria;
    private ListaCircular imgCategoria;

    public DatosCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
        this.imgCategoria = new ListaCircular();
    }

    public String getNombreCategoria() {
        return nombreCategoria;
    }

    public void setNombreCategoria(String nombreCategoria) {
        this.nombreCategoria = nombreCategoria;
    }

    public ListaCircular getImgCategoria() {
        return imgCategoria;
    }

    public void setImgCategoria(ListaCircular imgCategoria) {
        this.imgCategoria = imgCategoria;
    }
        
}
