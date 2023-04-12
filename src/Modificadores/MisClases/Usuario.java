
package Modificadores.MisClases;

import java.util.ArrayList;


public class Usuario {
    String nombre;
    ArrayList<String> categoria;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.categoria = new ArrayList<>();
        this.categoria.add("General");
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getCategoria() {
        return categoria;
    }

    public void setCategoria(ArrayList<String> categoria) {
        this.categoria = categoria;
    }
    
    
    
}
