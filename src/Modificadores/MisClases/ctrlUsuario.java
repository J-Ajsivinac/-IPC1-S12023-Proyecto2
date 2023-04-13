package Modificadores.MisClases;

public class ctrlUsuario {

    private static ListaSimple<Usuario> usuarios = new ListaSimple<Usuario>();

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
}
