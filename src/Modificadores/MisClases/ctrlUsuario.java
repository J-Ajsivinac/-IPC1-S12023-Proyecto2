package Modificadores.MisClases;

import Interfaz.Biblioteca;

public class ctrlUsuario {

    public static ListaSimple<Usuario> usuarios = new ListaSimple<Usuario>();

    public static int posicionUsuario(String nombre) {
        int tamano = usuarios.getSize();
        for (int i = 0; i < tamano; i++) {
            Usuario temp = (Usuario) usuarios.get(i);
            if (temp.getNombre().equals(nombre)) {
                return i;
            }
        }
        return -1;
    }

    public static boolean nuevoUsuario(String nombre) {
        if (!nombre.trim().isEmpty()) {
            usuarios.add(new Usuario(nombre));
            return true;
        }
        return false;
    }

    public static ListaSimple<Usuario> obtenerLista() {
        return usuarios;
    }

    public static boolean agregarImgCategoria(int id, int index, String img) {
        if (!img.equals("")) {
            Usuario temp = (Usuario) usuarios.get(id);
            temp.getCategoria().get(index).getImgCategoria().add(img);
            return true;
        }
        return false;
    }

    public static boolean eliminarCategoria(int id, int index) {
        Usuario temp = (Usuario) usuarios.get(id);
        if (temp != null) {
            temp.getCategoria().remove(index);
            return true;
        }
        return false;
    }

    public static Usuario buscarUsuario(String nombre) {
        int tamano = usuarios.getSize();
        for (int i = 0; i < tamano; i++) {
            Usuario temp = (Usuario) usuarios.get(i);
            if (temp.getNombre().equals(nombre)) {
                return temp;
            }
        }
        return null;
    }

    public static boolean agregarImgUsuario(int index, String nombre, String img) {
        int tamano = usuarios.getSize();
        for (int i = 0; i < tamano; i++) {
            Usuario temp = (Usuario) usuarios.get(i);
            if (temp.getNombre().equals(nombre)) {
                if (agregarImgCategoria(i, index, img)) {

                }
                return true;
            }
        }
        return false;
    }

    public static boolean eliminarImgUsuario(int index, int categoria, int posImagen) {
        Usuario temp = (Usuario) usuarios.get(index);
        if (temp != null) {
            ListaCircular imgs = temp.getCategoria().get(categoria).getImgCategoria();
            Object obEliminar = imgs.get(posImagen);
            imgs.delete(obEliminar);
            imgs.setIndex(0);
            if (imgs.getSize() == 0) {
                Biblioteca.totalI.setText(0 + "/" + imgs.getSize());
            } else {
                Biblioteca.totalI.setText(1 + "/" + imgs.getSize());
            }

            return true;
        }
        return false;
    }

    public static boolean agregarCatUsuario(int pos, String nomCategoria) {
        Usuario temp = (Usuario) usuarios.get(pos);
        if (temp != null) {
            temp.getCategoria().add(new DatosCategoria(nomCategoria));
            return true;
        }

        return false;
    }
}
