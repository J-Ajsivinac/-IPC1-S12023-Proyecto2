
package Modificadores.MisClases;

import Interfaz.Principal;
import java.util.ArrayList;


public class Usuario {
    String nombre;
    ArrayList<DatosCategoria> categoriaU;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.categoriaU = new ArrayList<>();
        this.categoriaU.add(new DatosCategoria("General"));
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<DatosCategoria> getCategoria() {
        return categoriaU;
    }

    public void setCategoria(ArrayList<DatosCategoria> categoria) {
        this.categoriaU = categoria;
    }
    
    //
    
}
