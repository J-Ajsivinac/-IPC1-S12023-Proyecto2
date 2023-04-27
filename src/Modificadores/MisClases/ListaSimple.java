package Modificadores.MisClases;

import Modificadores.EstructuraDeDatos;
import java.io.Serializable;

public class ListaSimple<T> extends EstructuraDeDatos {

    private Nodo<T> inicio;
    private int size;

    private static class Nodo<T> implements Serializable{

        private T dato;
        private Nodo<T> siguiente;

        public Nodo(T dato) {
            this.dato = dato;
            this.siguiente = null;
        }

        public T getDato() {
            return dato;
        }

        public void setDato(T dato) {
            this.dato = dato;
        }

        public Nodo<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Nodo<T> siguiente) {
            this.siguiente = siguiente;
        }
    }

    //Constructor
    public ListaSimple() {
        this.inicio = null;
        this.size = 0;
    }

    @Override
    public void add(Object e) {
        Nodo<T> nuevoNodo = new Nodo<>((T) e);
        if (inicio == null) {
            inicio = nuevoNodo;
        } else {
            //Nodo<T> actual = inicio;
            nuevoNodo.siguiente = inicio;
            inicio = nuevoNodo;
        }
        size++;
    }

    @Override
    public Object peek() {
        if (inicio == null) {
            return null;
        }
        return inicio.dato;
    }

    @Override
        public Usuario find(Object e) {
        Nodo<T> actual = inicio;
        while (actual != null) {
            if (actual.getDato() instanceof Usuario) {
                Usuario usuarioB = (Usuario) actual.getDato();
                //return actual.dato;
                Usuario parametro = (Usuario) e;
                if (usuarioB.getNombre().equals(parametro.getNombre())) { // Compara los nombres
                    return usuarioB; // Retorna la persona si se encuentra
                }
            }
            actual = actual.siguiente;
        }
        return null;
    }

    @Override
    public Object getNext() {
        if (index >= size || inicio == null) {
            return null;
        }
        Nodo<T> actual = inicio;
        for (int i = 0; i < index; i++) {
            actual = actual.siguiente;
        }
        index++;
        return actual.dato;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (i < 0 || i >= size || inicio == null) {
            return null;
        }
        Nodo<T> actual = inicio;
        for (int j = 0; j < i; j++) {
            actual = actual.siguiente;
        }
        return actual.dato;
    }

    @Override
    public Object pop() {
        if (inicio == null) {
            return null;
        }
        Object dato = inicio.dato;
        inicio = inicio.siguiente;
        size--;
        return dato;
    }

    @Override
    public void delete(Object e) {
        if (inicio == null) {
            return;
        }
        if (inicio.dato.equals(e)) {
            inicio = inicio.siguiente;
            size--;
            return;
        }
        Nodo<T> actual = inicio;
        while (actual.siguiente != null && !actual.siguiente.dato.equals(e)) {
            actual = actual.siguiente;
        }
        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            size--;
        }
        
    }

    public void imprimirLista() {
        if (inicio == null) {
            System.out.println("La lista está vacía.");
        } else {
            Nodo<T> actual = inicio;
            while (actual != null) {
                Usuario ac = (Usuario) actual.getDato();
                System.out.print(ac.getNombre() + " ");
                actual = actual.getSiguiente();
            }
            System.out.println();
        }
    }
    
    public void vaciarLista(){
        inicio = null;
        size=0;
        index =0;
    }

}
