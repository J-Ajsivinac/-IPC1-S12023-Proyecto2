package Modificadores.MisClases;

import Interfaz.Biblioteca;
import Modificadores.EstructuraDeDatos;

public class ListaCircular extends EstructuraDeDatos {

    private Nodo inicio;
    private int size;
    private boolean activar;

    private static class Nodo {

        public Object dato;
        public Nodo siguiente;
        public Nodo anterior;

        public Nodo(Object valor) {
            this.dato = valor;
            this.siguiente = null;
            this.anterior = null;
        }
    }

    public ListaCircular() {
        this.inicio = null;
        this.size = 0;
        activar = false;
    }

    @Override
    public void add(Object e) {
        Nodo nuevoNodo = new Nodo(e);
        if (inicio == null) {
            inicio = nuevoNodo;
            inicio.siguiente = inicio;
            inicio.anterior = inicio;
        } else {
            Nodo ultimo = inicio.anterior;
            nuevoNodo.siguiente = inicio;
            nuevoNodo.anterior = ultimo;
            inicio.anterior = nuevoNodo;
            ultimo.siguiente = nuevoNodo;
            index = 0;
        }
        size++;
    }

    @Override
    public Object peek() {
        if (inicio != null) {
            return inicio.dato;
        }
        return null;
    }

    @Override
    public Object find(Object e) {
        if (inicio != null) {
            Nodo actual = inicio;
            do {
                if (actual.dato.equals(e)) {
                    return actual.dato;
                }
                actual = actual.siguiente;
            } while (actual != inicio);
        }
        return null;
    }

    @Override
    public Object getNext() {
        if (inicio != null && index >= 0 && index < size) {
            Nodo actual = inicio;
            System.out.println("next" + index);
            index = (index + 1) % size;
            System.out.println("next" + index + " " + actual.dato);

            for (int i = 0; i < index; i++) {
                actual = actual.siguiente;
            }
            Biblioteca.totalI.setText(index+1 + "/" + size);
            return actual.dato;

        }
        return null;
    }

    public Object getPrevious() {
        if (inicio != null && index >= 0 && index < size) {
            Nodo actual = inicio;
            System.out.println(index);
            index = (index - 1 + size) % size;
            System.out.println(index);
            for (int i = 0; i < index; i++) {
                actual = actual.siguiente;
                System.out.println("--");
            }
            Biblioteca.totalI.setText(index+1 + "/" + size);
            return actual.dato;

        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Object get(int i) {
        if (inicio != null && i >= 0 && i < size) {
            Nodo actual = inicio;
            for (int j = 0; j < i; j++) {
                actual = actual.siguiente;
            }
            return actual.dato;
        }
        return null;
    }

    @Override
    public Object pop() {
        if (inicio != null) {
            Nodo ultimo = inicio.anterior;
            Object valor = inicio.dato;
            if (inicio == inicio.siguiente) {
                inicio = null;
            } else {
                inicio = inicio.siguiente;
                inicio.anterior = ultimo;
                ultimo.siguiente = inicio;
            }
            size--;
            return valor;
        }
        return null;
    }

    @Override
    public void delete(Object e) {
        if (inicio != null) {
            Nodo actual = inicio;
            Nodo anterior = null;
            do {
                if (actual.dato.equals(e)) {
                    if (actual == inicio) {
                        pop();
                    } else {
                        anterior.siguiente = actual.siguiente;
                        actual.siguiente.anterior = anterior;
                        size--;
                    }
                    return;
                }
                anterior = actual;
                actual = actual.siguiente;
            } while (actual != inicio);
        }
    }
}
